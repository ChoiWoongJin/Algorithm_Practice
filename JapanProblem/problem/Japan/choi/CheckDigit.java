package problem.Japan.choi;

import java.util.Scanner;

class FindCardNum {
	private int cardNum;
	private char[][] cardInfo;
	private int[] digitInfo;
	public FindCardNum(int cardNum, char[][] cardInfo, int[] digitInfo) {
		this.cardNum = cardNum;
		this.cardInfo = cardInfo.clone();
		this.digitInfo = digitInfo.clone();
		
		this.find();
	}
	
	private void find() {
		int even = 0, odd = 0, getEven = 0;
		for(int i=0; i < this.cardNum; i++) {
			even = 0;
			odd = 0;
			for(int j=0; j < 15; j++) {
				if(j%2 == 0) { // even
					getEven = 2*Character.getNumericValue(this.cardInfo[i][j]);
					while(getEven >= 10) {
						getEven = getEven/10 + getEven%10;
					}
					even += getEven;
				} else { // odd
					odd += Character.getNumericValue(this.cardInfo[i][j]);
				}
			}
			this.digitInfo[i] = 10 - (even+odd)%10;
			if(this.digitInfo[i] == 10) {
				this.digitInfo[i] = 0;
			}
		}
	}
	
	
	public int[] getDigitInfo() {
		return digitInfo;
	}	
}

public class CheckDigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cardNum = sc.nextInt();
		char[][] cardInfo = new char[cardNum][16];
		int[] digitInfo = new int[cardNum];
		for(int i=0; i < cardNum; i++) {
			cardInfo[i] = sc.next().toCharArray();
		}
		
		FindCardNum fcn = new FindCardNum(cardNum, cardInfo, digitInfo);
		digitInfo = fcn.getDigitInfo();
		for(int i=0; i < cardNum; i++) {
			System.out.println(digitInfo[i]);
		}
	}

}


//クレジットカード番号は16桁の番号で表すことができますが、この番号は以下の性質を持っています。
//
//一番右の桁を1桁目として、
//
//・偶数桁の数字をそれぞれ2倍し総和をとったものをeven 
//（ただし、2倍したあと2桁の数字になるものは、1の位と10の位の数を足して1桁の数字にしたあと、総和をとる）
//・奇数桁の数字の総和をとったものをodd
//とすると、even + odd は10 で必ず割り切れます。
//
//1桁目がX と書かれた16桁の番号が複数与えられるので、それぞれに対し、上記性質をみたすようにX に入る数字を求めてください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//n　　　#入力されるクレジットカードの総数
//a_1　　#1番目のクレジットカード番号
//a_2　　#....
//a_3　　#....
//...
//a_n　　#n番目のクレジットカード番号
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//それぞれのa_i に対し、X に入る数字を一行に出力してください。出力は全部でn 行になります。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//1 ≦ n ≦ 100
//a_i (1 ≦ i ≦ n) は長さ16の文字列です。
//1文字目から15文字目は0から9までのいずれかの数字が書かれており、16文字目はX (アルファベット大文字のエックス) が書かれています。


//入力例1
//1
//846087729128569X
//出力例1
//7
//入力例2
//4
//628381026148991X
//511070105176715X
//273492510450813X
//670891979616350X
//出力例2
//5
//9
//7
//2
//入力例3
//5
//091180422478189X
//774123801013511X
//973736969204716X
//793180803472918X
//358682935182058X
//出力例3
//1
//4
//0
//1
//2