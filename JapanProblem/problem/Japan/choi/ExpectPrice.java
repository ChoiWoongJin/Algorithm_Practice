package problem.Japan.choi;

import java.util.*;

public class ExpectPrice {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int x = Integer.parseInt(sc.next());
		int y = Integer.parseInt(sc.next());
		double k = Double.parseDouble(sc.next());
		int N = Integer.parseInt(sc.next());
		double[][] info = new double[N][4];

		for (int i = 0; i < N; i++) {
			info[i][0] = Double.parseDouble(sc.next());
			info[i][1] = Double.parseDouble(sc.next());
			info[i][2] = Double.parseDouble(sc.next());
			info[i][3] = Math.sqrt(Math.pow(x - info[i][0], 2) + Math.pow(y - info[i][1], 2));
		}

		double tempX, tempY, tempP, tempD;
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (info[i][3] > info[j][3]) {
					tempX = info[i][0];
					tempY = info[i][1];
					tempP = info[i][2];
					tempD = info[i][3];
					info[i][0] = info[j][0];
					info[i][1] = info[j][1];
					info[i][2] = info[j][2];
					info[i][3] = info[j][3];
					info[j][0] = tempX;
					info[j][1] = tempY;
					info[j][2] = tempP;
					info[j][3] = tempD;
				}
			}
		}

		double sum = 0;
		for (int i = 0; i < k; i++) {
			sum += info[i][2];
		}
		int result = (int) (sum / k) + (((int) ((sum / k) * 10) % 10) / 5);

		System.out.println(result);

	}
}

//あなたは不動産の投資家をしています。
//
//あなたは、地元の地価に関する情報を用いて地価の予測ができるのではないかと考えました。
//
//そこで、データサイエンティストの友達にたずねると、k-近傍法という 方法について教えてもらいました。
//
//k-近傍法は以下の通りです。
//
//ある地点 A (x, y) での地価を求めたいとします。 まず、地価が既知である点について、 A (x, y) からの距離が近い順に k 個の点を見つけます。 その k 点の地価の平均が予測する地価の値となります。
//
// 
//
//なお、地点 A (x, y) からある地点 (x_i, y_i) までの距離は以下のように計算できます。
//
// 
//
//自然数 k と、すでに地価がわかっている N 個 (k ≦ N) の各地点について座標および地価が与えられたとき、地点 A (x, y) における予測した地価を出力してください。
//
//ただし、A からの距離が同じ点はないものとします。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//x y
//k
//N
//x_1 y_1 p_1
//x_2 y_2 p_2
//...
//x_N y_N p_N
//
//・1 行目には A の座標が x 座標、y 座標の順に半角スペース区切りで与えられます。
//・2 行目には問題文の k-近傍法で用いる k が与えられます。
//・3 行目には入力される地価が既知である点の総数 N が与えられます。
//・続く N 行のうち i 行目 (1 ≦ i ≦ N) には、地価が既知である点の x 座標 x_i、y 座標 y_i、および地価 p_i がこの順に半角スペース区切りで与えられます。
//・入力は合計で N + 3 行となり、最終行の末尾に改行が一つ入ります。
//
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//問題文の k-近傍法を用いて予測した地点 A (x, y) における地価の値を、小数点以下を四捨五入して整数で出力してください。
//
//出力の最後に改行を一つ入れ、余計な文字、空行を含んではいけません。



//条件
//すべてのテストケースで以下の条件を満たします。
//
//添字の範囲は 1 ≦ i ≦ N とします。
//
//・与えられる数値はすべて整数
//・2 ≦ N ≦ 100
//・1 ≦ k ≦ N
//・0 ≦ x, y ≦ 1000
//・0 ≦ x_i, y_i ≦ 1000
//・1 ≦ p_i ≦ 100


//入力例1
//4 3
//3
//7
//4 4 10
//5 4 60
//6 3 20
//2 1 30
//8 1 50
//1 6 40
//3 6 70
//出力例1
//30
//入力例2
//0 0
//1
//3
//0 2 4
//1 1 5
//1 2 6
//出力例2
//5