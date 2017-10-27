package problem.Japan.choi;

import java.util.*;

public class TableGenerator {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int W = Integer.parseInt(sc.next());
		String[] attribute = new String[W];
		int[] attrMax = new int[W];
		for (int i = 0; i < W; i++) {
			attribute[i] = sc.next();
			attrMax[i] = attribute[i].length();
		}

		int H = Integer.parseInt(sc.next());
		String[][] tuple = new String[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tuple[i][j] = sc.next();
			}
		}

		for (int i = 0; i < W; i++) {
			for (int j = 0; j < H; j++) {
				if (attrMax[i] < tuple[j][i].length()) {
					attrMax[i] = tuple[j][i].length();
				}
			}
		}

		for (int i = 0; i < W; i++) {
			if (i == 0) {
				System.out.print("|");
			}
			System.out.print(" ");
			System.out.print(attribute[i]);
			for (int j = 0; j <= (attrMax[i] - attribute[i].length()); j++) {
				System.out.print(" ");
			}
			System.out.print("|");
		}
		System.out.print("\n");

		for (int i = 0; i < W; i++) {
			if (i == 0) {
				System.out.print("|");
			}
			System.out.print("-");
			for (int j = 0; j <= attrMax[i]; j++) {
				System.out.print("-");
			}
			System.out.print("|");
		}
		System.out.print("\n");

		for (int j = 0; j < H; j++) {
			for (int i = 0; i < W; i++) {
				if (i == 0) {
					System.out.print("|");
				}
				System.out.print(" ");
				System.out.print(tuple[j][i]);
				for (int k = 0; k <= (attrMax[i] - tuple[j][i].length()); k++) {
					System.out.print(" ");
				}
				System.out.print("|");
			}
			System.out.print("\n");
		}

	}
}

//見出しの情報と各行の情報から見やすい表を生成するプログラムをつくりましょう。テンプレートは以下のようになります。
//
//
//| header 1 | header 2    | ... | header n |  (見出し行)
//|----------|-------------| ... |----------|  (区切り行)
//| xx       | xxxxxxx     | ... | XX       |  (データ行)
//| yyyy     | yyyyyyyyyyy | ... | YY       |  (データ行)
//...					      ...
//| zzz      | zzzzzzz     | ... | ZZ       |  (データ行)
//
//[テンプレートの説明]
//※ 表の作成には等幅のフォントを用います。すなわちこの表で使われる文字の文字幅はすべて等しくなります。
//
//・表の 1 行目を見出し行、2 行目を区切り行、 3 行目以降をデータ行とよびます。 
//・表の各見出し・データを格納する部分は "| xxx |" のように縦棒 2 つの間に見出し・データが入り、見出し・データの前にちょうど 1 つ、後ろに 1 つ以上半角スペースが入る形にします。
//・各列の幅はその列の中で最も長さの大きい見出し・データが上記の形で収まる最小の幅 (見出し・データの前後にちょうど 1 つずつ半角スペースが入れられる幅) にします。
//・区切り行は縦棒を除きハイフンで埋めます。
//
//例）
//見出し: id, name 
//各行のデータ: 
//1 ito
//2 sakakibara
//3 takahashi
//
//このとき生成する表は以下のようになります。
//
//| id | name       |
//|----|------------|
//| 1  | ito        |
//| 2  | sakakibara |
//| 3  | takahashi  |


//入力される値
//入力は以下のフォーマットで与えられます。
//
//W
//c_1 c_2 ... c_W
//H
//r_{1,1} r_{1,2} ... r_{1,W}
//r_{2,1} r_{2,2} ... r_{2,W}
//...
//r_{H,1} r_{H,2} ... r_{H,W}
//
//・1 行目に見出しの個数を表す整数 W が与えられます。
//・2 行目に、j 列目 (1 ≦ j ≦ W) の見出しを表す c_j が、c_1, c_2, ... c_W の順に半角スペース区切りで与えられます。 
//・3 行目にその後入力されるデータ行の行数を表す整数 H が与えられます。
//・続く H 行のうちの i 行目 (1 ≦ i ≦ H) に、i 行 j 列目 (1 ≦ j ≦ W) のデータを表す文字列 r_{i, j} が r_{i,1}, r_{i,2},...,r_{i,W} の順に半角スペース区切りで与えられます。
//・入力は合計で H + 3 行となり、入力値最終行の末尾に改行が１つ入ります。
//
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//h
//s
//d_1
//d_2
//...
//d_H
//・期待する出力は H + 2 行からなります。
//・1 行目に問題文の条件に沿って見出し行を表す文字列 h を出力してください。
//・2 行目に問題文の条件に沿って区切り行を表す文字列 s を入力してください。
//・続く H 行のうちの i 行目 (1 ≦ i ≦ H) に問題文の条件に沿って i 行目のデータ行を表す文字列 d_i を出力してください。
//・H + 2 行目の出力の最後に改行を入れ、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//・入力される文字列はすべて数字または英小文字で構成される
//・1 ≦ W ≦ 100
//・1 ≦ H ≦ 100
//・1 ≦ (c_j の長さ) ≦ 20 (1 ≦ j ≦ W)
//・1 ≦ (r_{i, j} の長さ) ≦ 20 (1 ≦ i ≦ H, 1 ≦ j ≦ W)



//入力例1
//2
//id name
//3
//1 ito
//2 sakakibara
//3 takahashi
//出力例1
//| id | name       |
//|----|------------|
//| 1  | ito        |
//| 2  | sakakibara |
//| 3  | takahashi  |
//入力例2
//6
//name english math japanese science socialstudies
//7
//aoyama 70 82 66 79 90
//okada 44 65 57 69 88
//koyama 52 47 61 23 71
//takeda 48 58 80 34 93
//nakano 55 39 62 77 80
//miura 23 40 35 46 53
//yagami 91 92 95 90 100
//出力例2
//| name   | english | math | japanese | science | socialstudies |
//|--------|---------|------|----------|---------|---------------|
//| aoyama | 70      | 82   | 66       | 79      | 90            |
//| okada  | 44      | 65   | 57       | 69      | 88            |
//| koyama | 52      | 47   | 61       | 23      | 71            |
//| takeda | 48      | 58   | 80       | 34      | 93            |
//| nakano | 55      | 39   | 62       | 77      | 80            |
//| miura  | 23      | 40   | 35       | 46      | 53            |
//| yagami | 91      | 92   | 95       | 90      | 100           |
