package problem.Japan.choi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

		// 1, 꺾음	1
		// 2, 꺾음	1
		// 4, 꺾음	2
		// 6, 꺾음	2
		// 9, 꺾음	3
		// 12, 꺾음	3
		// 16, 꺾음	4
		// 20, 꺾음	4

class MoveSimulation {
	private Map<String, Integer> map;
	private int[][] currentPointXY;
	private int peopleNum;	
	private int curTime;
	private int direction; // 0 : right, 1 : up, 2 : left, 3 : down;
	private int move; // moveCount
	private int checkAddMove;
	private int[] canMoveInfo;
	private int maxTime;
	
	
	MoveSimulation(Map<String, Integer> map, int[][] currentPointXY, int peopleNum) {
		this.map = new HashMap<String, Integer>(map);
		this.currentPointXY = currentPointXY.clone();
		this.peopleNum = peopleNum;
		this.curTime = 0;
		this.direction = 0;
		this.move = 1;
		this.checkAddMove = 0;
		this.canMoveInfo = new int[peopleNum];
		this.maxTime = 0;
		checkTime();
	}
	public void checkTime() {
		int x = 0, y = 0;
		StringBuffer sb = new StringBuffer();
		String XY = "";
		int check = 0;
		int canMovePeople = this.peopleNum;
		while(canMovePeople > 0) {
			for(int m=0; m < this.move; m++) {
				this.curTime += 1;	
				for(int i=0; i < this.peopleNum; i++) {
					if(this.canMoveInfo[i] == 0) {
						if(this.direction == 0) {
							x = this.currentPointXY[i][0] + 1;
							y = this.currentPointXY[i][1];
						} else if(this.direction == 1) {
							x = this.currentPointXY[i][0];
							y = this.currentPointXY[i][1] - 1;
						} else if(this.direction == 2) {
							x = this.currentPointXY[i][0] - 1;
							y = this.currentPointXY[i][1];
						} else if(this.direction == 3) {
							x = this.currentPointXY[i][0];
							y = this.currentPointXY[i][1] + 1;
						}
						sb.setLength(0);
						XY = sb.append(x).append(",").append(y).toString();
						
						if(!this.map.containsKey(XY)) {
							this.map.put(XY, this.curTime);
							this.currentPointXY[i][0] = x;
							this.currentPointXY[i][1] = y;
						} else { // if move point is already someone was gone
							this.canMoveInfo[i] = 1;				
							canMovePeople -= 1;
						}
					}
				}
			}
			this.checkAddMove += 1;
			if(this.checkAddMove%2 == 0) this.move += 1;
			this.direction = (this.direction+1)%4;
		}
	}

	public int getMaxTime() {
		Iterator<String> itr = this.map.keySet().iterator();
		int getItem = 0;
		while(itr.hasNext()) {
			getItem = this.map.get(itr.next());			
			if(getItem > this.maxTime) this.maxTime = getItem; 
		}				
		return this.maxTime;
	}	
}

public class MoveOnPlaneSimulation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int peopleNum = sc.nextInt();
		int[][] currentPointXY = new int[peopleNum][2];
		Map<String, Integer> map = new HashMap<String, Integer>();
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < peopleNum; i++) {
			sb.setLength(0);
			currentPointXY[i][0] = sc.nextInt(); // point X
			currentPointXY[i][1] = sc.nextInt(); // point Y
			map.put(sb.append(currentPointXY[i][0]).append(",").append(currentPointXY[i][1]).toString(), 0);
		}
				
		MoveSimulation ms = new MoveSimulation(map, currentPointXY, peopleNum);
		System.out.println(ms.getMaxTime());
	}

}


//正方形からなる格子状に区切られた無限に広がる二次元平面を考えます。 
//基点のマスを(0, 0) として、それぞれのマスを整数x, y を用いて(x, y) で表します。x 軸は右向きを正として、y 軸は下向きを正とします。
//
//いま、初期状態として、N (≧ 2) 人の小人が異なるマスの上に立っています。
//時間をt で表すことにして、この初期状態を時間t = 0 における状態とします。 時間t は1 ずつ増加していき、1 増加するたびに小人たちはルールに従ってマスの上を歩いていきます。このとき、すべての小人は同時に動きます。
//
//小人たちは以下の画像のように、螺旋状にぐるぐると歩いていきます。マスに書かれている数字は時間であり、数字0 のマスは各小人が最初(t = 0) に立っているマスに対応します。t = 1 で各小人は右のマスに移動します。t = 2 ではその上のマスに移動し、t = 3 ではそこから左に移動します。
//
//[N=3の場合の一例]
// 
//小人はt = 0 で現在立っているマスに印をつけ、以降、次のマスに到達するごとにそのマスに印をつけて歩いていきます。
//通常、小人は上記画像のように螺旋状に歩き続けますが、以下に該当する小人は途中で歩くことをやめてしまいます。
//
//・時間t = s とする。時間t = s + 1 に進むべきマスにすでに他の小人が印をつけていたとき、その小人は時間s に停止する。（すでに小人が歩いたマスへの侵入を禁止する）
//・時間t = s とする。時間t = s + 1 に進むべきマスが、他の小人にとっても時間t = s + 1 に進むべきマスであるとき、その小人は時間s に停止する。(一つのマスに複数の小人が同時に入ることを禁止する)
//
//小人の数N と各小人が最初にいるマスの座標が与えられるので、すべての小人が歩くことをやめたときの時間t を求めてください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//N (小人の数)
//x_1 y_1 (小人1の座標x,小人1の座標y)
//x_2 y_2 (小人2の座標x,小人2の座標y)
//...
//x_N y_N (小人Nの座標x,小人Nの座標y)
//
//ここで、x_i, y_i (1 ≦ i ≦ N) はN 人の小人の初期位置を示します。
//
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//小人が全て停止する時間tを一行に出力してください。
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//2 ≦ N ≦ 100
//-100 ≦ x_i, y_i ≦ 100 (1 ≦ i ≦ N)


//入力例1
//3
//-1 2
//3 -1
//-2 -2
//出力例1
//28
//入力例2
//10
//19 8
//68 40
//-48 4
//60 29
//22 90
//-76 -35
//60 93
//-26 22
//45 73
//-61 59
//出力例2
//4660