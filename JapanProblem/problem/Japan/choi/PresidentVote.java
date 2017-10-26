package problem.Japan.choi;

import java.util.*;

public class PresidentVote {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);

		// candidate Set
		int candidateNum = Integer.parseInt(sc.next());
		int[] candidate = new int[candidateNum + 1]; // 0 : Republican, 1 : Democratic
		for (int i = 1; i <= candidateNum; i++) {
			if (sc.next().equals("Republican")) {
				candidate[i] = 0;
			} else {
				candidate[i] = 1;
			}
		}

		// voter Set
		int voterNum = Integer.parseInt(sc.next());
		int[][] voterPrefer = new int[voterNum][candidateNum];
		for (int i = 0; i < voterNum; i++) {
			for (int j = 0; j < candidateNum; j++) {
				voterPrefer[i][j] = Integer.parseInt(sc.next());
			}
		}

		// votedCandidate Set
		int[] votedCandidate = new int[candidateNum + 1];
		for (int i = 1; i <= candidateNum; i++) {
			votedCandidate[i] = 0;
		}

		// First Voting
		int repub = 0, repubVote = 0, demo = 0, demoVote = 0;
		for (int i = 0; i < voterNum; i++) {
			for (int check = 0; check < 2; check++) {
				for (int j = 0; j < candidateNum; j++) {
					if (candidate[voterPrefer[i][j]] == check) {
						votedCandidate[voterPrefer[i][j]]++;
						break;
					}
				}
			}
		}

		// First Voting Result
		for (int i = 1; i <= candidateNum; i++) {
			if (candidate[i] == 0 && votedCandidate[i] > repubVote) {
				repubVote = votedCandidate[i];
				repub = i;
			} else if (candidate[i] == 1 && votedCandidate[i] > demoVote) {
				demoVote = votedCandidate[i];
				demo = i;
			}
		}

		// Last Voting
		repubVote = 0;
		demoVote = 0;
		for (int i = 0; i < voterNum; i++) {
			for (int j = 0; j < candidateNum; j++) {
				if (voterPrefer[i][j] == repub) {
					repubVote++;
					break;
				} else if (voterPrefer[i][j] == demo) {
					demoVote++;
					break;
				}
			}
		}

		// Output Result
		if (repubVote > demoVote) {
			System.out.println(repub);
		} else {
			System.out.println(demo);
		}

	}
}


//paiza 国の大統領選挙ではまず各党の代表を選ぶ予備選挙を行い、予備選挙を勝ち上がった代表の中で本選挙を行います。paiza 国は二大政党制となっており、"Republican Party" と "Democratic Party" の二つの政党のみから候補者が出馬します。
//
//各選挙では得票数が最も多い候補者が勝者となります。
//
//各党から出馬する候補者の番号と、投票者の候補者に関する選好順序 (投票したいと思う順序) が与えられるので、本選挙の勝者となり最終的に大統領に選ばれる候補者を求めてください。すべての投票者が両方の選挙で投票を行います。
//
//ただし、いずれの選挙でも勝者は必ず一人に定まり、最大の得票数が同じになることはないものとします。
//
//例)
//各党の候補者
//Republican Party: 候補者 1, 3, 5
//Democratic Party: 候補者 2, 4
//
//投票者の選好順序は以下のようになっています。
//
//投票者 1 は Republican Party の予備選挙では候補者 1, 3, 5 を比較して 1 に、Democratic Party の予備選挙では 2 と 4 を比較して 2 に投票します。
//
//図1
//
//予備選挙の結果
//Republican Party: 候補者 1...3 票、候補者 3...2 票、候補者 5...2 票 → 候補者 1 が勝利
//Democratic Party: 候補者 4...5 票、候補者 2...2 票 → 候補者 4 が勝利
//
//本選挙では投票者 1 は候補者 1 と候補者 4 を比較して候補者 1 に投票します。 図2
//
//本選挙の結果
//候補者 1...3 票、候補者 4...4 票 → 候補者 4 が 勝利
//
//この例は入力例 1 に対応しています。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//M
//c_1
//c_2
//...
//c_M
//N
//v_{1,1} v_{1,2} ... v_{1,M}
//v_{2,1} v_{2,2} ... v_{2,M}
//...
//v_{N,1} v_{N,2} ... v_{N,M}
//・1 行目には両党の候補者の総数を表す整数 M が与えられます。
//・続く M 行のうち i 行目 (1 ≦ i ≦ M) には候補者 i (i は候補者の番号) の所属する政党を表す文字列 c_i が与えられます。c_i は所属が Republican Party であれば "Republican"、Democratic Party であれば "Democratic" となります。
//・続く行には投票者の総数を表す整数 N が与えられます。
//・続く N 行のうち j 行目 (1 ≦ j ≦ N) には M 個の整数が半角スペース区切りで与えられます。この i 番目 (1 ≦ i ≦ M) の整数 v_{j, i}は j 番目の投票者が全候補者のうち i 番目に投票したいと思う候補者の番号を表します。
//・入力は合計で M + N + 2 行となり、入力最終行の末尾に改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//本選挙の勝者となり大統領に選ばれる候補者の番号を 1 行で出力してください。
//
//入力の最後に改行を 1 つ入れ、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・2 ≦ M ≦ 100
//・1 ≦ N ≦ 1,000
//・各 i, j (1 ≦ i ≦ M, 1 ≦ j ≦ N) について
//　・c_i は英字で "Republican", "Democratic" のいずれか
//　・1 ≦ v_{j, i} ≦ M
//　・各 a, b (1 ≦ a, b ≦ M) について a ≠ b のとき v_{j, a} ≠ v_{j, b}, すなわち j 番目の投票者の選好順序における候補者の番号はすべて互いに異なる
//・c_1, c_2, ..., c_M のうち "Republican", "Democratic" がそれぞれ必ず 1 つ以上含まれる


//入力例1
//5
//Republican
//Democratic
//Republican
//Democratic
//Republican
//7
//1 2 3 4 5
//1 4 3 2 5
//4 5 1 3 2
//5 3 2 1 4
//3 4 1 2 5
//4 2 1 3 5
//4 3 1 5 2
//出力例1
//4
//入力例2
//10
//Republican
//Republican
//Democratic
//Democratic
//Democratic
//Republican
//Republican
//Republican
//Democratic
//Republican
//20
//7 9 3 1 6 2 8 10 4 5
//4 1 9 3 8 2 7 10 6 5
//2 1 5 3 10 4 8 6 7 9
//5 2 8 10 3 6 7 4 9 1
//8 1 4 2 10 5 7 9 3 6
//2 7 3 5 10 1 6 8 4 9
//3 4 7 1 2 10 9 6 5 8
//3 8 4 10 9 5 6 2 7 1
//5 9 2 3 4 6 7 1 8 10
//3 7 4 1 5 9 10 8 2 6
//1 4 7 6 9 8 3 5 10 2
//4 8 2 10 9 7 6 3 1 5
//7 1 5 10 8 3 4 6 2 9
//6 1 5 7 4 10 3 8 9 2
//2 4 9 8 1 6 10 3 7 5
//2 6 10 8 9 4 7 5 1 3
//4 8 7 9 6 10 2 1 5 3
//6 8 7 3 4 10 5 9 1 2
//10 2 9 4 3 1 6 5 8 7
//8 7 9 1 4 6 2 10 5 3
//出力例2
//4