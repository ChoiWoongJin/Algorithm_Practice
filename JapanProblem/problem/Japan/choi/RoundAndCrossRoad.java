package problem.Japan.choi;

import java.util.*;

public class RoundAndCrossRoad {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        int circleNum = Integer.parseInt(sc.next());
        int[] startPoint = new int[2];
        int[] endPoint = new int[2];
        double[] rangeCase = new double[3];
        
        startPoint[0] = Integer.parseInt(sc.next());
        switch(sc.next()) {
            case "N" :
                startPoint[1] = 0;
                break;
            case "E" :
                startPoint[1] = 1;
                break;
            case "S" :
                startPoint[1] = 2;
                break;
            case "W" :
                startPoint[1] = 3;
                break;
        }
        endPoint[0] = Integer.parseInt(sc.next());
        switch(sc.next()) {
            case "N" :
                endPoint[1] = 0;
                break;
            case "E" :
                endPoint[1] = 1;
                break;
            case "S" :
                endPoint[1] = 2;
                break;
            case "W" :
                endPoint[1] = 3;
                break;
        }
        
        rangeCase[0] = (startPoint[0] * 100) + (endPoint[0] * 100);
        rangeCase[1] = (Math.abs(startPoint[0] - endPoint[0]) * 100) + ((angle(startPoint[1], endPoint[1]) / 2 ) * Math.PI * endPoint[0] * 100);
        rangeCase[2] = (Math.abs(startPoint[0] - endPoint[0]) * 100) + ((angle(startPoint[1], endPoint[1]) / 2 ) * Math.PI * startPoint[0] * 100);

        System.out.println(min(rangeCase));
    }
    
    public static double angle(int s, int e) {
        double result;
        
        if(Math.abs(s - e) <= 2) {
            result = Math.abs(s - e);
        } else {
            result = 1.0;
        }
        
        return result;
    }
    
    public static double min(double[] rangeCase) {
        double result = rangeCase[0];
        
        for(int i=1; i<3; i++) {
            if(result > rangeCase[i]) {
                result = rangeCase[i];
            }
        }
        
        return result;
    }
}


//あなたの住んでいるパイザタウンは、街の中心の駅から同心円状に発達した町です。
//このパイザタウンの交通網は以下の二つの道路で構成されています。
//
//・街の中心から 100 メートルおきにある 同心円状 の道路
//・街の中心から 東西南北 に伸びる道路
//
//この二つの道が交わる交差点を以下の 2 つの座標で区別します。
//
//・同心円状の道路の順番
//・東西南北に伸びる道路の方角
//
//図1
//
//
//あなたは、今居る交差点から目的の交差点に行く必要があり、なるべく早く到着しなければなりません。
//同心円状の道路の数、今居る交差点、目的地の交差点が与えられるので、目的地の交差点までの最短距離を求めてください。
//
//例えば、入力例 1 で以下の移動方法を試した図が以下の図になります。
//
//・東西に伸びる道路を利用し中心に到達した後、南北に伸びる道路を利用する
//・目的地のある同心円状の道路に到達した後、円に沿って移動する
//・現在地の同心円状の道路に沿って移動した後、南北に伸びる道路を利用する
//
//図2
//
//
//この入力例 1 では、 1 つ内側の同心円上の道路を使うと最小の距離になります。
//円周の 4 分の 1 の長さは (半径) × (円周率) ÷ 2 で求められるため、最小の距離は 100 + 100 × π / 2 = 257.07963... となります。




//入力される値
//入力は以下のフォーマットで与えられます。
//
//N
//n_1 d_1
//n_2 d_2
//・1 行目に、同心円の数 N が整数で与えられます。
//・2 行目に、自分の居る交差点が何番目の同心円上の道路上にあるかを示す整数 n_1、中心から見てどの方角にあるかを示す文字 d_1 がこの順に半角スペース区切りで与えられます。
//・3 行目に、目的の交差点が何番目の同心円上の道路上にあるかを示す整数 n_2、中心から見てどの方角にあるかを示す文字 d_2 がこの順に半角スペース区切りで与えられます。
//・入力は合計で 3 行となり、入力値最終行の末尾に改行が １ つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください



//入力例1
//2
//2 E
//1 S
//出力例1
//257.079632679
//入力例2
//5
//4 S
//3 N
//出力例2
//700.000000000
//入力例3
//5
//1 N
//3 E
//出力例3
//357.079632679