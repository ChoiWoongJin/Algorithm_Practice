package problem.Japan.choi;

import java.util.Scanner;

public class GrayScaleImageReduction {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int S = N/K;
		int[][] grayScaleImage = new int[N][N];
		int[][] gsiReduction = new int[S][S];
		for(int i=0; i < N; i++) {
			for(int j=0; j < N; j++) {
				grayScaleImage[i][j] = sc.nextInt();
			}
		}
		
		int sum = 0;
		for(int i=0; i < S; i++) {
			for(int j=0; j < S; j++) {
				sum = 0;
				for(int m=i*K; m < (i+1)*K; m++ ) {
					for(int n=j*K; n < (j+1)*K; n++) {
						sum += grayScaleImage[m][n];
					}
				}
				gsiReduction[i][j] = sum/(K*K);
				if(j==0) System.out.print(gsiReduction[i][j]);
				else System.out.print(" " + gsiReduction[i][j]);
			}
			System.out.print("\n");
		}
	}
}


//あなたの手元には N × N ピクセルのグレースケール画像があります。 各ピクセルの画素値は 0 から 255 までの整数で指定されています。
//
//あなたは上司から、この画像を縦横それぞれ K 分の 1 (K は N の約数) の大きさに縮小してほしいと頼まれました。 縮小の手順を正確に述べると、次のようになります。
//
//1. 元の画像を K × K ピクセルのブロックに区切る。その結果、N/K × N/K 個のブロックができる。(図左)
//2. 各ブロックに対して、ブロックに含まれるピクセルの画素値の平均値 (小数点以下切り捨て) を計算する。(図中央)
//3. 各ブロックを新しい一つのピクセルと見なし、N/K × N/K ピクセルの画像を作る。
//　ここで、新しいピクセルの画素値は 2. で計算した平均値とする。(図右)
// 
//
//上司の期待に応えるために、上記の方法で画像を縮小するプログラムを書きましょう。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//N K
//a_11 a_12 ... a_1N
//a_21 a_22 ... a_2N
//...
//a_N1 a_N2 ... a_NN
//
//1 行目には入力される画像のサイズを表す整数 N および縮小の倍率を表す整数 K が入力されます。
//続く N 行には各ピクセルの画素値が入力されます。
//すなわち、a_ij は画像の i 行目、j 列目のピクセルの画素値を表す整数です。
//入力値最終行の末尾に改行が１つ入ります。
//
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//問題文中で与えられた縮小方法によって縮小した画像を、入力の 2 行目以降と同じフォーマットで出力してください。
//各画素値の間には空白文字を 1 つ入れ、改行の直前には空白文字を入れないことに注意してください。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//・2 ≦ K ≦ N ≦ 100
//・K は N の約数
//・0 ≦ a_ij ≦ 255


//入力例1
//6 3
//1 2 3 4 5 6
//1 2 3 4 5 6
//1 2 3 4 5 6
//4 5 6 1 2 3
//4 5 6 1 2 3
//4 5 6 1 2 3
//出力例1
//2 5
//5 2
//入力例2
//6 2
//76 251 15 224 89 129
//90 129 102 161 14 92
//78 180 218 236 47 25
//96 126 138 37 59 202
//43 213 30 105 29 195
//132 19 14 166 106 16
//出力例2
//136 125 81
//120 157 83
//101 78 86