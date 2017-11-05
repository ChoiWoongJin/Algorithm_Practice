package problem.Japan.choi;

import java.util.*;

public class RobotWalkingTest {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int sp_x = sc.nextInt();
		int sp_y = sc.nextInt();
		int move_forward = sc.nextInt();
		int move_right = sc.nextInt();
		int move_backward = sc.nextInt();
		int move_left = sc.nextInt();
		int mCN = sc.nextInt(); // move Command Num
		char[][] move_command = new char[mCN][2];
		// [][0] - m : move, t : turn
		// [][1] - F : forward, R : right, L : left, B : Backward
		for (int i = 0; i < mCN; i++) {
			move_command[i][0] = sc.next().charAt(0);
			move_command[i][1] = sc.next().charAt(0);
		}

		int current_state = 0;
		// 0 : F
		// 1 : R
		// 2 : B
		// 3 : L

		for (int i = 0; i < mCN; i++) {
			if (move_command[i][0] == 'm') { // move command
				if (move_command[i][1] == 'F') { // move forward
					if(current_state == 0) {
						sp_y += move_forward;
					} else if(current_state == 1) {
						sp_x += move_forward;
					} else if(current_state == 2) {
						sp_y -= move_forward;
					} else if(current_state == 3) {
						sp_x -= move_forward;
					}
				} else if (move_command[i][1] == 'R') { // move right
					if(current_state == 0) {
						sp_x += move_right;
					} else if(current_state == 1) {
						sp_y -= move_right;
					} else if(current_state == 2) {
						sp_x -= move_right;
					} else if(current_state == 3) {
						sp_y += move_right;
					}
				} else if (move_command[i][1] == 'B') { // move backward
					if(current_state == 0) {
						sp_y -= move_backward;
					} else if(current_state == 1) {
						sp_x -= move_backward;
					} else if(current_state == 2) {
						sp_y += move_backward;
					} else if(current_state == 3) {
						sp_x += move_backward;
					}
				} else if (move_command[i][1] == 'L') { // move left
					if(current_state == 0) {
						sp_x -= move_left;
					} else if(current_state == 1) {
						sp_y += move_left;
					} else if(current_state == 2) {
						sp_x += move_left;
					} else if(current_state == 3) {
						sp_y -= move_left;
					}
				}
			} else if (move_command[i][0] == 't') { // turn command
				if (move_command[i][1] == 'R') { // turn right
					current_state = (current_state + 1)%4;
				} else if (move_command[i][1] == 'B') { // turn backward
					current_state = (current_state + 2)%4;
				} else if (move_command[i][1] == 'L') { // turn left
					current_state = current_state - 1;
					if( current_state == -1) {
						current_state = 3;
					}
				}
			}
			if(sp_x < -1000) {
				sp_x = -1000;
			} else if(sp_x > 1000) {
				sp_x = 1000;
			}
			if(sp_y < -1000) {
				sp_y = -1000;
			} else if(sp_y > 1000) {
				sp_y = 1000;
			}			
		}

		System.out.println(sp_x + " " + sp_y);

	}
}



//この研究所では精鋭ぞろいのチームによって二足歩行ロボットの開発が行われています。ロボットの各個体は最大 4 方向への移動が可能となっています。しかし 1 歩でどの方向にどれだけ動くかは個体によってまちまちです。
//
//これからロボットの歩行動作の実験を行います。ある個体が正しく動作しているかどうかの確認のためには、一連の命令を与えたのちこの個体が理論上どこに移動しているかを求めるプログラムを作成する必要があります。この研究所のエンジニアであるあなたはこの作成を任されました。
//
//
//歩行実験は下図のようなコマで区切られた盤上で行います。実験対象の個体の移動領域として個体から見て前方向、右方向、後方向、左方向の順に 1 歩で何コマ動くかが与えられます。
//
//はじめの状態ではロボットは必ず y 座標の正方向 (下図の上方向) を向いています。ロボットが向いている方向が「前方向」となり、そこから時計回りに 90 度ずつ進めた方向がそれぞれ「右方向」、「後方向」、「左方向」となります。
//
//命令は「◯方向に1歩動く」あるいは「◯方向に方向転換する」のいずれかで与えられます。ただし、「前方向に方向転換する」という命令は無意味なので与えられません。
//
//
//例) 
//
//開始地点: (2, 2) 
//移動領域: 2, 1, 1, 1 (前方に 1 歩動く際には 2 コマ、他の方向に 1 歩動く際には 1 コマ動く) 
//命令: 
//「前方向に 1 歩動く」 → 「右方向に方向転換する」 → 「前方向に 1 歩動く」 → 
//「前方向に 1 歩動く」 → 「後方向に方向転換する」 → 「左方向に 1 歩動く」 → 
//「左方向に 1 歩動く」 → 「後方向に 1 歩動く」 
//
//→ 到達地点: (7, 2)
//
//
//
//なお実際の命令は命令の種類を表す文字と方向を表す文字の組で表現されます。
//
//命令の種類を表す文字: 移動 → "m"、方向転換 → "t"
//方向を表す整数: 前 → "F"、右 → "R"、後 → "B"、左 → "L"
//
//例の場合、実際の命令は
//
//m F
//t R
//m F
//m F
//t B
//m L
//m L
//m B
//
//
//のようになります。これは入力例 1 に対応しています。
//
//実験の成否はあなたの手にかかっています。正確なプログラムの完成を目指してください。



//入力される値
//入力は以下のフォーマットで与えられます。
//
//s_x s_y
//d_f d_r d_b d_l
//N
//e_1 c_1
//e_2 c_2
//...
//e_N c_N
//
//
//・1 行目にはそれぞれ開始地点の x 座標、y 座標を表す整数 s_x, s_y がこの順に半角スペース区切りで与えられます。
//・2 行目にはそれぞれ実験対象のロボットの前方向、右方向、後方向、左方向への 1 歩の移動コマ数を表す整数 d_f, d_r, d_b, d_l がこの順に半角スペース区切りで与えられます。
//・3 行目には命令の個数を表す整数 N が与えられます。
//・続く N 行のうち i 行目 (1 ≦ i ≦ N) について命令の種類、内容を表す文字 e_i, c_i がこの順に半角スペース区切りで与えられます。
//　・命令の種類が「移動」のとき e_i は "m"、「方向転換」の場合は "t" となります。
//　・命令が「移動」のとき c_i は移動方向を表し、命令が「方向転換」のとき c_i は転換する方向を表します。これらは前方向、右方向、後方向、左方向の順に "F", "R", "B", "L" で表されます。
//・入力は合計で N + 3 行となり、入力値最終行の末尾に改行が１つ入ります。
//
//
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//g_x g_y
//・ロボットの理論上の到達地点の x 座標、y 座標をこの順に半角スペース区切りで出力してください。
//・最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//・-1,000 ≦ s_x, s_y ≦ 1,000
//・0 ≦ d_f, d_r, d_b, d_l ≦ 10
//・0 ≦ N ≦ 1,000
//・各 i (1 ≦ i ≦ N) について
//　・e_i は英字小文字で "m", "t" のいずれか
//　・c_i は英字大文字で "F", "R", "B", "L" のいずれか 
//　・e_i = "t" のとき c_i ≠ "F", すなわち「前方向に方向転換する」という命令は与えられない



//入力例1
//2 2
//2 1 1 1
//8
//m F
//t R
//m F
//m F
//t B
//m L
//m L
//m B
//出力例1
//7 2
//入力例2
//621 -855
//2 6 3 6
//19
//t L
//t L
//t R
//m L
//m B
//t R
//t L
//t L
//t B
//t B
//m R
//t B
//m R
//t R
//t L
//t B
//m L
//m R
//t L
//出力例2
//624 -861入力例1
//2 2
//2 1 1 1
//8
//m F
//t R
//m F
//m F
//t B
//m L
//m L
//m B
//出力例1
//7 2
//入力例2
//621 -855
//2 6 3 6
//19
//t L
//t L
//t R
//m L
//m B
//t R
//t L
//t L
//t B
//t B
//m R
//t B
//m R
//t R
//t L
//t B
//m L
//m R
//t L
//出力例2
//624 -861