package problem.Japan.choi;

import java.util.Scanner;

public class OptimumPractice {
	
	public static int getSPA(int[][] t_N, int[] a_M, int[] status, int practiceN) {
		int[] practice = new int[4];
		
		for(int i=1; i <= 2147483647; i++) {
			if(sumPractice(t_N, a_M, practice, i, 0)) {
				practiceN = i;
				break;
			}
		}				
		return practiceN;
	}
	
	public static boolean sumPractice(int[][] t_N, int[] a_M, int[] practice, int N, int now) {
		if(isGetSPA(practice, a_M)) {
			return true;
		} else if(now == N) {
			return false;
		}
		for(int i=0; i < t_N.length; i++) {
			if( sumPractice(t_N, a_M, sumTwo(practice, t_N[i]), N, now+1) ) {
				return true;
			}
		}		
		return false;
	}
	
	public static int[] sumTwo(int[] t_N, int[] practice) {
		int[] result = new int[4];
		result[0] = t_N[0] + practice[0];
		result[1] = t_N[1] + practice[1];
		result[2] = t_N[2] + practice[2];
		result[3] = t_N[3] + practice[3];		
		return result;
	}
	public static boolean isGetSPA(int[] practice, int[] a_M) {
		for(int i=0; i < 4; i++) {
			if(practice[i] < a_M[i]) return false;
		}		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] t_N = new int[N][4];
		int[][] a_M = new int[M][4];
		int[] status = new int[4];
		int[] result;
		
		for(int i=0; i < N; i++) {
			t_N[i][0] = sc.nextInt();
			t_N[i][1] = sc.nextInt();
			t_N[i][2] = sc.nextInt();
			t_N[i][3] = sc.nextInt();
		}
		for(int i=0; i < M; i++) {
			a_M[i][0] = sc.nextInt();
			a_M[i][1] = sc.nextInt();
			a_M[i][2] = sc.nextInt();
			a_M[i][3] = sc.nextInt();
		}
		result = new int[M];
		for(int i=0; i < M; i++) {
			result[i] = getSPA(t_N, a_M[i], status, 0);
			System.out.println(result[i]);
		}
		
		

	}

}


//あなたの趣味は野球ゲームでの選手育成です。 今まで沢山の強い選手を育成してきたあなたですが、 エンディング間際の練習メニューの組み方に失敗し、 選手育成に失敗したことが何度かあります。 そこで、プログラムを組むことによって、 このようなミスをなくそうと考えました。
//
//このゲームでは、 いくつかの練習があり、 その練習に応じて、筋力、技術、敏捷、精神の4つのポイントが決まったぶんだけ上昇します。 同じ練習を複数回行うことも可能です。 これらの筋力、技術、敏捷、精神の4つのポイントが、 全て決められたポイント以上になると、 それに応じて特殊能力を取得できます。
//
//練習によって得られるポイントの一覧と、 取得したい特殊能力に必要なポイントの一覧が与えられるので、 それぞれの特殊能力に対して、 その特殊能力を取得するのに必要な最小の練習回数を出力して下さい。 ただし、 筋力、技術、敏捷、精神の４つのポイントは全て0の状態から始まるとします。
//
// 
//条件によって全ての組み合わせを検証するとタイムアウトしてしまうことに注意してください。


//入力される値
//N M　　　#練習の数 N、取得したい特殊能力の数 M
//t_11 t_12 t_13 t_14　　　#1番目の練習で得られる、筋力、技術、敏捷、精神のポイント
//...
//t_N1 t_N2 t_N3 t_N4　　　#N番目の練習で得られる、筋力、技術、敏捷、精神のポイント
//a_11 a_12 a_13 a_14　　　#1番目の習得したい特殊能力に必要な筋力、技術、敏捷、精神のポイント
//...
//a_M1 a_M2 a_M3 a_M4　　　#M番目の習得したい特殊能力に必要な筋力、技術、敏捷、精神のポイント
//1 行目には、練習の数 N、取得したい特殊能力の数 M が空白区切りで与えられます。 
//
//2 行目から N+1 行目までの各行には
//その練習によって得られる筋力、技術、敏捷、精神のポイントが空白区切りで順に与えられます。 
//
//N+2 行目から N+M+1 行目までの各行には
//習得したい特殊能力に必要な筋力、技術、敏捷、精神のポイントが空白区切りで順に与えられます。
//
//また、どの特殊能力に対しても、その特殊能力を得ることができるような練習メニューの組み方は存在します。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//それぞれの特殊能力を取得するのに必要な最小の練習回数を、 入力された順にそれぞれ１行で出力して下さい。 
//
//最後は改行し、余計な文字、空行を含んではいけません。



//条件
//すべてのテストケースで以下の条件を満たします。
//
//・1 ≦ N ≦ 10
//・1 ≦ M ≦ 100
//・0 ≦ t_ij ≦ 100 (1 ≦ i ≦ N, 1 ≦ j ≦ 4)
//・0 ≦ a_ij ≦ 30 (1 ≦ i ≦ M, 1 ≦ j ≦ 4)
//
//また、与えられる入力では、 どの特殊能力も、適切な練習メニューを組むことによって取得できます。


//入力例1
//3 2
//1 0 2 4
//1 1 2 1
//3 1 0 1
//2 0 3 5
//3 0 2 0
//出力例1
//2
//2
//
//入力例2
//3 3
//4 0 5 0
//4 0 4 0
//0 2 5 5
//3 2 0 3
//3 2 0 0
//5 3 5 4
//出力例2
//2
//2
//4