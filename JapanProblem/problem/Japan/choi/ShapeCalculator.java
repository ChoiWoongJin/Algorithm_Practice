package problem.Japan.choi;

import java.util.*;

public class ShapeCalculator {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int shapeN = sc.nextInt();
		char[] pm = new char[shapeN];
		int[][] shapeInfo = new int[shapeN][3];
		List<String> map = new ArrayList<String>();
		
		for(int i=0; i < shapeN; i++) {
			pm[i] = sc.next().charAt(0);
			shapeInfo[i][0] = sc.nextInt(); // shape start x
			shapeInfo[i][1] = sc.nextInt(); // shape start y
			shapeInfo[i][2] = sc.nextInt(); // shape size
		}
		
		int x = 0, y = 0;
		String point = "";
		for(int i=0; i < shapeN; i++) {
			if(pm[i] == '+') { // plus
				for(int j=0; j < shapeInfo[i][2]; j++) {
					for(int k=0; k < shapeInfo[i][2]; k++) {
						x = shapeInfo[i][0] + j;
						y = shapeInfo[i][1] + k;
						point = Integer.toString(x) + "," + Integer.toString(y); // x,y
						if(map.contains(point) != true) { // if not have
							map.add(point);
						}						
					}
				}
			} else if(pm[i] == '-') { // minus
				for(int j=0; j < shapeInfo[i][2]; j++) {
					for(int k=0; k < shapeInfo[i][2]; k++) {
						x = shapeInfo[i][0] + j;
						y = shapeInfo[i][1] + k;
						point = Integer.toString(x) + "," + Integer.toString(y); // x,y
						if(map.contains(point)) { // if have
							map.remove(point);
						}						
					}
				}
			}
		}

		System.out.println(map.size());		
	}
}


//図形の足し算、引き算を考えてみましょう。 図形 A、図形 B を足し算すると、A, B のどちらか一方に存在する部分、および A, B 両方に重なる部分の図形が足し算の結果になります。 また、図形 A から図形 B を引き算すると、図形 A のうち図形 B の部分がなくなった部分の図形が引き算の結果となります。 例えば、正方形の足し算の例は下図のようになります。
//
//img
//
//また、正方形の引き算は以下のようになります。
//
//引き算では、引く正方形の部分がなくなったのものが演算の結果となります。
//
//img
//
//正方形の足し算・引き算の結果の図形の面積を出力してください。
//
//たとえば、以下の図においては、14 と出力してください。
//
//この図は入力例 1 に対応しています。
//
//img
//
//なお、正方形の足し算・引き算は順序を入れ替えると結果が異なる場合があることに注意してください。


//入力は以下のフォーマットで与えられます。
//
//N
//o_1 x_1 y_1 a_1
//o_2 x_2 y_2 a_2
//...
//o_N x_N y_N a_n
//・1 行目には与えられる式の数を表す整数 N が与えられます。
//・続く N 行のうちの i 行目（1 ≦ i ≦ N）には、i 番目の演算が与えられます。足し算か引き算かを示す文字 o_i、 正方形の左上の x 座標を示す整数 x_i、 正方形の左上の y 座標を示す整数 y_i、 正方形の辺の長さを示す整数 a_i が半角スペース区切りで与えられます。 o_i が "+" の場合は足し算を、 "-" の場合は引き算を行います。
//・入力は合計で N + 1 行となり、入力値最終行の末尾に改行が１つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください



//期待する出力
//正方形の足し算・引き算の結果の図形の面積を出力してください。
//
//出力の最後に改行を入れ、余計な文字、空行を含んではいけません。



//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・1 ≦ N ≦ 10
//・o_i は "+" あるいは "-"
//・0 ≦ x_i, y_i, a_i < 100,000


//入力例1
//3
//+ 1 1 3
//- 3 1 3
//+ 2 3 3
//出力例1
//14
//
//入力例2
//3
//- 1 1 5
//+ 3 3 3
//- 4 4 1
//出力例2
//8