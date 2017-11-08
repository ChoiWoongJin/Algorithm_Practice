package problem.Japan.choi;

import java.util.*;

public class DontMakeEelToGabayaki {

	public static String letsPlay(int[] move, int block, int CP, int begin, int end, String go, List<String> get) {
		if (begin == end) {
			if(CP > 0 && CP <= block) {			
				get.add(go);
			}
		} else {
			if(CP-move[begin] >0)					letsPlay(move, block, CP - move[begin], begin + 1, end, go + "L", get);
			if(CP+move[begin] <=block)		letsPlay(move, block, CP + move[begin], begin + 1, end, go + "R", get);
		}
		return go;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int blockN = sc.nextInt();
		int moveN = sc.nextInt();
		int[] move = new int[moveN];
		for (int i = 0; i < moveN; i++) {
			move[i] = sc.nextInt();
		}
		
		List<String> get = new ArrayList<String>();
		letsPlay(move, blockN * 2 + 1, blockN + 1, 0, moveN, "", get);
		if(get.size() > 0)		System.out.println(get.get(0));

		sc.close();
	}
}


//あなたの友人がまたつまらないゲームを作りました。そのゲームは次のような内容です。
//
//・2d + 1 個のブロックが直線上に並び
//　便宜上、中央のブロックを0 として、-d, -d + 1, ..., -1, 0, 1, ..., d - 1, d のようにブロックに番号が振られています。
//・最初は、0 のブロックにうなぎが立っています。
//・以下の操作をn 回繰り返します。
//　1. 画面に1 以上の整数a が表示されるので、右か左の同一方向に連続してa 個のブロック分だけうなぎを動かします。
//　2. -d のブロックからさらに左に進むか、もしくはd のブロックからさらに右に進むと、うなぎはブロックから落下し蒲焼きになります。
//　3. 蒲焼きになると強制的にゲームは終了し、あなたの負けです。
//・上記操作のあと、うなぎが蒲焼きになっていなければあなたの勝ちです。
//
// 
//そこで、d とn、およびn 個のa が与えられるので、うなぎを蒲焼きにしない操作を求めるプログラムを作成してください。
//ただし、そのような操作が複数ある場合はそのうちのひとつを出力してください。


//入力される値
//d n　　　#ブロックの長さ2d+1のd ,うなぎを操作する回数 n
//a_1　　　#1回目の操作 a_1
//a_2　　　#2回目の操作 a_2
//...
//a_n　　　#n回目の操作 a_n
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//答えとなる操作を表す文字列を一行に出力してください。
//その文字列は'L' または'R' のみを含む長さn の文字列で、i 文字目はa_i の数字が与えられたときの操作に対応する文字です。
//'L' はうなぎを左に動かすことを、'R' はうなぎを右に動かすことを表します。
//
//最後は改行し、余計な文字、空行を含んではいけません。



//条件
//すべてのテストケースで以下の条件を満たします。
//
//・1 ≦ d ≦ 1000
//・1 ≦ n ≦ 1000
//・1 ≦ a_i ≦ 2d
//少なくともひとつはうなぎを蒲焼きにしない操作が存在する。



//入力例1
//2 3
//1
//1
//4
//出力例1
//RRL
//答えはこの1つとは限らないことに注意してください。
//
//入力例2
//5 4
//4
//9
//6
//3
//出力例2
//LRLL