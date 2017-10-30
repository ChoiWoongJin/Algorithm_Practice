package problem.Japan.choi;

import java.util.*;

public class IceDungeon {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int H = Integer.parseInt(sc.next());
		int W = Integer.parseInt(sc.next());
		char[][] map = new char[H][W];
		for (int i = 0; i < H; i++) {
			map[i] = sc.next().toCharArray();
		}

		int s_y = Integer.parseInt(sc.next()) - 1;
		int s_x = Integer.parseInt(sc.next()) - 1;
		int N = Integer.parseInt(sc.next());
		char[] direction = new char[N];
		String getDir = "";
		for (int i = 0; i < N; i++) {
			getDir += sc.next();
		}
		direction = getDir.toCharArray();

		boolean check = true;
		for (int i = 0; i < N; i++) {
			if (direction[i] == 'U') {
				while (check) {
					if ((s_x - 1) >= 0) {
						if (map[s_x - 1][s_y] == '.') {
							s_x--;
							break;
						} else if (map[s_x - 1][s_y] == '#') {
							s_x--;
						}
					} else {
						break;
					}
				}
			} else if (direction[i] == 'D') {
				while (check) {
					if ((s_x + 1) < H) {
						if (map[s_x + 1][s_y] == '.') {
							s_x++;
							break;
						} else if (map[s_x + 1][s_y] == '#') {
							s_x++;
						}
					} else {
						break;
					}
				}
			} else if (direction[i] == 'L') {
				while (check) {
					if ((s_y - 1) >= 0) {
						if (map[s_x][s_y - 1] == '.') {
							s_y--;
							break;
						} else if (map[s_x][s_y - 1] == '#') {
							s_y--;
						}
					} else {
						break;
					}
				}
			} else if (direction[i] == 'R') {
				while (check) {
					if ((s_y + 1) < W) {
						if (map[s_x][s_y + 1] == '.') {
							s_y++;
							break;
						} else if (map[s_x][s_y + 1] == '#') {
							s_y++;
						}
					} else {
						break;
					}
				}
			}
		}
		s_x++;
		s_y++;

		System.out.println(s_y + " " + s_x);

	}
}

//H × W の格子形状で表されるダンジョンを探検しましょう。
//
//このダンジョンの各マスには、氷の床または土の床が存在し、周囲は壁で囲まれています。 あなたは初めに土の床のあるマスにいて、これから N 回の移動を試みることになりました。
//
//このダンジョンでは氷の床に足を踏み入れると、 土の床のマスにくるか壁にぶつかるまで、足を出した方向に滑り続けてしまいます。 N 回の各移動の方向が与えられるので、 N 回の移動を終えた後にあなたがいるマスの座標を答えてください。
//
//なお、 座標値の y が大きくなる方向を下、 x が大きくなる方向を右であるとします。
//
//入力例1は以下のようになります。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//H W
//g_1
//g_2
//...
//g_H
//s_x s_y
//N
//d_1
//d_2
//...
//d_N
//
//・1 行目には、ダンジョンの縦の長さと横の長さを表す H, W がこの順に半角スペース区切りで与えられます。
//・続く H 行のうち i 行目 (1 ≦ i ≦ H) にダンジョンの情報を表す文字列 g_i が与えられます。
//　・g_i の j 番目 (1 ≦ j ≦ W) の文字が座標 (j, i) のマスにある床の種類を表し、”#” であれば氷の床、”.” であれば土の床を表します。
//・次の行には、あなたが最初にいるマスの x 座標、y 座標を表す s_x, s_y がこの順に半角スペース区切りで与えられます。
//・次の行には、移動の回数 N が与えられます。
//・続く N のうち k 行目 (1 ≦ k ≦ H) に各移動の方向を表す文字が与えられます。
//　・d_k (1 ≦ k ≦ N) は ”U”, ”R”, ”D”, ”L” のいずれかであり、それぞれ上、右、下、左への移動であることを表します。
//　・ただし、 座標値の y が小さくなる方向を上、 x が大きくなる方向を右であるとします。
//・入力は合計で H + N + 3 行となり、入力値最終行の末尾に改行が１つ入ります。
//
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください



//期待する出力
//N 回の移動を終えた後にあなたがいるマスの座標 (x, y) を
//
//x y
//
//のように半角スペース区切りで出力してください。
//
//出力の最後に改行を一つ入れ、余計な文字、空行を含んではいけません。



//条件
//すべてのテストケースで以下の条件を満たします。
//
//各添字の範囲は 1 ≦ i ≦ H, 1 ≦ j ≦ W, 1 ≦ k ≦ N とする。
//
//・H, W, s_x, s_y, N は整数
//・g_i は半角記号 ”#” および ”.” で構成される文字列
//・d_k は英字大文字で ”U”, ”R”, ”D”, ”L” のいずれか
//・3 ≦ H, W ≦ 100
//・(g_i の長さ) = W
//・1 ≦ s_x ≦ W
//・1 ≦ s_y ≦ H
//・g_s_y の s_x 番目の文字は必ず ”.” である (最初にいるマスは必ず土の床である)
//・1 ≦ N ≦ 100


//入力例1
//5 5
//.###.
//#.#.#
//##..#
//..##.
//##..#
//3 3
//5
//U
//R
//D
//L
//U
//出力例1
//2 2
//入力例2
//10 10
//#.#.######
//..##...###
//##.#.###.#
//#.#.#...##
//....##..#.
//...#..#...
//..#.##.###
//..#.#.#.#.
//.##...#.##
//...#..#.##
//3 3
//5
//D
//D
//L
//D
//U
//出力例2
//2 6
 