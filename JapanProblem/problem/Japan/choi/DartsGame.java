package problem.Japan.choi;

import java.util.Scanner;

class PlayGame {
	private double startHeight;
	private double startSpeed;
	private double startAngle;
	private double objectDistance;
	private double objectHeight;
	private double objectSize;
	private static final double g = 9.8;
	private double hitPoint;
	
	PlayGame(double startHeight, double startSpeed, double startAngle, double objectDistance, double objectHeight, double objectSize ) {
		this.startHeight = startHeight;
		this.startSpeed = startSpeed;
		this.startAngle = Math.toRadians(startAngle);
		this.objectDistance = objectDistance;
		this.objectHeight = objectHeight;
		this.objectSize = objectSize;
		
		this.play();
	}
	
	private void play() {
		this.hitPoint = this.startHeight + this.objectDistance*Math.tan(startAngle) - ( g*Math.pow(this.objectDistance, 2) )/( 2 * Math.pow(this.startSpeed, 2)*Math.pow(Math.cos(this.startAngle), 2) );
		this.hitPoint = Math.abs(this.hitPoint - this.objectHeight);
		if(this.hitPoint > this.objectSize/2) {
			this.hitPoint = -1;
		} else {
			this.hitPoint = Math.round(this.hitPoint*10)/10.0;
		}
	}
	
	public double getDistance() {
		return this.hitPoint;
	}
	
}

public class DartsGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double startHeight = sc.nextDouble(); // o_y
		double startSpeed = sc.nextDouble(); // s
		double startAngle = sc.nextDouble(); // angle
		double objectDistance = sc.nextDouble(); // x
		double objectHeight = sc.nextDouble(); // y
		double objectSize = sc.nextDouble(); // size
		
		PlayGame pg = new PlayGame(startHeight, startSpeed, startAngle, objectDistance, objectHeight, objectSize);
		double result = pg.getDistance();
		if(result < 0) {
			System.out.println("Miss");
		} else {
			System.out.println("Hit " + result);
		}
		
		
		sc.close();
	}

}

//矢を投げ、的に命中するかシュミレーションします。
//
//x,y二次元平面上の地点 x=0[m] の高さ o_y[m] に矢の中心を置き初速 s[m/s] で x水平面に対して角度θ[度] で投げます。
//距離x[m] の地点の高さ y[m] の位置を中心に直径 a[m] の的が図のようにy軸に平行に立ててあります。
//この際、空気抵抗等は無いものとして的に矢の中心の軌道が当たるかどうか判定し、当たった場合、的の中心からの距離を小数点第2位で四捨五入 した小数点第1位までの数値を出力してください。
//矢の軌道を求める式は以下のようになります。
// 
//重力加速度gは 9.8[m/s^2] とします。


//入力される値
//1行目には初期値点の高さo_y,矢の初速s,角度θがスペース区切りの数値で入力されます。
//2行目には的までの距離xと高さyと的の大きさがスペース区切りの数値で入力されます。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//入力された値で矢が的に当たる場合はHitと的にあたった位置の中心からの距離を出力してください。
//当たった際の距離は小数点第2位を四捨五入して小数点第1位まで出力してください。
//当たらなかった場合はMissと出力してください。


//条件
//10個のテストケースの内、全てのテストケースにおいて以下の条件を満たします。
//以下の範囲で整数値
//0 ≦ o_y[初期位置の高さ m] ≦ 100
//1 ≦ [初速 m/s] ≦ 100
//0 ≦ θ[度] ≦ 90
//1 ≦ x[的までの距離 m] ≦ 100
//0 ≦ y[的の高さ m] ≦ 100
//1 ≦ a[的の直径 m] ≦ 100
//重力加速度は小数値で以下のように定義します。
//g[重力加速度 m/s^2] = 9.8
//また、浮動小数の誤差が起こることを考慮しテストケースの矢の軌道は的の端0.05の範囲は通らないものとして入力されます。


//入力例
//10 10 10
//10 10 10
//出力例
//Hit 3.3
//入力例2
//10 15 45
//10 10 10
//出力例2
//Miss