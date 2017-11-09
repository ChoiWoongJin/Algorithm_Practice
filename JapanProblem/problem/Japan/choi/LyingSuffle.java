package problem.Japan.choi;

import java.util.*;

public class LyingSuffle {
	public static boolean suffle(int[] card, int[] purpose, int[][] method, int N, int S, int result, List<Integer> ls) {
		if(ls.size() > 0) {
			if(result >= ls.get(0)) return false;
		} // result is bigger than minimum result	
		if(result >= N*S) {
			return false;
		} // check can't get result;
		// because In EveryCase, Using Method N times it comes back to First
		
		int check = 0;
		int[] tempCard = new int[N];
		for(int i=1; i < N; i++) {	
			if(card[i] != purpose[i]) check = -1;
		}// check end
		
		if(check == 0) {
			ls.add(result);
			if(result < ls.get(0) ) ls.add(0, result);
			return true;
		} // get result

		for(int i=0; i < S; i++) {
			for(int j=0; j < N; j++) {
				tempCard[ j ] = card[ method[i][j] ]; // suffle
			}
			suffle(tempCard, purpose, method, N, S, result+1, ls);
		}
		
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // card Num
		int[] purpose = new int[N]; // purpose card
		int[] card = new int[N]; // current card
		for(int i=0; i < N; i++) {
			card[i] = i; // current card Init
			purpose[i] = sc.nextInt(); // purpose card set
		}
		int S = sc.nextInt(); // suffle method Number
		int[][] method = new int[S][N]; // suffle method
		for(int i=0; i < S; i++) {
			for(int j=0; j < N; j++) {
				method[i][j] = sc.nextInt(); // suffle method set
			}
		}
		
		List<Integer> ls = new ArrayList<>();
		
		suffle(card, purpose, method, N, S, 0, ls); // get result
		if( ls.size() == 0)
			System.out.println(-1);
		else {
			System.out.println(ls.get(0));
		}		
	}
}

//あなたは友人とカードを使ったテーブルゲームをプレイしています。
//使うカードは 0, 1, ... , N-1 までの数字が書かれている普通のカードです。
//ゲームが始まる前に 山札は上から順に 0, 1, ... , N-1 と昇順に並べ、始まる際にシャッフルします。
//
//あなたはどうしても勝ちたいので、シャッフルする段階でイカサマをする事にしました。
//山札をシャッフルした結果をコントロールして、最初の段階で優位に立つというものです。
//このため、あなたはシャッフルした際に常に同じ並び順になるシャッフル方法を習得しました。
//なるべく怪しまれないよう、このシャッフル方法を最小限の回数だけ使って目的の並び順にイカサマします。
//
//0, 1, 2, 3 ..., N-1 という並びを P という並びに変えるシャッフル方法を [P] と表現します。
//例えば [1, 2, 3, 0] は 0, 1, 2, 3 という並びを 1, 2, 3, 0 に並び変えるシャッフル方法です。
//このシャッフル方法で 1, 0, 3, 2 という並びをシャッフルすると, 0, 3, 2, 1 という並びになります。
//
//img
//
//シャッフル方法は同じ物を複数回使っても構いません。このため、入力例 2 では以下の図のように
//2 番目のシャッフル方法を 2 回使い、その後に 1 番目のシャッフル方法を 2 回使う事で、
//計 4 回のシャッフルで目的の山札に並び替えられ、これが最小のシャッフル回数となります。
//
//img
//
//目的の山札の並び順と使用可能なシャッフル方法が与えられます。
//与えられたシャッフル方法を使って山札を目的の並び順にするための、最小のシャッフル回数を出力してください。
//シャッフル方法をどのように使っても実現できない場合には -1 を出力してください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//N
//x_1 x_2 ... x_N
//S
//p_{1, 1} p_{1, 2} ... p_{1, N}
//p_{2, 1} p_{2, 2} ... p_{2, N}
//...
//p_{S, 1} p_{S, 2} ... p_{S, N}
//・1 行目に山札の枚数 N が整数で与えられます。
//・2 行目にイカサマによって実現したい指定の山札の順番を表す半角スペース区切りの整数列 x_1, x_2, ... , x_N が与えられます。
//・3 行目に使えるシャッフル方法の個数 S が与えられます。
//・続く S 行のうち i 行目 (1 ≦ i ≦ S) には i 番目のシャッフル方法を表す半角スペース区切りの整数列 p_{i, 1}, p_{i, 2}, ... , p_{i, N} が与えられます。
//　・この整数列はシャッフル方法 [p_{i, 1}, p_{i, 2}, ... , p_{i, N}] を表します。
//・合計で入力は S + 3 行であり、入力値最終行の末尾には改行が 1 つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//与えられたシャッフル方法を使って山札を目的の並び順にするための、最小のシャッフル回数を出力してください。
//シャッフル方法をどのように使っても実現できない場合には -1 を出力してください。
//
//出力の最後に改行を 1 つ入れ、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・1 ≦ N ≦ 8
//・0 ≦ x_1, x_2, ..., x_N ≦ N-1
//・x_1, x_2, ..., x_N はすべて互いに異なる
//・1 ≦ S ≦ 24
//・各 i (1 ≦ i ≦ S) について
//　・0 ≦ p_{i, 1}, p_{i, 2}, ..., p_{i, N} ≦ N - 1
//　・p_{i, 1}, p_{i, 2}, ..., p_{i, N} はすべて互いに異なる


//入力例1
//4
//1 0 3 2
//1
//1 2 3 0
//出力例1
//-1
//入力例2
//4
//1 2 0 3
//2
//3 2 0 1
//3 1 0 2
//出力例2
//4