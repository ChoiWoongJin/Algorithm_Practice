package problem.Japan.choi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ConquerParade {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // parade Num
		int M = sc.nextInt(); // parade Days
		int[] paradePlan = new int[M]; // Prade Days Plan
		Set<Integer> paradeView = new HashSet<Integer>(); // check can parade View
		int min = M;
		for(int i=0; i < M; i++) {
			paradePlan[i] = sc.nextInt();
		}
		
		for(int i=0; i < M; i++) {
			if(i+1 < M) {
				if(paradePlan[i] == paradePlan[i+1]) continue;
			}			
			paradeView.clear();
			for(int j=i; j < M; j++) {
				if(j > i) {
					if(paradePlan[j] == paradePlan[j-1]) continue;
				}
				if(j+1 < M && paradeView.contains(paradePlan[j])) continue;
				else if(!paradeView.contains(paradePlan[j])) paradeView.add(paradePlan[j]);				
				if(paradeView.size() == N) {
					if(min>j-i) min = j-i+1;
					break;
				}
			}
			if(min == N) break;
		}		
		System.out.println(min);
		sc.close();
	}
}

//-日々仕事に追われるあなたの唯一の楽しみは、たまの休日に一人でパイザランドに遊びに行くことです。
//
//パイザランドは非常に人気のあるテーマパークで、その魅力はなんといっても毎日開かれる日替わりのパレードです。パレードは全部でN 種類あり、毎日夜になるとその内の一つのパレードが行われます。 
//そのパレードが大好きなあなたは、N 種類すべてのパレードをぜひ見てみたいと思いました。
//しかしながら仕事の都合上、頻繁に休みをとることができません。そこで有給を使って連続した休みを一気にとり、毎日パイザランドに行くことでN 種類すべてのパレードを見ることにしました。場合によっては同じパレードを複数回見ることもあり得ますが、もちろん覚悟のうえです。
//
//さて、パレードの種類数 N とM 日分のパレードの予定表が与えられるので、すべてのパレードを見るために必要な連続した日の最小の日数を求めるプログラムを作成してください。
//
//以下は入力例1の N = 5 (パレードの種類) M = 8 (パレードの行われる全日数) の場合の図になります。
// 
//※解法の注意点
//もっとも一般的な全探索（期間内の連続する全日数を確認）するアルゴリズムは計算量でいくつかの
//テストケースがタイムオーバーとなります。最大値が入力される場合の計算量を考慮し、より効率的なアルゴリズムを考えてみてください。
//
//※アルゴリズムのヒント
//探索する休みの期間をM/2の長さから始め、
//その期間の中で条件を満たす（N個のパレードを制覇する）ことができれば、M/2より短い休みの期間の中で探索し、
//その期間の中で条件を満たす（N個のパレードを制覇する）ことができなければ、M/2より長い休みの期間で探索する
//というアルゴリズムがあります。
//
//またこのアルゴリズムよりも更に効率的なアルゴリズムも想定解法としてあります。


//入力される値
//N M　　　#パレードの種類N パレードの全日程M
//d_1　　　#1日目のパレードの種類
//d_2　　　#2日目のパレードの種類
//...
//d_M　　　#M日目のパレードの種類
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//すべてのパレードを見るために必要な連続した日の最小の日数を出力してください。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//1 ≦ N(パレードの種類) ≦ M(パレードの全日程)
//1 ≦ M(パレードの全日程) ≦ 100000
//1 ≦ d_i(各パレードの種類) ≦ N (1 ≦ i ≦ M)
//すべてのパレードは、M 日分の予定表の中に少なくとも一度は現れる。


//入力例1
//5 8
//4
//4
//3
//4
//5
//2
//4
//1
//出力例1
//6
//入力例2
//3 11
//1
//2
//1
//1
//3
//2
//3
//2
//1
//2
//1
//出力例2
//3