package problem.Japan.choi;

import java.util.*;

public class BombGame {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int H = Integer.parseInt(sc.next());
		int W = Integer.parseInt(sc.next());
		sc.nextLine();
		char[][] map = new char[H][W];
		String result = "YES";

		for (int i = 0; i < H; i++) {
			map[i] = sc.nextLine().toCharArray();
		}
		
		map = bombResult(map);

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j] == 'X') {
					result = "NO";
				}
			}
		}

		System.out.println(result);
	}

	public static char[][] bombResult(char[][] map) {
		int bomb = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if (map[i][j] != '#' && map[i][j] != 'X' && map[i][j] != '.' && map[i][j] != 'B') {
					bomb = (int) (map[i][j]) - 48;
					map[i][j] = 'B';
					for (int k = 1; k <= bomb; k++) {
						if ((i + k) < map.length) {
							if (map[i + k][j] == '.' || map[i + k][j] == 'X') {
								map[i + k][j] = 'B';
							} else if (map[i + k][j] == '#') {
								break;
							}
						}
					}
					for (int k = 1; k <= bomb; k++) {
						if ((j + k) < map[0].length) {
							if (map[i][j + k] == '.' || map[i][j + k] == 'X') {
								map[i][j + k] = 'B';
							} else if (map[i][j + k] == '#') {
								break;
							}
						}
					}
					for (int k = 1; k <= bomb; k++) {
						if ((i - k) >= 0) {
							if (map[i - k][j] == '.' || map[i - k][j] == 'X') {
								map[i - k][j] = 'B';
							} else if (map[i - k][j] == '#') {
								break;
							}
						}
					}
					for (int k = 1; k <= bomb; k++) {
						if ((j - k) >= 0) {
							if (map[i][j - k] == '.' || map[i][j - k] == 'X') {
								map[i][j - k] = 'B';
							} else if (map[i][j - k] == '#') {
								break;
							}
						}
					}
				}
			}
		}

		return map;
	}
}


//あなたは｢爆弾ゲーム｣を開発しています。
//このゲームは 縦 H マス、横 W マスの広さの盤面にいる敵を爆弾で倒すゲームです。
//各マスは壁, 敵, 空マスのいずれかであり、プレイヤーは空マスに爆弾を置きます。
//置いた爆弾によって敵を全滅させればクリアです。
//
//使う爆弾は爆発すると爆風が十字のように上下左右に広がり、爆風が当たると敵を倒せます。
//この爆風は敵を貫通しますが、壁で止まってしまいます。また、他の爆弾が置いてあることにより爆風が妨げられることはありません。
//
//与えられた盤面で全ての爆弾が爆発した際に、敵を全て倒せるか判定するプログラムを書いてください。
//
//例えば、入出力1の例での盤面の状態は以下の図となります。
//X が敵で、爆弾マークが配置されている爆弾を示しています。
//この爆弾に対する数字は「爆弾の火力」、すなわち爆風が届く上下左右の距離を表します。
//
//図1 
//爆風の範囲を赤色で示した図が以下になり、入力例1では爆風の届かない部分に敵が居るので全滅しません。
//図2


//入力される値
//入力は以下のフォーマットで与えられます。
//
//H W
//s_1
//s_2
//...
//s_H
//・1 行目に盤面の縦幅 H, 横幅 W が 整数 で半角スペース区切りで与えられます。
//・2 行目から続く H 行のうちの i 行目 (1 ≦ i ≦ H) には 半角記号 "# , ".", "X" および数字からなる長さ W の文字列 si が与えられます。
//・si の j 番目 (1 ≦ j ≦ W) の文字は盤面の i 行 j 列目の状態を表し、"#" は壁、"." は空マス、"X" は敵、数字は爆弾の火力を表します。
//・入力は合計 H + 1 行であり、 最終行の末尾に改行が1つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//盤面の全ての爆弾を同時に爆発させた際に敵が全滅するかどうかを "YES", "NO" で出力してください。
//
//出力の最後に改行を入れ、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・3 ≦ H, W ≦ 100
//・各 i (1 ≦ i ≦ H), j (1 ≦ j ≦ W) に対して
//　・s_{i, j} は "." (空マス) , "#" (壁) , "X" (敵) , 数字 (爆弾の火力) のいずれか
//　・s_{i, j} が 数字 (爆弾の火力) である場合, 1 ≦ s{i, j} ≦ 9 を満たす
//　・各 s_{i, j} うち X (敵) であるマスは必ず1マス以上存在する
//・盤面の外周は全て # (壁) である。すなわち以下の条件を満たす
//　・各 i (1 ≦ i ≦ H) に対して s{i, 1} と s{i, W} は "#" (壁) である
//　・各 j (1 ≦ j ≦ W) に対して s{1, j} と s{H, j} は "#" (壁) である


//入力例1
//7 7
//#######
//#X.2..#
//#.#.#.#
//#.X.1.#
//#.#1#.#
//#4....#
//#######
//出力例1
//NO
//入力例2
//6 3
//###
//#3#
//#1#
//#.#
//#X#
//###
//出力例2
//YES
//入力例3
//5 3
//###
//#2#
//###
//#X#
//###
//出力例3
//NO