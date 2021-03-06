package problem.Japan.choi;

import java.util.*;

public class CardGameSimulation {

	public static void main(String[] args) {
		// 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        
        int H = Integer.parseInt(sc.next());
        int W = Integer.parseInt(sc.next());
        int N = Integer.parseInt(sc.next());
        int[] cardSelectNum = new int[N];
        for(int i=0; i < N; i++) {
        	cardSelectNum[i] = 0;
        }
        int[][] map = new int[H][W];        
        for(int i=0; i < H; i++) {
        	for(int j=0; j < W; j++) {
        		map[i][j] = Integer.parseInt(sc.next()) - 1;
        	}
        }
        
        int L = Integer.parseInt(sc.next());
        int[][] play = new int[L][4];
        for(int i=0; i < L; i++) {
        	for(int j=0; j < 4; j++) {
        		play[i][j] = Integer.parseInt(sc.next()) - 1;
        	}
        }
        
        int player = 0;
        int check = 0;
        for(int i=0; i < L; i++) {
        	if( map[ play[i][0] ][ play[i][1] ] == map[ play[i][2] ][ play[i][3] ] ) {
        		map[ play[i][0] ][ play[i][1] ] = 0;
        		map[ play[i][2] ][ play[i][3] ] = 0;
        		cardSelectNum[player]+= 2;
        	} else {
        		player = (++player)%N;
        	}
        }
        
        for(int i=0; i < N; i++) {
        	System.out.println(cardSelectNum[i]);
        }

	}

}

//神経衰弱と呼ばれるトランプゲームのシミュレーションをしましょう。
//
//シンプルにするために、トランプには数字のみ書かれているものと考えます。 また、トランプを縦 H 枚、横 W 枚の長方形の形に並べた状態でスタートすることにします。 ここで、H × W 枚のトランプには 1 〜 13 の数字のうちどれか1つが書かれています。 また、複数のトランプに同じ数字が書かれていることがあります。
//
//プレイヤーが N 人おり、それぞれ 1 〜 N で番号付けられているものとします。 ゲームが始まると、1番の人から以下の手順でプレイしていきます。
//
//・任意の2枚のトランプを捲る。
//・捲った2枚のトランプに異なる数字が書かれていれば、次のプレイヤーの手番となる。そうでなければ、以下の操作を行う。
//・2枚のトランプを取り除き、自分のものとする。
//・トランプが全て取り除かれていれば、ゲームを終了する。
//・手順の先頭に戻る。
//
//取り除かれたカード以外は間を詰めるなど初期状態から移動することはありません。
//
//ここで、N 番のプレイヤーの次のプレイヤーは 1 番のプレイヤーであるとします。
//
//ゲームの初期状態におけるトランプの配置と、 ゲームが終わるまでに捲られたトランプに関する時系列順の記録が与えられます。 
//その記録を用いて、各プレイヤーが取り除いたトランプの枚数を求めてください。
//
//例えば、入力例1は以下のようになります。



//入力される値
//入力は以下のフォーマットで与えられます。
//
//H W N
//t_{1,1} t_{1,2} ... t_{1,W}
//t_{2,1} t_{2,2} ... t_{2,W}
//...
//t_{H,1} t_{H,2} ... t_{H,W}
//L
//a_1 b_1 A_1 B_1
//a_2 b_2 A_2 B_2
//...
//a_L b_L A_L B_L
//
//1行目には3つの整数 H, W, Nが入力されます。 H と W はそれぞれ並べられたトランプの縦方向の枚数と横方向の枚数で、 N はプレイヤーの数を表します。
//
//続く H 行には、配置されたトランプに書かれた数字が入力されます。 t_{i,j} は i 行 j 列に置かれたトランプに書かれた数字を表します。
//
//次の行には、記録の長さ L が与えられます。
//
//続く L 行には、捲られたトランプの記録が時系列順で与えられます。 これは、a_i 行 b_i 列のトランプと A_i 行 B_i 列のトランプが捲られたことを表します。
//
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください




//期待する出力
//各プレイヤーが取り除いたトランプの枚数を以下の形式で出力してください。
//
//s_1
//s_2
//...
//s_N
//s_i は i 番目のプレイヤーが取り除いたトランプの枚数を表します。 各行の最後は改行し、余計な文字、空行を含んではいけません。



//条件
//すべてのテストケースで以下の条件を満たします。
//
//・1 ≦ H, W ≦ 13
//H × W は52以下の2の倍数 
//・2 ≦ N ≦ 10
//t_{i,j} は1,...,13のいずれか（1 ≦ i ≦ H, 1 ≦ j ≦ W）
//
//並べられたトランプの中に、同じ数字が書かれたトランプは2枚または4枚ある
//
//・1 ≦ L ≦ 200
//・1 ≦ a_i, A_i ≦ H（1 ≦ i ≦ L）
//・1 ≦ b_i, B_i ≦ W（1 ≦ i ≦ L）
//a_i 行 b_i 列および A_i 行 B_i 列のトランプは取り除かれていない
//
//・(a_i, b_i) ≠ (A_i, B_i)
//
//全ての数は整数で与えられます。



//入力例1
//2 2 2
//1 2
//2 1
//4
//1 1 2 1
//1 1 1 2
//1 1 2 2
//1 2 2 1
//出力例1
//4
//0
//入力例2
//2 5 3
//5 8 8 6 3
//3 6 3 3 5
//8
//1 4 2 2
//1 3 2 1
//2 4 2 3
//1 3 1 5
//2 5 1 1
//2 1 1 2
//1 5 2 1
//1 2 1 3
//出力例2
//6
//2
//2