package problem.Japan.choi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class CreateTimetable {
	private int N;
	private String[] name;
	private int[] time;
	private List<String> timetable;
	private static final String timeDivision = " - ";
	private static final int restTime = 10;
	private static final int launchTime = 60;
	
	CreateTimetable(int N, String[] name, int[] time) {
		this.N = N;
		this.name = name.clone();
		this.time = time.clone();
		this.timetable = new ArrayList<String>();
		
		createTimeTable();
	}
	
	private void createTimeTable() {
		StringBuffer sb = new StringBuffer();
		int currentTimeHour = 10, currentTimeMinut = 0;
		boolean bCheckLaunchTime = true;
		
		for(int i=0; i < this.N; i++) {
			sb.setLength(0);
			
			sb.append(Integer.toString(currentTimeHour)).append(":");
			if(currentTimeMinut < 10) {
				sb.append("0").append(Integer.toString(currentTimeMinut));
			} else {
				sb.append(Integer.toString(currentTimeMinut));
			}
			
			sb.append(timeDivision);
			
			currentTimeHour = currentTimeHour + (currentTimeMinut + time[i])/launchTime;
			currentTimeMinut = (currentTimeMinut + time[i])%launchTime;
			
			sb.append(Integer.toString(currentTimeHour)).append(":");
			if(currentTimeMinut < 10) {
				sb.append("0").append(Integer.toString(currentTimeMinut));
			} else {
				sb.append(Integer.toString(currentTimeMinut));
			}
			
			sb.append(" ").append(this.name[i]);
			
			this.timetable.add(sb.toString());
			
			// check restTime
			if(i < this.N-1 && bCheckLaunchTime == true && currentTimeHour + (currentTimeMinut + restTime + this.time[i+1])/launchTime >= 12 && (currentTimeMinut + restTime + this.time[i+1]) > launchTime) {
				bCheckLaunchTime = false;
				currentTimeHour++;
			} else {
				currentTimeHour = currentTimeHour + (currentTimeMinut + restTime)/launchTime;
				currentTimeMinut = (currentTimeMinut + restTime)%launchTime;
			}
		}
		
	}
	
	public List<String> getTimetable() {
		return this.timetable;
	}
	public void printTimetable() {
		Iterator<String> itr = this.timetable.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}

public class CreateTimetableForConferences {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] name = new String[N];
		int[] time = new int[N];
		for(int i=0; i < N; i++) {
			name[i] = sc.next();
			time[i] = sc.nextInt();
		}
		
		CreateTimetable ct = new CreateTimetable(N, name, time);
		ct.printTimetable();		

		sc.close();
	}

}


//あなたは、とある勉強会の主催者です。 発表者を募ったところN 人の有志が集まったため、
//それぞれの発表者の持ち時間と発表順序を決めました。
//あとは、以下のルールを用いて当日のタイムテーブルを作成するだけです。
//1. 10:00に1人目のトークを始めます。
//2. 現在のトークが終了し10分休憩の後、次のトークを始めます。
//3. すべての発表者のトークが終了するまで2. を繰り返します。
//
//ただし、次のような例外ルールが存在します。
//
//発表予定者のトーク終了予定時刻（現在の発表者の終了時刻 + 10分休憩 + 次の発表者の持ち時間）が12:01 以降になる場合においては、現在のトークが終了後、10分休憩の代わりに1時間のお昼休憩を一度だけとります。
//
//例：jobsさんが45分、gatesさんが60分、larryさんが15分のトークをするタイムテーブル
//時間	発表者
//10:00〜10:45	jobs(45分)
//10:45〜10:55	休憩時間(10分)
//10:55〜11:55	gates(60分)
//11:55〜12:55	お昼休み(60分)
//12:55〜13:10	larry(15分)
//発表者の数N と発表者の情報として名前と持ち時間が発表順序で与えられるので、上記ルールに従ったタイムテーブルを出力してください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//１行目は発表者数が入力されます。
//２行目からN+1行目まで各発表者の名前と発表時間がスペースで区切で入力されます。
//
//N(発表者数)
//s_1(一人目の発表者名) a_1(一人目の発表時間)
//s_2(二人目の発表者名) a_2(二人目の発表時間)
//...
//s_N(N人目の発表者名) a_N(N人目の発表時間)
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//タイムテーブルを以下のフォーマットに従って出力してください。
//
//発表の時刻をt_i、発表の終了時刻をe_i、発表者名をs_iとして、
//「t_i{半角スペース}-{半角スペース}e_i{半角スペース}s_i」の形式で、
//t_iとe_iの表記は時と分を「:」区切り、各数字は0埋め2桁の数字で出力して下さい。
//
//t_1(一人目の開始時刻10:00) - e_1(一人目の終了時刻) s_1(一人目の発表者名)
//t_2(二人目の開始時刻) - e_2(二人目の終了時刻) s_2(二人目の発表者名)
//...
//t_n(N人目の開始時刻) - e_n(N人目の終了時刻) s_n(N人目の発表者名)
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//1 ≦ N(発表者数) ≦ 10
//1 ≦ |s_i|(発表者の名前の長さ) ≦ 10
//1 ≦ a_i(発表時間) ≦ 60
//s_i(発表者名) は英小文字のみで構成される。


//入力例1
//3
//jobs 45
//gates 60
//larry 15
//出力例1
//10:00 - 10:45 jobs
//10:55 - 11:55 gates
//12:55 - 13:10 larry
//入力例2
//4
//r 51
//yshwgfdci 12
//elqbndnbye 54
//lg 47
//出力例2
//10:00 - 10:51 r
//11:01 - 11:13 yshwgfdci
//12:13 - 13:07 elqbndnbye
//13:17 - 14:04 lg
//入力例3
//2
//vkdjh 21
//yoboqmetph 37
//出力例3
//10:00 - 10:21 vkdjh
//10:31 - 11:08 yoboqmetph