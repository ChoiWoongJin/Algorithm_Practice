package problem.Japan.choi;

import java.util.*;

//長く降っていた雨があがり、地面にはいくつかの水たまりができています。 水たまりはどれも長方形の形をしています。ただし、いくつかの水たまりが重なっていることがあります。 ここで、2 つの水たまりが共通部分をもつとき、これらは重なっているとみなします。 特に、2 つの水たまりが辺と辺で接する場合や、頂点と頂点で接する場合にも重なっているとみなすことに注意してください。
//
//
//今、一つの水たまりにアメンボがいます。 このアメンボは水たまりの中を移動し、重なっている水たまりに自由に出入りすることができます。 アメンボが入ることのできる水たまりをすべて求めてください。
//
//
//たとえば、入力例 2 を図示すると次のようになります。
//
//
//図1 
//この場合には、アメンボは水たまり 1, 2, 3 へ入ることができますが、水たまり 4, 5 へは入ることはできません。

//Input Information
//入力は以下のフォーマットで与えられます。
//
//n
//s
//x_1 y_1 a_1 b_1
//...
//x_n y_n a_n b_n
//・1 行目には水たまりの個数を表す整数 n が与えられます。
//・2 行目にはアメンボがいる水たまりの番号を表す整数 s が与えられます。
//・続く n 行には水たまりの位置を表す 4 つの整数 x_i, y_i, a_i, b_i がこの順で半角スペース区切りで与えられます。これは、i 番目の水たまりが (x_i, y_i), (a_i, b_i) を 2 頂点とする長方形であることを表します。(x_i < a_i, y_i < b_i)
//・入力は合計で n + 2 行となり、入力値最終行の末尾に改行が１つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください

//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・入力されるすべての数値は整数
//・1 ≦ n ≦ 50
//・1 ≦ s ≦ n
//・0 ≦ x_i < a_i ≦ 200 (1 ≦ i ≦ n)
//・0 ≦ y_i < b_i ≦ 200 (1 ≦ i ≦ n)
//・ある水たまりが他のある水たまりに完全に含まれることはない。すなわち、「x_i ≦ x_j かつ a_j ≦ a_i かつ y_i ≦ y_j かつ b_j ≦ b_i」となる i, j のペア (i ≠ j) は存在しない。

//入力例1
//3
//3
//0 0 10 10
//0 5 10 15
//20 0 30 10
//出力例1
//3

//入力例2
//5
//1
//50 0 100 50
//0 40 60 70
//100 30 130 100
//40 90 60 110
//30 100 50 120
//出力例2
//1
//2
//3

public class StreetAfterRain {
    
    public static int[][] searchPool(int[][] poolXY, int poolNum, int bugSP) {
        for(int i=0; i < poolNum; i++) {
            if(i == bugSP-1) {
                continue;
            } else {
                // (0,1) (0,3) (2,1) (2,3)
                if( (poolXY[i][0] >= poolXY[bugSP-1][0] && poolXY[i][0] <= poolXY[bugSP-1][2] &&
                     poolXY[i][1] >= poolXY[bugSP-1][1] && poolXY[i][1] <= poolXY[bugSP-1][3]) || // check (0,1)
                    (poolXY[i][0] >= poolXY[bugSP-1][0] && poolXY[i][0] <= poolXY[bugSP-1][2] &&
                     poolXY[i][3] >= poolXY[bugSP-1][1] && poolXY[i][3] <= poolXY[bugSP-1][3]) || // check (0,3)
                    (poolXY[i][2] >= poolXY[bugSP-1][0] && poolXY[i][2] <= poolXY[bugSP-1][2] &&
                     poolXY[i][1] >= poolXY[bugSP-1][1] && poolXY[i][1] <= poolXY[bugSP-1][3]) || // check (2,1)
                    (poolXY[i][2] >= poolXY[bugSP-1][0] && poolXY[i][2] <= poolXY[bugSP-1][2] &&
                     poolXY[i][3] >= poolXY[bugSP-1][1] && poolXY[i][3] <= poolXY[bugSP-1][3])    // check (2,3)
                    ) {
                        poolXY[i][4] = 1;
                        if(poolXY[i][5] != 1) {
                            poolXY[i][5] = 1;
                            poolXY = searchPool(poolXY, poolNum, i+1);
                        }
                }
            }
        }
        
        return poolXY;
    }
    
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        int poolNum = Integer.parseInt(sc.next());
        int bugSP = Integer.parseInt(sc.next());
        int[][] poolXY = new int[poolNum][6];
        
        for(int i=0; i < poolNum; i++) {
            // pool = (x_i , y_i) , (a_i, b_i)
            poolXY[i][0] = Integer.parseInt(sc.next()); // x_i
            poolXY[i][1] = Integer.parseInt(sc.next()); // y_i
            poolXY[i][2] = Integer.parseInt(sc.next()); // a_i
            poolXY[i][3] = Integer.parseInt(sc.next()); // b_i
            if(i == bugSP-1) {
                poolXY[i][4] = 1; // 1 = connected
            } else {
                poolXY[i][4] = 0; // 0 = unconnected
            }
            poolXY[i][5] = 0; // 0 = uncheck, 1 = check
        }
        
        poolXY = searchPool(poolXY, poolNum, bugSP);
        
        for(int i=0; i < poolNum; i++) {
            if(poolXY[i][4] == 1) {
                System.out.println(i+1);
            }
        }
        
        
    }
}