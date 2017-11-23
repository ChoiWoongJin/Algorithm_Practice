package problem.Japan.choi;

import java.util.Scanner;


class CheckHabit {
	private char[] keyInput;
	private int resultHabit;
	private static final char[][] keyboard = {{'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p'},
											  {'a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l', '0'},
											  {'z', 'x', 'c', 'v', 'b', 'n', 'm', '0', '0', '0'}};
	CheckHabit(char[] keyInput) {
		this.keyInput = keyInput.clone();
		this.resultHabit = 0;
		
		this.checkHabit();
	}
	
	private void checkHabit() {
		int check = 0;
		for(int i=0; i < this.keyInput.length; i++) {
			if(check == 1) { // left hand
				if(checkNear(this.keyInput[i], this.keyInput[i-1])) {
					if(checkTrueKey(this.keyInput[i]) == 1) { // if right key
						this.resultHabit += 1;
					}
				} else {
					check = 0;
				}
			} else if(check == 2) { // right hand
				if(checkNear(this.keyInput[i], this.keyInput[i-1])) {
					if(checkTrueKey(this.keyInput[i]) == 2) { // if left key
						this.resultHabit += 1;
					}
				} else {
					check = 0;
				}
			} else if(i > 0) {
				if( (this.keyInput[i] == 'y' && this.keyInput[i-1] == 't') ||
					(this.keyInput[i] == 'h' && this.keyInput[i-1] == 'g') || 
					(this.keyInput[i] == 'n' && this.keyInput[i-1] == 'b') ) {
					this.resultHabit += 1;
					check = 1; // left hand
				} else if ((this.keyInput[i] == 't' && this.keyInput[i-1] == 'y') ||
						   (this.keyInput[i] == 'g' && this.keyInput[i-1] == 'h') ||
						   (this.keyInput[i] == 'b' && this.keyInput[i-1] == 'n') ){
					this.resultHabit += 1;
					check = 2; // right hand
				}
			}
		}
	}
	private int checkTrueKey(char get) {
		for(int i=0; i < 3; i++) {
			for(int j=5; j < 10; j++) {
				if(get == keyboard[i][j]) {
					return 1; // right key
				}
			}
		}
		return 2; // left key
	}
	
	private boolean checkNear(char curGet, char postGet) {
		int x = -1, y = -1;
		for(int i=0; i < keyboard.length; i++) {
			for(int j=0; j < keyboard[0].length; j++) {
				if(keyboard[i][j] == curGet) {
					x = i;
					y = j;
					break;
				}
			}
			if(x > -1 || y > -1) break;			
		}
		if(x > 0) {
			if(keyboard[x-1][y] == postGet) return true;
		}
		if(x+1 < keyboard.length) {
			if(keyboard[x+1][y] == postGet) return true;
		}
		if(y > 0) {
			if(keyboard[x][y-1] == postGet) return true;
		}
		if(y+1 < keyboard[0].length) {
			if(keyboard[x][y+1] == postGet) return true;
		}
		if(keyboard[x][y] == postGet) return true;
		
		return false;
	}
	
	public int getResultHabit() {
		return this.resultHabit;
	}
}

public class HomePosition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] get = sc.next().toCharArray();
		
		CheckHabit ch = new CheckHabit(get);
		System.out.println(ch.getResultHabit());
		
		sc.close();
	}

}


//あなたは新米のプログラマです。
//今まで我流でタイプしてきたため、癖でホームポジションを破ってしまいます。
//このため仕事のペースが遅く、上司から改善するように通達されました。
//
//まず、ホームポジションでは左手で打つキーと右手で打つキーが決まっています。
//左手で打つキーは、キーボードの左側の赤色で示した部分です。
//図1
//
//また、右手で打つキーは青色で示した反対側のキーで以下のとおりです。
//図2
//
//あなたは癖で、直前に打ったキーをもう一度タイプする場合や、
//直前に打ったキーに上下左右のいずれかで隣接しているキーを打った場合に、
//ホームポジションに関わらず同じ手で入力してしまいます。
//例えば、g を打ったあとに h を打つ場合には g を打った時の左手で h を打ってしまいます。
//このまま h をもう一度打つ場合も、直前に h を打った左手で打ってしまいます。
//図3
//
//入力例2 の場合、ytrewq をホームポジション通りに打つと y だけが右手、 それ以外は左手で打ちます。
//しかし、癖がある場合は y を打ったその指で隣の t を打ち、さらに隣の r を打つ際も同様なため、全てのキーを右手で打ちます。
//図4
//
//あなたはこの癖により、どれくらいホームポジションとは違う手でタイピングをしているのか気になっています。
//実際に与えられた文字列をタイプする際に、この癖によって違う手でタイピングしてしまう回数を出力してください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//S
//・タイプする文字列 S が与えられます。
//・入力は 1 行となり、末尾に改行が１つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください



//期待する出力
//与えられた文字列 S をタイプする際に、癖によって違う手でタイピングしてしまう回数を出力してください。
//
//出力の最後に改行を入れ、余計な文字、空行を含んではいけません。
//


//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・S の各文字は半角英小文字である
//・1 ≦ ( S の長さ) ≦ 10,000


//入力例1
//paiza
//出力例1
//0
//入力例2
//ytrewq
//出力例2
//5
//入力例3
//qwertyy
//出力例3
//2