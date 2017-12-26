package problem.Japan.choi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SiritoriWithEveryone {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // player number
		int K = sc.nextInt(); // word number
		int M = sc.nextInt(); // message log number
		
		int[] playerInfo = new int[N]; // 0 : alive, 1 : dead
		Set<String> wordInfo = new HashSet<>(); // word information
		String[] logInfo = new String[M]; // message log information
		
		for(int i=0; i < K; i++) {
			wordInfo.add(sc.next());
		}
		
		int startCheck = 0;
		int currentPlayer = 0;
		int savePlayerNum = N;
		String lastWord = "";
		boolean ruleCheck = true;
		
		for(int i=0; i < M; i++) {
			while(playerInfo[currentPlayer] == 1) { // if current player is dead
				currentPlayer = (currentPlayer+1)%N; // next player
			}
			
			logInfo[i] = sc.next();
			ruleCheck = true;

			if(wordInfo.contains(logInfo[i]) && !logInfo[i].substring(logInfo[i].length()-1).equals("z")) { // check rule 1, 3, 4
				wordInfo.remove(logInfo[i]);
				if(startCheck != 0) { // check rule 2
					if(!logInfo[i].substring(0, 1).equals(lastWord)) {
						ruleCheck = false;
					}
				}
			} else {
				ruleCheck = false;
			}
			
			startCheck++;
			if(ruleCheck == false) {
				playerInfo[currentPlayer] = 1;
				savePlayerNum--;
				startCheck = 0;
			}
			lastWord = logInfo[i].substring(logInfo[i].length()-1);			
			currentPlayer = (currentPlayer+1)%N; // next player
		}
		
		// output result
		System.out.println(savePlayerNum);
		for(int i=0; i < N; i++) {
			if(playerInfo[i] == 0) {
				System.out.println(i+1);
			}
		}
		
		sc.close();
	}

}


//あなたは友達たちと N 人でしりとりを行うことにしました。1 人目、 2 人目、...、 N 人目、 1 人目、2 人目、... という順序で発言をします。
//
//ここで、それぞれの人は、次に挙げる 4 つのしりとりのルールを守って発言をする必要があります。
//
//1. 発言は、単語リストにある K 個の単語のうちのいずれかの単語でなければならない。
//2. 最初の人以外の発言の頭文字は、直前の人の発言の最後の文字と一緒でなければならない。
//3. 今までに発言された単語を発言してはならない。
//4. z で終わる単語を発言してはならない。
//
//ここで、発言の途中で上のルールを破った場合、ルールを破った人はしりとりから外れます。そして、その人を抜いて引き続きしりとりを続けていきます。このとき、後続の人は、ルール 2 を守る必要はありません。
//
//N 人がしりとりを行ったログが M 行分与えられます。このとき、M 回の発言が終わった後、しりとりから脱落せずに残っている人のリストを表示するプログラムを書いてください。
//
//例)
//入力例 1 の状況を考えます。このとき、しりとりの参加者は 3 人、単語リストに乗っている単語は 6 個です。
//
//図1
//
//しりとりの様子を図解すると、以下のようになります。
//
//図2
//
//よって、最終的にしりとりから脱落せずに残っているのは 3 番目の人のみになります。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//N K M
//d_1
//d_2
//...
//d_K
//s_1
//s_2
//...
//s_M
//・1 行目にしりとりをする人数を表す整数 N、単語リストに乗っている単語の数を表す整数 K、しりとりで行われた発言の数を表す整数 M がこの順にスペース区切りで与えられます。
//・続く K 行のうちの i 行目 (1 ≦ i ≦ K) には、単語リストに乗っている i 番目の単語を表す文字列 d_i が与えられます。
//・続く M 行のうちの j 行目 (1 ≦ j ≦ M) には、しりとりで行われた j 番目の発言を表す文字列 s_j が与えられます。
//・入力は合計で K + M + 1 行となり、入力値最終行の末尾に改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//最終的にしりとりから脱落せずに残っている人の番号を以下の形式で出力してください。
//
//N'
//a_1
//a_2
//...
//a_N'
//期待する出力は N' + 1 行からなります。
//1 行目には、最終的にしりとりから脱落せずに残っている人の人数を表す整数 N' を出力してください。
//続く N' 行のうち、i 行目 (1 ≦ i ≦ N') には、最終的にしりとりから脱落せずに残っている人の番号のうち、小さい方から i 番目のものを出力してください。
//N' + 1 行目の出力の最後に改行を入れ、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・1 ≦ N ≦ 10
//・1 ≦ K ≦ 1,000
//・1 ≦ M ≦ 1,000
//・各 i, i' (1 ≦ i, i' ≦ K) について
//　・1 ≦ (d_i の長さ) ≦ 10
//　・i ≠ i' なら d_i ≠ d_i'
//・各 j (1 ≦ j ≦ M) について
//　・1 ≦ (s_j の長さ) ≦ 10
//・少なくとも 1 人はしりとりから脱落しないことが保証されている


//入力例1
//3 6 7
//a
//aloha
//app
//az
//paiza
//warp
//app
//paiza
//a
//aloha
//az
//warp
//paiza
//出力例1
//1
//3
//入力例2
//4 4 4
//abacus
//banana
//candy
//yankee
//banana
//candies
//candies
//yankee
//出力例2
//2
//1
//4