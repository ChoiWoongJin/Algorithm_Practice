package problem.Japan.choi;

import java.util.*;

public class RabbitJump {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        int bushN = sc.nextInt();
        int rabbit = sc.nextInt();
        int rotate = sc.nextInt();
        int[] bush = new int[bushN];
        int[] rabbitPoint = new int[rabbit];
        
        for(int i=0; i < rabbit; i++) {
        	bush[i] = 0;
        }
        for(int i=0; i < rabbit; i++) {
        	bush[sc.nextInt()-1] = i+1;
        }
        
        for(int i=0; i < rotate; i++) {
        	bush = rabbitJump(bush, rabbit);
        }
        
        for(int i=0; i < rabbit; i++) {
        	for(int j=0; j < bushN; j++) {
        		if(bush[j] == i+1) {
        			rabbitPoint[i] = j+1;
        		}
        	}
        }
        
        for(int i=0; i < rabbit; i++) {
        	System.out.println(rabbitPoint[i]);
        }
        
        
    }
    
    public static int[] rabbitJump(int[] bush, int R) {
    	int check = 1;
    	int i=0;
    	int point = 0;
    	
    	while(check <= R) {
    		if(bush[i] == check) {
    			point = i + 1;
    			for(int j=1; j < bush.length; j++) {
    				point = point%bush.length;
    				if(bush[point] == 0) {
    					bush[point] = check;
    					bush[i] = 0;
    					i = 0;
    					check++;
    					break;    					
    				} else {
    					point++;
    				}
    			}
    		} else {
    			i++;
    		}
    	}    	
    	
    	return bush;
    }
}

//N 個のしげみが円周上に並んでいます。
//N 個のしげみには反時計回りに 1, 2, ..., N と番号がついています。(次の図を参照)
//
// 
//いくつかのしげみにはうさぎがいます。1 箇所のしげみに 2 羽以上のうさぎがいることはありません。
//今、全体で M 羽のうさぎがいます。ただし、うさぎの数は必ずしげみの数より少ないものとします。
//
//うさぎに 1, 2, ..., M と番号をつけたとき、それぞれのうさぎは次のルールに従って今いるしげみから別のしげみへジャンプします。
//
//まず、1 番目のうさぎが、今いるしげみから反時計回りに見て最も手前にある空いているしげみにジャンプする
//次に、2 番目のうさぎが、今いるしげみから反時計回りに見て最も手前にある空いているしげみにジャンプする
//……
//最後に、M 番目のうさぎが、今いるしげみから反時計回りに見て最も手前にある空いているしげみにジャンプする
//
//これらのジャンプが K セット終わったとき、すなわち、すべてのうさぎがちょうど K 回ジャンプしたとき、それぞれのうさぎがどのしげみにいるかを求めてください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//N M K
//r_1
//r_2
//...
//r_M
//
//1 行目には 3 つの整数 N, M, K が入力されます。
//N はしげみの個数を、M はうさぎの総数を、K はそれぞれのうさぎがジャンプする回数を表します。
//
//続く M 行には、うさぎの位置が入力されます。
//r_i は i 番目のうさぎがいるしげみの番号を表します。
//
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください



//期待する出力
//出力は M 行からなります。
//i 行目には、K セットのジャンプが終わったあとに i 番目のうさぎがいるしげみの番号を出力してください。
//(i = 1, 2, ..., M)
//
//最後は改行し、余計な文字、空行を含んではいけません。



//条件
//すべてのテストケースで以下の条件を満たします。
//
//・2 ≦ N ≦ 50
//・1 ≦ M < N
//・1 ≦ K ≦ 50
//・1 ≦ r_i ≦ N
//・i ≠ j のとき r_i ≠ r_j



//入力例1
//5 2 2
//1
//2
//出力例1
//5
//1
//入力例2
//6 3 6
//1
//3
//5
//出力例2
//1
//3
//5