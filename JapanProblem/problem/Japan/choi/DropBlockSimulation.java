package problem.Japan.choi;

import java.util.*;

public class DropBlockSimulation {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int H = Integer.parseInt(sc.next());
		int W = Integer.parseInt(sc.next());
		int N = Integer.parseInt(sc.next());
		char[][] field = new char[H][W];
		int[][] block = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				block[i][j] = Integer.parseInt(sc.next());
			}
		} // block Information Set
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				field[i][j] = '.';
			}
		} // field Basic Set

		for (int i = 0; i < N; i++) {
			field = checkBlock(field, block[i][0], block[i][1], block[i][2]);
		} // field Result Set

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(field[i][j]);
			}
			System.out.print("\n");
		} // field Print out
	}

	public static char[][] checkBlock(char[][] field, int blockH, int blockW, int blockX) {
		int check = 1;

		for (int i = (field.length - 1); i >= 0; i--) {
			for (int w = blockX; w < (blockX + blockW); w++) {
				if (field[i][w] == '#' && check == 1) {
					check = 0;
					break;
				}
				for (int h = i; h >= 0; h--) {
					if (field[h][w] == '#') {
						check = 0;
						break;
					}
				}
			}

			if (check == 1) {
				// Set block to field
				for (int h = i; h > i - blockH; h--) {
					for (int w = blockX; w < (blockW + blockX); w++) {
						field[h][w] = '#';
					}
				}
				break;
			} else if (check == 0) {
				check = 1;
			}

		}

		return field;
	}
}

//プログラミングが大好きなあなたは、自作の落ちものゲームを開発することにしました。 ゲームの仕様は次のようになっています。
//
//・ゲームは縦幅 H、横幅 W の長方形のフィールドで行われます。
//・ゲームが始まると、様々なサイズの長方形がフィールドの上方から一つずつ順番に落ちてきます。
//・落ちてくる長方形の直下に他の長方形もしくはフィールドの底辺がある場合、接触したとみなして長方形の位置は固定されます。
//
// 
//手始めに、上記の仕様に従って落ちてくる長方形の動きをシミュレーションしましょう。
//N 個の長方形が落ちてきた後のフィールドの状態を表示するプログラムを書いてください。


//入力される値
//H W N
//h_1 w_1 x_1
//h_2 w_2 x_2
//...
//h_N w_N x_N
//・1 行目には 3 つの整数 H, W, N がこの順に半角スペース区切りで与えられます。
//　H はフィールドの縦幅を、W はフィールドの横幅を、 N は落ちてくる長方形の個数を表します。
//・続く N 行のうち i 行目 (1 ≦ i ≦ N) には i 番目に落ちてくる長方形のサイズと落ちてくる位置の情報が入力されます。
//　ここではこの長方形の縦幅 h_i、横幅 w_i、長方形の左端とフィールドの左端の距離 x_i がこの順に半角スペース区切りで与えられます (問題文中の図を参照)。
//・入力は合計で N + 1 行であり、入力最終行の最後に改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//N 個の長方形がすべて落ちた後のフィールドの状態を、以下のフォーマットで出力してください。
//f_1
//f_2
//...
//f_H
//
//・期待する出力は H 行からなります。
//・出力の i 行目 (1 ≦ i ≦ H) にフィールドの上端から距離 i の各地点の状態を表す長さ W の文字列 f_i を出力してください。
//　　f_i の j 番目 (1 ≦ j ≦ W) の文字は、フィールドの上端、左端からの距離が i, j となる地点の状態を表し、ここにブロックがあるときは "#"、ないときは "." となります。
//・出力の H 行目の最後に改行を 1 つ入れ、余計な文字、空行を含んではいけません。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//添字の範囲は 1 ≦ i ≦ N とする。
//
//・入力されるすべての値は整数
//・1 ≦ H, W, N ≦ 30
//・1 ≦ h_i ≦ H
//・1 ≦ w_i ≦ W
//・0 ≦ x_i ≦ W - w_i
//・N 個の長方形はすべてフィールド内に収まる


//入力例1
//7 10 4
//1 8 1
//4 1 5
//1 6 2
//2 2 0
//出力例1
//..........
//..######..
//.....#....
//.....#....
//##...#....
//##...#....
//.########.
//入力例2
//10 10 9
//2 2 4
//2 2 3
//2 2 5
//2 2 2
//2 2 6
//2 2 1
//2 2 7
//2 2 0
//2 2 8
//出力例2
//##......##
//##......##
//.##....##.
//.##....##.
//..##..##..
//..##..##..
//...####...
//...####...
//....##....
//....##....