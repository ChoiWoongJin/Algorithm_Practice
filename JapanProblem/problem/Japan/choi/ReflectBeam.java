package problem.Japan.choi;

import java.util.Scanner;

public class ReflectBeam {
	
	public static int reflect(char[][] map, int H, int W, int x, int y, int way, int result) {
		// way, 0 = right, 1 = down, 2 = left, 3 = up
		if(x >= H || y >= W || x < 0 || y < 0) return result; // map over
		
		if(map[x][y] == '_') { // here is nothing
			if(way == 0)			result = reflect(map, H, W, x,     y+1, way, result+1);
			else if(way == 1)		result = reflect(map, H, W, x+1, y,     way, result+1);
			else if(way == 2)		result = reflect(map, H, W, x,     y-1,  way, result+1);
			else if(way == 3)		result = reflect(map, H, W, x-1,  y,     way, result+1);
		}
		
		if(map[x][y] == '/') { // here is mirror
			if(way == 0)			result = reflect(map, H, W, x-1,  y,    3, result+1);
			else if(way == 1)		result = reflect(map, H, W, x,     y-1, 2, result+1);
			else if(way == 2)		result = reflect(map, H, W, x+1, y,    1, result+1);
			else if(way == 3)		result = reflect(map, H, W, x,     y+1, 0, result+1);
		}
		
		if(map[x][y] == '\\') { // here is mirror
			if(way == 0)			result = reflect(map, H, W, x+1,  y,     1, result+1);
			else if(way == 1)		result = reflect(map, H, W, x,      y+1, 0, result+1);
			else if(way == 2)		result = reflect(map, H, W, x-1, y,       3, result+1);
			else if(way == 3)		result = reflect(map, H, W, x,     y-1,   2, result+1);
		}
		
		
		return  result;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int H = sc.nextInt();
		int W = sc.nextInt();
		char[][] map = new char[H][W];
		for(int i=0; i < H; i++) {
			map[i] = sc.next().toCharArray();
		}
		System.out.println(reflect(map, H, W, 0, 0, 0, 0));
	}

}

//内部が格子状の正方形の区画に分けられ、一部の区画に鏡が配置された箱を考えます。
//今、その箱を上部から眺めているものとし、箱の高さは考えないことにします。
//鏡は区画の対角線上に配置され、1つの区画には1枚の鏡を配置することができます。
//
//鏡のない区画を'_' 、端点が区画の右上および左下の頂点であるような対角線の上に配置された鏡を'/'、もう一方の対角線上に配置された鏡を'\' で表すこととする。
//
//高さが3, 幅が5 の箱の例として次があげられます。
//(環境によりバックスラッシュが円マークで表示される可能性があります)
//__\_/
//___/_
//\/\_/
//さて、箱の左上の区画に対し、箱の左側の外部から箱の内部に向けてビームを撃つことを考えます。
//
//まず、ビームは右に向かって真っ直ぐ飛び、鏡がない区画は通過します。
//鏡がある区画に入るとビームは鏡の向きに従って反射し、90°角度を変えて同様に進み、反射後も必ず真っ直ぐ進みます。
//また、ビームは箱の外周上に到達すると外へ飛び出すようになっており、箱の内部に打ち込まれた後、外部に飛び出るまで反射を続け飛び回ります。
//
//先の文字列で表された箱に実際にビームの軌跡を重ねた図
//図
//箱の高さHと幅W、および箱の内部の状態が与えられるので、箱の内部に向けてビームが撃たれてから箱の外部に飛び出るまでにビームが箱の中の区画を通過する回数を答えてください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//H W　　　#箱の高さ H , 幅 W
//s_1　　　#1列目の箱の状態を示した文字列
//s_2　　　#2列目の箱の状態を示した文字列
//...
//s_H　　　#H列目の箱の状態を示した文字列
//ここで、s_i (1 ≦ i ≦ H) は'_', '/', '\' の三文字からなる長さW の文字列で、箱の内部の状態を表します。
//
//環境によりバックスラッシュが円マークで表示されます。その場合は文字コードによるバグを防ぐため、ソースコードに記述する際はサンプル入力からバックスラッシュをコピー&ペーストすることを推奨します。
//また言語によりバックスラッシュやスラッシュの文字列の扱いでエスケープが必要な場合があるので気をつけてコーディングをしてください。
//
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//左側から左上の箱の内部に向けてビームが撃たれてから箱の外部に飛び出るまでにビームが箱の中の区画を通過する回数を出力して下さい。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//1 ≦ H ≦ 100
//1 ≦ W ≦ 100


//入力例1
//3 5
//__\_/
//___/_
//\/\_/
//出力例1
//9
//入力例2
//4 4
//___\
//_\__
//____
//_\_/
//出力例2
//12
//入力例3
//3 2
//_\
////
//\/
//出力例3
//7