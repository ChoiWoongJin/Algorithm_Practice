package problem.Japan.choi;

import java.util.Scanner;

public class WhereIsHere {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int w = sc.nextInt(); // width
		int h = sc.nextInt(); // height
		int n = sc.nextInt(); // logNum
		int x = sc.nextInt(); // Start point X
		int y = sc.nextInt(); // Start point Y
		String[][] log = new String[n][2];
		for(int i=0; i < n; i++) {
			log[i][0] = sc.next();
			log[i][1] = sc.next();
			
			if(log[i][0].equals("U")) { // if Up
				y =( y + Integer.parseInt(log[i][1]))%h;
			} else if(log[i][0].equals("D")) { // if Down
				y = (y - Integer.parseInt(log[i][1]))%h;
				if(y < 0) {
					y = y + h;
				}
			} else if(log[i][0].equals("R")) { // if Right
				x = (x + Integer.parseInt(log[i][1]))%w;
			} else if(log[i][0].equals("L")) { // if Left
				x = (x - Integer.parseInt(log[i][1]))%w;
				if(x < 0) {
					x = x + w;
				}
			}
		}
		System.out.println(x + " " + y);	

	}

}


//あなたは最近 RPG ゲームにはまっています。 レアアイテムを手に入れるために、 マップ上をあちこち動き回る必要があるのですが、 アイテム探しに夢中になりすぎて、 キャラクターが今どこにいるのか分からなくなってしまうことがよくあります。
//
//あなたは困っていましたが、 このゲームでは、 キャラクターの移動ログを見られることを知りました。
//そこで、 この移動ログを利用して、 キャラクターが今いる位置を表示するプログラムを作ろうと考えています。
//
//プログラムを作る上で注意すべきことが１つあります。 
//このゲームでは、 マップの上端と下端はつながっており、右端と左端はつながっています。
//
//
//例えば、 横幅が 7，縦幅が 6 のマップで、 キャラクターの初期位置が (3,4) とします。
//(ただし、(0,0) が左下の隅で、(6,5) が右上の隅を表します)。 
//この時、上へ 3 進むと、 (3,4) → (3,5) → (3,0) → (3,1) のように移動します。
//また、 初期位置 (3,4) から左へ 5 進むと、 (3,4) → (2,4) → (1,4) → (0,4) →(6,4) → (5,4) のように移動します。
//
//マップの横幅 w、 縦幅 h、キャラクターの初期位置 (x,y)、移動回数 n、そして、 n 個分の移動ログが与えられるので、 最後にキャラクターがいる位置を出力して下さい。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//w h n
//x y
//dir_1 m_1
//dir_2 m_2
//・・・
//dir_n m_n
//1 行目には、マップの横幅 w 、縦幅 h 、移動ログの個数 n が与えられます。 
//2 行目には、初期位置 x, yが与えられます。
//3 行目から n+2 行目までは、移動ログが与えられます。 dir_i は移動した向き、 m_i は移動した距離を表します。
//dir_i は "U", "D", "R", "L" のいずれかで与えられ、 それぞれ、上、下、右、左への移動を表します。
//
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//n 回の移動後のキャラクターの位置 (x_ans, y_ans) を空白で区切り "x_ans y_ans" と出力して下さい。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//・1 ≦ w ≦ 1,000
//・1 ≦ h ≦ 1,000
//・0 ≦ x ＜ w
//・0 ≦ y ＜ h
//・0 ≦ n ≦ 1,000
//・0 ≦ m_i ≦ 1,000
//
//これらは全て整数値で与えられます。 また、 dir_i は "U", "D", "R", "L" のいずれかで与えられます。


//入力例1
//7 6 1
//3 4
//U 3
//出力例1
//3 1
//入力例2
//7 6 1
//3 4
//L 5
//出力例2
//5 4