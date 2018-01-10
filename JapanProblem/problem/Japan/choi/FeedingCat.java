package problem.Japan.choi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class FeedingCat {
	
	public static void checkCat(int catNum, int M, int[][] catInfo, Set<Integer> eatTimeInfo, List<Integer> catLine) {
		if (catLine.size() == catNum) {
			int catM = checkM(catNum, catInfo, catLine);
			if (catM <= M) {
				int eatTime = checkEatTime(catNum, catInfo, catLine);
				eatTimeInfo.add(eatTime);
			}
		} else {
			for (int i=0; i < catNum; i++) {
				if (!catLine.contains(i+1)) {
					List<Integer> newCatLine = new ArrayList<>(catLine);
					newCatLine.add(i+1);
					checkCat(catNum, M, catInfo, eatTimeInfo, newCatLine);
				}
			}
		}
	}
	
	public static int checkM(int catNum, int[][] catInfo, List<Integer> catLine) {
		int[] catM = new int[catNum];
		int[] catLineInfo = new int[catNum];
		int sumCatM = 0;
		
		int setNum = 0;
		for(int get : catLine) {
			catLineInfo[setNum++] = get;
		}
		
		for (int i=1; i < catNum; i++) {
			for (int j=0; j < i; j++) {
				if (catLineInfo[i] < catLineInfo[j]) {
					catM[catLineInfo[i]-1]++;
				}
			}
		}
		
		for (int i=0; i < catNum; i++) {
			sumCatM += catM[i] * catInfo[i][1];
		}
		
		return sumCatM;
	}
	
	public static int checkEatTime(int catNum, int[][] catInfo, List<Integer> catLine) {
		int eatTime = 0;
		int eatTimeSum = 0;
		int[] catLineInfo = new int[catNum];
		
		int setNum = 0;
		for(int get : catLine) {
			catLineInfo[setNum++] = get;
		}
		
		for (int i=0; i < catNum; i++) {
			eatTime += eatTimeSum + catInfo[catLineInfo[i]-1][0];
			eatTimeSum += catInfo[catLineInfo[i]-1][0];
		}
		
		return eatTime;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int catNum = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] catInfo = new int[catNum][3];
		
		for (int i=0; i < catNum; i++) {
			catInfo[i][0] = sc.nextInt(); // eating time
			catInfo[i][1] = sc.nextInt(); // dissatisfaction
		}
		
		sc.close();
		
		Set<Integer> eatTimeInfo = new HashSet<>();
		List<Integer> catLine = new ArrayList<>();
		
		checkCat(catNum, M, catInfo, eatTimeInfo, catLine);
		
		Iterator<Integer> itr = eatTimeInfo.iterator();		
		int minEatTime = itr.next();
		int checkMin = 0;
		
		while (itr.hasNext()) {
			checkMin = itr.next();
			if (minEatTime > checkMin) {
				minEatTime = checkMin;
			}
		}
		
		System.out.println(minEatTime);
	}
}


//あなたは猫カフェの運営を任されました。
//ここでの猫の食事場所は一ヶ所で、猫は一匹づつ順番に並んで食べます。
//
//この食事にかかる時間 (並んでいる時間を含む) の最中は、猫はお客さんの前に出せず非効率です。
//そこで、猫たちの食事の順序を入れ替え、猫たち全員の 食事にかかる時間の合計 を減らしましょう。
//
//並び替える対象の猫たちは 食べる時間 と 順番を抜かされた際の 不満度 を持っています。
//猫は並び変えられた際に、自分より後ろにいた猫が前に居ると、一匹ごとに持っている 不満度 分の不満を感じます。
//そして、猫たちの 合計の不満度 が M を越えると、開店時間中にサボタージュしてしまいます。
//
//猫がサボタージュしないように運営時間を伸ばす為、合計の不満度 を M 以内に収めつつ並べ替えを
//行った際の 合計の食事にかかる時間 の最小値を出力してください。
//
//
//入力例1 の例では、例えば順番を入れ替えない場合では以下のようになります。
//
//
//図1 
//
//
//同じように全ての並び方に対して、食事にかかる合計の時間 と 合計の不満度 を計算すると以下のようになります。
//
//
//図4 
//
//
//これより、入力例1 で許容される 合計の不満度 3 以下の場合、合計の食事にかかる時間 の最小値は 37 となります。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//N M
//a_1 b_1
//a_2 b_2
//...
//a_N b_N
//・1行目に猫の数 N 、許容される不満度の合計 M が整数で半角スペース区切りで与えられます。
//・2行目から続く N 行に i (1 ≦ i ≦ N) 番目の猫の食べる時間 ai と不満度 bi が整数で半角スペース区切りで与えられます。
//・入力は合計 N + 1 行であり、最終行の末尾に改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//不満度が M を越えないように並び替えた時の食事にかかる時間の合計の最小値を出力してください。
//
//出力の最後に改行を入れ、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・すべての入力は整数
//・1 ≦ N ≦ 9
//・1 ≦ M ≦ 1,000
//・各 i (1 ≦ i ≦ N) に対して
//　・1 ≦ a_i ≦ 1,000
//　・1 ≦ b_i ≦ 1,000

 
 //入力例1
//3 3
//7 3
//6 2
//5 1
//出力例1
//37
//入力例2
//9 1000
//73 4
//54 61
//73 1
//26 59
//62 35
//83 20
//4 66
//62 41
//9 31
//出力例2
//1620