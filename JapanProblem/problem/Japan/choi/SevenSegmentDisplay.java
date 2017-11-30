package problem.Japan.choi;

import java.util.Scanner;

public class SevenSegmentDisplay {
	
	private int[][] sevenSegment = { {1,1,1,1,1,1,0}, {0,1,1,0,0,0,0}, {1,1,0,1,1,0,1}, {1,1,1,1,0,0,1},
			                         {0,1,1,0,0,1,1}, {1,0,1,1,0,1,1}, {1,0,1,1,1,1,1}, {1,1,1,0,0,1,0},
			                         {1,1,1,1,1,1,1}, {1,1,1,1,0,1,1} };
	private int[][] number;
	private String[] displayState; 
	
	SevenSegmentDisplay(int[] firstNumber, int[] secondNumber) {
		this.number = new int[2][7];
		this.number[0] = firstNumber.clone();
		this.number[1] = secondNumber.clone();
		this.displayState = new String[3];
		
		checkDisplay();
	}
	
	private void checkDisplay() {
		// case 1 : correct Display Number
		if( checkDisplay(this.number) ) {
			this.displayState[0] = "Yes";
		} else {
			this.displayState[0] = "No";
		}
		
		int[][] sysmmetryCheck = new int[2][7];
		int[][] rotateCheck = new int[2][7]; 
		for(int i=0; i < 7; i++) {
			sysmmetryCheck[0][i] = this.number[0][i];
			sysmmetryCheck[1][i] = this.number[1][i];
			rotateCheck[0][i] = this.number[0][i];
			rotateCheck[1][i] = this.number[1][i];
		}
		
		// case 2 : SymmetryMove is correct Display Number
		if( checkDisplay(symmetryMove(sysmmetryCheck)) ) {
			this.displayState[1] = "Yes";
		} else {
			this.displayState[1] = "No";
		}
		
		// case 3 : RotateMove is correct Display Number
		if( checkDisplay(rotateMove(rotateCheck)) ) {
			this.displayState[2] = "Yes";
		} else {
			this.displayState[2] = "No";
		}		
	}
	
	public void printDisplayState() {
		for(int i=0; i < this.displayState.length; i++) {
			System.out.println(this.displayState[i]);
		}
	}
	
	private int[][] symmetryMove(int[][] changeNumber) {
		//		a1			b1
		//    a6  a2      b6  b2
		//		a7			b7
		//    a5  a3      b5  b3
		//		a4			b4
		int temp=0;
		
		// a1-b1
		temp = changeNumber[0][0];
		changeNumber[0][0] = changeNumber[1][0];
		changeNumber[1][0] = temp;
		
		// a2-b6, a6-b2
		temp = changeNumber[0][1];
		changeNumber[0][1] = changeNumber[1][5];
		changeNumber[1][5] = temp;
		temp = changeNumber[0][5];
		changeNumber[0][5] = changeNumber[1][1];
		changeNumber[1][1] = temp;
		
		// a7-b7
		temp = changeNumber[0][6];
		changeNumber[0][6] = changeNumber[1][6];
		changeNumber[1][6] = temp;
		
		// a3-b5, a5-b3
		temp = changeNumber[0][2];
		changeNumber[0][2] = changeNumber[1][4];
		changeNumber[1][4] = temp;
		temp = changeNumber[0][4];
		changeNumber[0][4] = changeNumber[1][2];
		changeNumber[1][2] = temp;
		
		// a4-b4
		temp = changeNumber[0][3];
		changeNumber[0][3] = changeNumber[1][3];
		changeNumber[1][3] = temp;
		
		return changeNumber;
	}
	private int[][] rotateMove(int[][] changeNumber) {
		//		a1			b1
		//    a6  a2      b6  b2
		//		a7			b7
		//    a5  a3      b5  b3
		//		a4			b4
		int temp=0;
		
		// a1-b4
		temp = changeNumber[0][0];
		changeNumber[0][0] = changeNumber[1][3];
		changeNumber[1][3] = temp;
		
		// a2-b5, a6-b3
		temp = changeNumber[0][1];
		changeNumber[0][1] = changeNumber[1][4];
		changeNumber[1][4] = temp;
		temp = changeNumber[0][5];
		changeNumber[0][5] = changeNumber[1][2];
		changeNumber[1][2] = temp;
		
		// a7-b7
		temp = changeNumber[0][6];
		changeNumber[0][6] = changeNumber[1][6];
		changeNumber[1][6] = temp;
		
		// a3-b6, a5-b2
		temp = changeNumber[0][2];
		changeNumber[0][2] = changeNumber[1][5];
		changeNumber[1][5] = temp;
		temp = changeNumber[0][4];
		changeNumber[0][4] = changeNumber[1][1];
		changeNumber[1][1] = temp;
		
		// a4-b1
		temp = changeNumber[0][3];
		changeNumber[0][3] = changeNumber[1][0];
		changeNumber[1][0] = temp;
		
		return changeNumber;
	}
	private boolean checkDisplay(int[][] checkNumber) {
		int checker = 0;
		for(int i=0; i < this.sevenSegment.length; i++) {
			if(checkDisplayNumber(this.sevenSegment[i], checkNumber[0])) {
				checker += 1;
			}
			if(checkDisplayNumber(this.sevenSegment[i], checkNumber[1])) {
				checker += 1;
			}
		}		
		return (checker == 2) ? true : false;
	}
	private boolean checkDisplayNumber(int[] number1, int[] number2) {
		for(int i=0; i < number1.length; i++) {
			if(number1[i] != number2[i]) return false;
		}		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] getFirst = sc.nextLine().split(" ");
		String[] getSecond = sc.nextLine().split(" ");
		int[] firstNumber = new int[7];
		int[] secondNumber = new int[7];
		for(int i=0; i < getFirst.length; i++) {
			firstNumber[i] = Integer.parseInt(getFirst[i]);
			secondNumber[i] = Integer.parseInt(getSecond[i]);
		}
		
		SevenSegmentDisplay ssd = new SevenSegmentDisplay(firstNumber, secondNumber);
		ssd.printDisplayState();
		
		sc.close();
	}
}


//7セグメントディスプレイは、7つのセグメントの点灯と消灯の状態を組み合わせて、0～9の数字を表示する装置です。
//
//
//
//ある7セグメントディスプレイ s の i 番目のセグメント s_i が点灯しているならばs_i=1と表し、消灯しているならば s_i=0 と表します。 s_1～s_7 を並べることで、7セグメントディスプレイの状態を表現することができます。
//
//下の表は各数字に対応する7セグメントディスプレイの状態の一覧です。
//数字	s_1～s7
//0	1111110
//1	0110000
//2	1101101
//3	1111001
//4	0110011
//5	1011011
//6	1011111
//7	1110010
//8	1111111
//9	1111011
//
//あなたは趣味の電子工作で、2つの7セグメントディスプレイを横に並べて00～99の2桁の数字を表示する装置を作りました。 ところが、配線を間違ってしまったのか、意図しないセグメントが点灯・消灯してしまいます。
//
//この装置をよく観察すると、どうやら装置を対称移動したり回転移動すれば、正しく2桁の数字を表示することができるようです。
//
//・対称移動とは、装置の左右の端から等しい距離にある対称軸を基準に装置全体を奥行方向に180度回転させて、裏返す操作のことです。
//・回転移動とは、装置の中央にある中心点を中心に装置全体を平面的に180度回転させて、逆さまにする操作のことです。
// 
// 
//入力として装置の2つの7セグメントディスプレイ a と b の状態が与えられるので、次の各条件を満たすかどうか判定するプログラムを作成してください。
//
//1. 装置が正しく2桁の数字を表す
//2. 装置を対称移動すると正しく2桁の数字を表す
//3. 装置を回転移動すると正しく2桁の数字を表す
//
//それぞれの条件を満たすかどうか調べるプログラムを書いてください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//a_1 a_2 a_3 a_4 a_5 a_6 a_7
//b_1 b_2 b_3 b_4 b_5 b_6 b_7
//1行目に1つ目の7セグメントディスプレイの状態、2行目に2つ目の7セグメントディスプレイの状態が与えられます。
//
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//以下の3つの条件についてそれぞれ順番に条件を満たすなら "Yes" 、満たさないならば "No" を出力し、改行区切りで出力してください。
//
//装置が正しく2桁の数字を表すか
//装置を対称移動すると正しく2桁の数字を表すか
//装置を回転移動すると正しく2桁の数字を表すか
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//・a_i = 0, 1 (1 ≦ i ≦ 7)
//・b_j = 0, 1 (1 ≦ j ≦ 7)
//
//与えられる各7セグメントディスプレイは、正しく2桁の数字を表すか、回転移動もしくは対称移動したときに正しく2桁の数字を表す。


//入力例1
//1 1 1 1 0 1 1
//0 1 1 0 0 0 0
//出力例1
//Yes
//No
//No
//入力例2
//0 0 0 0 1 1 0
//1 1 0 1 1 1 1
//出力例2
//No
//Yes
//No