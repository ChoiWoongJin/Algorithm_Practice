package problem.Japan.choi;

import java.util.Scanner;

public class ImitateWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.next());
		char[][] t = new char[N][N];		
		for(int i=0; i < N; i++) {
			t[i] = sc.next().toCharArray();	
		}		
		
		int M = Integer.parseInt(sc.next());
		char[][] p = new char[M][];
		String[] result = new String[M];
		for(int i=0; i < M; i++) {
			p[i] = sc.next().toCharArray();			
			
			result[i] = checkFind(t, p[i]);
			System.out.println(result[i]);
		}
	}
	
	public static String checkFind(char[][] t, char[] p) {
		
		int[][] tCheck = new int[t.length][t.length];		
		for(int i=0; i < t.length; i++) {
			for(int j=0; j < t.length; j++) {
				tCheck[i][j] = 0;
			}
		}
		
		for(int i=0; i < t.length; i++) {
			for(int j=0; j < t[0].length; j++) {
				if(t[i][j] == p[0]) {
					if( checkLine(t, p, tCheck, i, j,0) == true) {
						return "yes";
					}
				}
			}
		}		
		
		return "no";
	}
	
	public static boolean checkLine(char[][]t, char[] p, int[][] tCheck, int i, int j, int pNum) {
		
		boolean result = false;
		
		if( t[i][j] == p[pNum] && tCheck[i][j] == 0 ) {
			p[pNum++] = t[i][j];
			tCheck[i][j] = 1;
		} else {
			return result = false;
		}
		
		if(pNum == p.length) {
			return result = true;
		} else {
			if( (i+1) < t.length ) {
				if( t[i+1][j] == p[pNum]) {
					return result = checkLine(t, p, tCheck, ++i, j, pNum);
				}
			}
			if( (j+1) < t[0].length ) {
				if( t[i][j+1] == p[pNum]) {
					return result = checkLine(t, p, tCheck, i, ++j, pNum);
				}
			}
			if( i > 0 ) {
				if( t[i-1][j] == p[pNum]) {
					return result = checkLine(t, p, tCheck, --i, j, pNum);
				}
			}
			if( j > 0 ) {
				if( t[i][j-1] == p[pNum]) {
					return result = checkLine(t, p, tCheck, i, --j, pNum);
				}
			}
		}		
		
		return result;
	}
}

//N × N の格子状に配置されたマスがあり、各マスには文字が 1 つだけ書かれているような盤面が与えられます。
//あなたは、この盤面の上で以下の操作を行うことにより、文字列を作成するゲームで遊ぶことにしました。
//
//
//1. 任意のマスに指をおく。
//2. 指を離してもよい。離した場合は、操作を終了する。
//3. 指が置いてあるマスから縦、横で隣接するマスへ指を移動する。ただし、一度指を置いたことがあるマスに移動しようとした場合は、操作を終了する。 2 に戻る。
//
//
//操作が終了した後、指を置いた順にマスに書かれた文字を並べることで、 1 つの文字列を作成します。
//
//あなたは、このゲームで遊ぶにあたって、どのような文字列を作成できるのかが気になりました。
//そこで、作成したい文字列の候補を M 個挙げ、それらの作成可否を調べることにしました。
//
//N × N の盤面と M 個の文字列が与えられるので、各文字列に対して、与えられた盤面上での作成可否を判定するプログラムを作成してください。
//
//入力例 1 の図解を以下に示します。
//
//
//img


//入力される値
//入力は以下のフォーマットで与えられます。
//
//N
//t_1
//t_2
//...
//t_N
//M
//p_1
//p_2
//...
//p_M
//・1 行目には盤面の大きさを表す整数 N が与えられます。
//・続く N 行のうち i 行目 (1 ≦ i ≦ N) には、盤面の i 行目の文字をまとめた文字列 t_i が与えられ、 t_i の j 文字目は、盤面の i 行目の j 列目に書かれている文字を表します。
//・N + 2 行目には作成可否を判定するべき文字列の数を表す整数 M が与えられます。
//・続く M 行のうち j 行目 (1 ≦ j ≦ M) には、 j 番目に作成可否を判定するべき文字列 p_j が与えられます。
//・入力は合計で N + M + 2 行となり、入力値最終行の末尾に改行が1つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//M 個の各文字列の作成可否を以下のように出力してください。
//
//r_1
//r_2
//...
//r_M
//・期待する出力は M 行からなります。
//・j 行目 (1 ≦ j ≦ M) には、 j 番目の文字列 p_j の作成可否を表す文字列 r_j を出力してください。 r_j は p_j を作成可能ならば "yes" 、そうでないならば "no" です。
//・M 行目の出力の最後に改行を入れ、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・1 ≦ N ≦ 10
//・各 i (1 ≦ i ≦ N) に対して、以下の条件をみたす。
//　・(t_i の長さ) = N
//　・t_i は半角英小文字で構成された文字列である。
//・1 ≦ M ≦ 50
//・各 j (1 ≦ j ≦ M) に対して、以下の条件をみたす。
//　・1 ≦ (p_j の長さ) ≦ 5
//　・p_j は半角英小文字で構成された文字列である。
 
 
//入力例1
//3
//abc
//cab
//bca
//3
//aca
//bca
//bcc
//出力例1
//yes
//yes
//no
//入力例2
//1
//b
//3
//a
//b
//bb
//出力例2
//no
//yes
//no
//入力例3
//4
//abcd
//efgh
//hgfe
//dcba
//5
//abfgf
//bfgc
//abfga
//hdc
//fghde
//出力例3
//yes
//yes
//no
//yes
//no
