package problem.Japan.choi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class CheckOffside {
	private char teamName;
	private int passNumber;
	private int[] teamXPositionA;
	private int[] teamXPositionB;
	private int checkEnermyPosition;
	private List<Integer> offsidePlayer;
	
	CheckOffside(char teamName, int passNumber, int[] teamXPosition, int[] teamXPositionEnermy) {
		this.teamName = teamName;
		this.passNumber = passNumber;
		this.teamXPositionA = teamXPosition.clone();
		this.teamXPositionB = teamXPositionEnermy.clone();
		this.offsidePlayer = new ArrayList<>();
		
		checkOffside();		
	}
	
	private void checkOffside() {
		checkEnermy();

		if(this.teamName == 'A') {
			for(int i=0; i < this.teamXPositionA.length; i++) {
				if(i != this.passNumber-1) {
					if(this.teamXPositionA[i] > 55) { // case 2
						if(this.teamXPositionA[i] > this.teamXPositionA[this.passNumber-1]) { // case 3
							if(this.teamXPositionA[i] > this.checkEnermyPosition) { // case 4
								this.offsidePlayer.add(i+1);
							}
						}
					}
				}
			}
		} else {
			for(int i=0; i < this.teamXPositionB.length; i++) {
				if(i != this.passNumber-1) {
					if(this.teamXPositionB[i] < 55) { // case 2
						if(this.teamXPositionB[i] < this.teamXPositionB[this.passNumber-1]) {  // case 3
							if(this.teamXPositionB[i] < this.checkEnermyPosition) { // case 4
								this.offsidePlayer.add(i+1);
							}
						}
					}
				}
			}
		}		
	}
	
	private void checkEnermy() {
		int check = 55, secondPlayerPosition = 55;
		if(this.teamName == 'A') {
			for(int i=0; i < this.teamXPositionB.length; i++) {
				if(check < this.teamXPositionB[i]) {
					check = this.teamXPositionB[i];
				}
			}
			for(int i=0; i < this.teamXPositionB.length; i++) {
				if(check != this.teamXPositionB[i] && secondPlayerPosition < this.teamXPositionB[i]) {
					secondPlayerPosition = this.teamXPositionB[i];
				}
			}
		} else {
			for(int i=0; i < this.teamXPositionA.length; i++) {
				if(check > this.teamXPositionA[i]) {
					check = this.teamXPositionA[i];
				}
			}
			for(int i=0; i < this.teamXPositionA.length; i++) {
				if(check != this.teamXPositionA[i] && secondPlayerPosition > this.teamXPositionA[i]) {
					secondPlayerPosition = this.teamXPositionA[i];
				}
			}
		}

		this.checkEnermyPosition = secondPlayerPosition;
	}
	
	public void printOffsidePlayer() {
		if(this.offsidePlayer.size() == 0) {
			System.out.println("None");
		} else {
			for(int i=0; i < this.offsidePlayer.size(); i++) {
				System.out.println(this.offsidePlayer.get(i));
			}
		}
	}
}

public class OffsideJudgeAboutSoccer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char teamName = sc.next().charAt(0);
		int passNumber = sc.nextInt();
		int soccerPlayerNum = 11;
		int[] teamXPositionA = new int[soccerPlayerNum]; 
		for(int i=0; i < soccerPlayerNum; i++) {
			teamXPositionA[i] = sc.nextInt();
		}
		int[] teamXPositionBy = new int[soccerPlayerNum]; 
		for(int i=0; i < soccerPlayerNum; i++) {
			teamXPositionBy[i] = sc.nextInt();
		}
		
		CheckOffside co = new CheckOffside(teamName, passNumber, teamXPositionA, teamXPositionBy);
		co.printOffsidePlayer();
		
		sc.close();
	}

}


//サッカーにはオフサイドの誤審判定という、試合に大きな影響を与える可能性がある問題が存在します。 次のパスでボールを受け取るとオフサイドと判定される選手を教えてくれるプログラムを作成し、審判をサポートしましょう。
//次の4つの条件を満たした選手は、オフサイドと判定されます。 (実際のサッカーではもう少しルールが複雑ですが、今回は以下の条件のみを考慮してください)
//
//
//1. 味方チームの選手からのパスを受け取る。
//2. パスを受け取る選手が敵チームの陣にいる。
//3. 「パスを出した選手」よりも、敵チームのゴールラインの近くにいる。
//　　(パスを出した選手とx座標が同じなら、オフサイドにならない)
//4. 「敵チームのゴールラインから2人目の敵チームの選手」よりも、敵チームのゴールラインの近くにいる。
//　　(2番目の選手とx座標が同じなら、オフサイドにならない)
//
//今回はチームAとチームBの試合を考えます。 チームAの陣はx座標が0以上55以下の位置で、ゴールラインはx座標が0の位置、 チームBの陣はx座標が55以上110以下の位置で、ゴールラインはx座標が110の位置です。
//
//図1では、チームAの選手3 (図1:A-3)からのパスをチームAの選手5 (図:A-5)が受け取ると、チームAの選手5はオフサイドと判定されます。 これは、チームAの選手5が上で挙げた4つの条件を満たすためです。 
//
//図1
//offside figure1
//
//
//また、図2のチームAの選手 (図2:A-5,A-6,A-11)のように、パスを受け取るとオフサイドと判定される選手が複数人いる場合もあります。
//
//図2 
//offside figure2


//入力される値
//サッカーの試合状況が次の形式で与えられます。
//
//1行目では、パスを出す選手のチーム名Tと背番号Uが半角スペース区切りで与えられます。
//2行目では、チームAの背番号iの選手のx座標XA_iが、i=1からi=11まで順番に半角スペース区切りで与えられます。
//同様に3行目では、チームBの背番号jの選手のx座標XB_jが、j=1からj=11まで順番に半角スペース区切りで与えられます。
//
//値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//与えられたサッカーの試合状況に対して、次のパスを受け取るとオフサイドと判定される選手の背番号を小さいものから順に
//1行ずつ出力してください。
//オフサイドと判定される選手がいない場合には、"None"と1行で出力してください。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//Tは'A'か'B'のいずれか1文字
//1 ≦ U ≦ 11, Uは整数
//0 ≦ XA_i ≦ 110, XA_iは整数で、iは1以上11以下の整数
//0 ≦ XB_j ≦ 110, XB_jは整数で、jは1以上11以下の整数


//入力例1(この例は問題文中の図1に対応しています)
//A 3
//18 44 69 31 90 72 48 29 55 37 78
//103 85 39 55 51 8 80 37 21 65 54
//出力例1
//5
//入力例2(この例は問題文中の図2に対応しています)
//A 3
//18 41 63 30 84 95 67 29 71 48 91
//96 77 40 67 49 75 76 31 19 60 47
//出力例2
//5
//6
//11
//入力例3(この例はチームBの選手がパスを出します)
//B 7
//86 36 55 88 10 82 53 107 83 22 15
//69 38 48 73 21 50 27 1 41 24 103
//出力例3
//8
//入力例4(この例は2つ目の条件を満たさしていません)
//B 10
//69 41 96 89 53 42 83 95 48 4 25
//100 71 90 59 86 97 84 85 79 81 98
//出力例4
//None
//入力例5(この例は4つ目の条件を満たしていません)
//A 3
//18 44 69 31 70 72 48 29 55 37 78
//103 85 39 55 51 8 80 37 21 65 54
//出力例5
//None