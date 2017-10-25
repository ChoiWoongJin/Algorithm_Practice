package problem.Japan.choi;

import java.util.*;

public class JoggingRanking {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.next());
		int M = Integer.parseInt(sc.next());
		int T = Integer.parseInt(sc.next());
		String[][] postMon = new String[N][2];
		String[][] thisMon = new String[M][3];
		String[][] thisMonSum = new String[N][2];
		boolean[] checkName = new boolean[N];

		String[][] topPost = new String[T][3];
		String[][] topThis = new String[T][3];

		for (int i = 0; i < N; i++) {
			postMon[i][0] = sc.next();
			postMon[i][1] = sc.next();
		}
		for (int i = 0; i < M; i++) {
			thisMon[i][0] = sc.next();
			thisMon[i][1] = sc.next();
			thisMon[i][2] = sc.next();
		}

		// postMon Sort
		postMon = rangeSort(postMon, N);
		// postMon Top
		for (int i = 0; i < T; i++) {
			topPost[i][0] = postMon[i][0];
			topPost[i][1] = postMon[i][1];
		}

		// thisMon Sum
		for (int i = 0; i < N; i++) {
			thisMonSum[i][0] = "";
			thisMonSum[i][1] = "0";
			checkName[i] = false;
		}
		int check = 0;
		int sum = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (thisMonSum[j][0].equals(thisMon[i][1])) {
					sum = Integer.parseInt(thisMonSum[j][1]) + Integer.parseInt(thisMon[i][2]);
					thisMonSum[j][1] = Integer.toString(sum);
					break;
				} else if (j == N - 1) {
					thisMonSum[check][0] = thisMon[i][1];
					thisMonSum[check++][1] = thisMon[i][2];
					break;
				}
			}
		}
		
		
		int checkpoint = 0;
		for(int i=0; i<N; i++) {
			if(thisMonSum[i][0].equals("")) {
				checkpoint = i;
				break;
			} else {	
				for(int j=0; j<N; j++) {
					if( thisMonSum[i][0].equals(postMon[j][0]) ){
						checkName[j] = true;
					}
				}
			}
		}
		for(int i=0; i<N; i++) {
			if(checkName[i] == false) {
				thisMonSum[checkpoint++][0] = postMon[i][0];
			}
		}
		
		
		// thisMon Sort
		thisMonSum = rangeSort(thisMonSum, N);
		// thisMon Top
		for (int i = 0; i < T; i++) {
			topThis[i][0] = thisMonSum[i][0];
			topThis[i][1] = thisMonSum[i][1];
		}

		// compare postTop, thisTop
		for (int i = 0; i < T; i++) {
			if (topThis[i][0].equals(topPost[i][0])) {
				topThis[i][2] = "same";
			} else if (compareUp(topPost, topThis, i)) {
				topThis[i][2] = "up";
			} else if (compareDown(topPost, topThis, i)) {
				topThis[i][2] = "down";
			} else {
				topThis[i][2] = "new";
			}
		}

		for (int i = 0; i < T; i++) {
			System.out.println(topThis[i][0] + " " + topThis[i][1] + " " + topThis[i][2]);
		}

	}

	public static boolean compareUp(String[][] topPost, String[][] topThis, int i) {
		for (int j = i + 1; j < topPost.length; j++) {
			if (topThis[i][0].equals(topPost[j][0])) {
				return true;
			}
		}

		return false;
	}

	public static boolean compareDown(String[][] topPost, String[][] topThis, int i) {
		for (int j = 0; j < i; j++) {
			if (topThis[i][0].equals(topPost[j][0])) {
				return true;
			}
		}

		return false;
	}

	public static String[][] rangeSort(String[][] range, int N) {
		String[] temp = new String[2];
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (Integer.parseInt(range[i][1]) < Integer.parseInt(range[j][1])) {
					temp[0] = range[i][0];
					temp[1] = range[i][1];

					range[i][0] = range[j][0];
					range[i][1] = range[j][1];

					range[j][0] = temp[0];
					range[j][1] = temp[1];
				}
			}
		}

		return range;
	}
}



//あなたは健康になるために、部員数 N 人のジョギング部に入りました。
//ジョギング部では、個々人が好きな日にジョギングをして、その距離を記録していきます。
//また、部員のやる気向上のため、毎月ジョギングした距離の長い上位 T 人が発表されます。
//
//seiseki
//
//上の図は入力例 1 を示したものです。
//
//今月新しく上位 T 人に入ってきた人には "new"、 先月より順位が上がった人には "up"、 下がった人には "down"、 順位が変わらない人には "same"、 というラベルが付けられます。
//
//先月の走った距離は引き継がれません。 N 人分の先月の走った距離と今月のジョギングの記録が M 個与えられるので、今月の上位 T 人をラベルとともに出力してください。
//
//同じ人が複数回ジョギングした場合、順位付けにはその人が今月走った距離の合計を使います。 走った距離が同じときは、辞書順に並べたときに早い名前の方の部員を上位とします。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//N M T
//a_1 p_1
//a_2 p_2
//...
//a_N p_N
//d_1 w_1 x_1
//d_2 w_2 x_2
//...
//d_M w_M x_M
//・1 行目に部員の人数を表す整数 N、今月のジョギング記録の数を表す整数 M、成績表に表示される上位の人数を表す整数 T がこの順に半角スペース区切りで入力されます。
//・続く N 行のうち i 行目 (1 ≦ i ≦ N) に、先月のジョギング成績の i 番目に記録された部員の名前を表す文字列 a_i、その部員が先月走った距離の合計を表す整数 p_i がこの順に半角スペース区切りで入力されます。※これには先月の上位 T 人分だけではなく部員全員分の成績が含まれます。
//・続く M 行のうち j 行目 (1 ≦ j ≦ M) に、今月のジョギング記録の j 番目に記録された記録の日付を表す整数 d_j、ジョギングした部員の名前を表す文字列 w_j、その部員がその日にジョギングした距離を表す整数 x_j がこの順に半角スペース区切りで入力されます。
//・入力は合計で N + M + 1 行となり、入力値最終行の末尾に改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//今月の全ジョギング部員のジョギングの成績を以下の形式で出力してください。
//
//R_1 S_1 L_1
//R_2 S_2 L_2
//...
//R_T S_T L_T
//・期待する出力は T 行からなります。
//・出力の k 行目 (1 ≦ k ≦ T) にジョギング成績の上位から k 番目の部員の名前を表す文字列 R_k、その部員が今月ジョギングした距離の合計を表す整数 S_k、先月の順位と比べたときのラベルを表す文字列 L_k をこの順に半角スペース区切りで出力してください。
//・出力の T 行目の末尾に改行を 1 つ入れ、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・1 ≦ N ≦ 100
//・0 ≦ M ≦ 1,000
//・1 ≦ T ≦ N
//・各 i (1 ≦ i ≦ N) について、
//　・a_i は英字小文字で構成される文字列
//　・1 ≦ (a_i の長さ) ≦ 15
//　・1 ≦ p_i ≦ 10,000
//・a_1, a_2, ..., a_N はすべて互いに異なる
//・各 j (1 ≦ j ≦ M) について、
//　・1 ≦ d_j ≦ 30
//　・w_j は a_1, a_2, ..., a_n のうち、いずれかに一致する文字列
//　・1 ≦ x_j ≦ 100
//・d_1 ≦ d_2 ≦ ... ≦ d_M, すなわちジョギング記録は日付の昇順に与えられる


//入力例1
//6 7 4
//cathy 4
//eijiro 2
//alice 6
//dad 3
//betty 5
//franca 1
//2 eijiro 1
//3 alice 6
//4 alice 1
//4 franca 3
//5 cathy 7
//9 dad 2
//12 betty 4
//出力例1
//alice 7 same
//cathy 7 up
//betty 4 down
//franca 3 new
//入力例2
//3 4 3
//itiro 16
//jiro 26
//saburo 326
//1 itiro 16
//1 jiro 6
//2 jiro 26
//3 itiro 16
//出力例2
//itiro 32 up
//jiro 32 same
//saburo 0 down