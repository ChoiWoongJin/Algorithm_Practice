package problem.Japan.choi;

import java.util.Scanner;

class CheckCardhand {
	private char[] cards;
	private String cardResult;
	
	CheckCardhand(char[] cards) {
		this.cards = cards.clone();		
		
		checkCards();
	}
	
	private void checkCards() {
		int numStar=0, checkTwo = 0, maxType = 0;
		int[] cardType = new int[4];
		for(int i=0; i < 4; i++) {
			cardType[i] = 1;
			
			if(cards[i] == '*') numStar++;
			else if(cards[i] != ' ') {
				for(int j=i+1; j < 4; j++) {
					if(cards[i] == cards[j]) {
						cardType[i] ++;
						cards[j] = ' ';
					}
				}
			}
		}
		for(int i=0; i < 4; i++) {
			if(cardType[i] == 2) {
				checkTwo++;
			}
			if(cardType[i] > maxType) {
				maxType = cardType[i];
			}
		}
		
		if(checkTwo == 2) {
			this.cardResult = getType(checkTwo);
		} else {
			if(numStar == 0) {
				if(maxType == 1) {
					this.cardResult = getType(0); // NoPair
				} else if(maxType == 2) {
					this.cardResult = getType(1); // OnePair
				} else {
					this.cardResult = getType(maxType);
				}
			} else {
				if(numStar == 1 && maxType == 1) {
					this.cardResult = getType(1);
				} else {
					this.cardResult = getType(maxType+numStar);
				}
			}
		}		
	}
	
	private String getType(int cardNum) {
		if(cardNum == 0) {
			return "NoPair";
		} else if(cardNum == 1) {
			return "OnePair";
		} else if(cardNum == 2) {
			return "TwoPair";
		} else if(cardNum == 3) {
			return "ThreeCard";
		} else {
			return "FourCard";
		}		
	}
	
	public String getCardResult() {
		return this.cardResult;
	}	
}

public class StrongOfCardhand {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] cards = sc.next().toCharArray();
		CheckCardhand cc = new CheckCardhand(cards);
		System.out.println(cc.getCardResult());
		
		sc.close();
	}
}


//あなたはあるカードゲームを楽しんでいましたが、 ある時、いい手役ができていることに気づかず、 勝てるはずのゲームで負けていることに気づきました。
//とても悔しかったあなたは、 手役を判定するプログラムを作成しようと考えています。
//
//このゲームでは、 A から Z のアルファベット、あるいは、 「*」 が書かれたカードが４枚配られ、 この４枚を使って手役を作ります。
//手役には以下のものがあります。
//
//・ノーペア (NoPair)
//・1 ペア (OnePair)
//・2 ペア (TwoPair)
//・3 カード (ThreeCard)
//・4 カード (FourCard)
//
//手役の強さは、下の手役の方が強く、上の手役の方が弱くなっています。
//("FourCard" ＞ "ThreeCard" ＞ "TwoPair" ＞ "OnePair" ＞ "NoPair")
//
//A から Z の他にも 「*」 が書かれたカードが配られることもあります。 
//このカードはワイルドカードと呼ばれ、 好きなアルファベットとして使うことができます。
//
//配られた 4 枚のカードが入力として与えられるので、 その 4 枚でできる最も強い手役の名前を出力して下さい。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//s
//s は長さ 4 の文字列
//入力値最終行の末尾に改行が１つ入ります。
//
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//入力された 4 枚のカードから作れる最高の手役を "FourCard"、"ThreeCard"、"TwoPair"、"OnePair"、"NoPair"の中から選び、 1 行で出力して下さい。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//入力されるカードの枚数は4枚です。 与えられる文字列のどの文字も、 アルファベットの大文字 A ～ Z か、 ワイルドカード * の 27 種類のいずれかです。 
//与えられる文字列は、 高々１つしかワイルドカード * を含みません。


//入力例1
//ABCD
//出力例1
//NoPair
//入力例2
//ABAB
//出力例2
//TwoPair
//入力例3
//*ZZD
//出力例3
//ThreeCard