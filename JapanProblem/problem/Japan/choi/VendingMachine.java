package problem.Japan.choi;

import java.util.Scanner;

public class VendingMachine {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] coinInfo = new int[5];
		coinInfo[0] = 0;
		for(int i=1; i < 5; i++) {
			coinInfo[i] = sc.nextInt();
		}
		int N = sc.nextInt();
		int[][] nInfo = new int[N][5];
		int[][] result = new int[N][5];
		for(int i=0; i < N; i++) {
			nInfo[i][0] = sc.nextInt();
			nInfo[i][1] = sc.nextInt();
			nInfo[i][2] = sc.nextInt();
			nInfo[i][3] = sc.nextInt();
			nInfo[i][4] = sc.nextInt();
			
			result[i][1] = 0; // coin_500
			result[i][2] = 0; // coint_100
			result[i][3] = 0; // coint_50
			result[i][4] = 0; // coint_10
		}
		
		int itemValue;
		int inputCoin;
		int charge;
		int temp;
		int[] coinTemp = new int[5];
		int[] coinTemp2 = new int[5];
		for(int i=0; i < N; i++) {
			itemValue = nInfo[i][0];
			inputCoin = inputCoinSum(nInfo[i]);
			charge = inputCoin - itemValue;
			if(charge < 0) {
				result[i][0] = -1;
			} else {
				for(int k=0; k < 5; k++) {
					coinTemp2[k] = coinInfo[k];
				}
				coinTemp = getCharge(charge, coinTemp2);
				if(coinTemp[0] == -1) {
					result[i][0] = -1;
				} else {
					result[i] = coinTemp;
				}				
			}
			if(result[i][0] != -1) {
				for(int k=1; k < 5; k++) {
					coinInfo[k] -= result[i][k];
					coinInfo[k] += nInfo[i][k];
				}
			}
		}
		
		for(int i=0; i < N; i++) {
			if(result[i][0] == -1) {
				System.out.println("impossible");
			} else {
				System.out.println(result[i][1] + " " + result[i][2] + " " + result[i][3] + " " + result[i][4]);
			}
		}

	}
	
	public static int[] getCharge(int charge, int[] coinInfo) {
		int[] result = new int[5];		
		for(int i=1; i < 5; i++) {
			result[i] = 0;
		}
		
		int check=1;		
		while(check>0) {
			if(charge == 0) {
				break;
			} else if(charge-500 >= 0 && coinInfo[1] > 0) {
				charge -= 500;
				coinInfo[1]--;
				result[1]++;
			} else {
				break;
			}
		}
		while(check>0) {
			if(charge == 0) {
				break;
			} else if(charge-100 >= 0 && coinInfo[2] > 0) {
				charge -= 100;
				coinInfo[2]--;
				result[2]++;
			} else {
				break;
			}
		}
		while(check>0) {
			if(charge == 0) {
				break;
			} else if(charge-50 >= 0 && coinInfo[3] > 0 && result[3] < 1) {
				charge -= 50;
				coinInfo[3]--;
				result[3]++;
			} else {
				break;
			}
		}
		while(check>0) {
			if(charge == 0) {
				break;
			} else if(charge-10 >= 0 && coinInfo[4] > 0 && result[4] < 9 && (result[3]*50 + (result[4]+1)*10 != 100)) {				
				charge -= 10;
				coinInfo[4]--;
				result[4]++;
			} else {
				break;
			}
		}
		
		if(charge > 0) {
			result[0] = -1;
		}
		
		return result;
	}
	
	public static int inputCoinSum(int[] nInfo) {
		int sum = 0;
		
		sum += nInfo[1]*500;
		sum += nInfo[2]*100;
		sum += nInfo[3]*50;
		sum += nInfo[4]*10;		
		
		return sum;
	}
	
}


//あなたは自動販売機システムの作成を担当しています。 この自動販売機では、日本円の500円・100円・50円・10円の4種類の硬貨を扱います。 販売される商品は全て200円以下です。 
//システムには投入金額と購入金額からおつりを計算し、 おつりを返却するか、 または商品を購入できないことを知らせる機能が必要です。
//
//これらの機能は、以下のルールに従って動作します。
//
//・おつりは「投入金額 - 購入金額」で計算されます。
//・おつりは自動販売機の内部にある硬貨から、枚数が最も少なくなるように選んだ硬貨の組合せで返却します。
//・ただし、50円硬貨、10円硬貨を組み合わせる、もしくはどちらか一方のみを使うことによって、おつりの内の100円分以上を返却することは許されません。
//・また、おつりを返却することができない場合は購入不可能となり、それを知らせた上で投入された硬貨を全て返却します。
//・自動販売機の内部では、まずおつりとして返却された硬貨がなくなり、その後に投入された硬貨が貯まります。
//
//複数の人が硬貨を投入し商品を買っていくことを想定したテストを行うので、 自動販売機システムと同様の動作をするプログラムを作成してください。
//例えば、以下のような動作が期待されます。



//入力される値
//入力は以下のフォーマットで与えられます。
//
//v_500 v_100 v_50 v_10
//N
//b_1 x_{1, 500} x_{1, 100} x_{1, 50} x_{1, 10}
//b_2 x_{2, 500} x_{2, 100} x_{2, 50} x_{2, 10}
//...
//b_N x_{N, 500} x_{N, 100} x_{N, 50} x_{N, 10}
//
//1行目には4つの整数 v_500, v_100, v_50, v_10 が半角スペース区切りで入力されます。
//それぞれ最初に自動販売機の内部にある500円硬貨、100円硬貨、50円硬貨、10円硬貨の枚数を表します。
//
//2行目には商品を買っていく人の数 N が入力されます。
//
//続く N 行には、N 人分の履歴が時系列順に与えられます。
//i 行目には i 番目の人が購入しようとした商品の金額 b_i と、 投入した各硬貨の枚数 x_{i, 500}, x_{i, 100}, x_{i, 50}, x_{i, 10} が半角スペース区切りで入力されます。
//
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください



//期待する出力
//i 番目の人に返却される各硬貨の枚数を i 行目に半角スペース区切りで出力してください。
//c_500, c_100, c_50, c_10 を返却される各硬貨の枚数として以下のフォーマットで出力してください。
//
//c_500 c_100 c_50 c_10
//
//おつりを返却できない場合は購入不可能となるので、それを知らせる文字列として "impossible" を出力してください。 
//
//最後は改行し、余計な文字、空行を含んではいけません。



//条件
//すべてのテストケースで以下の条件を満たします。
//
//・0 ≦ v_500 ≦ 50, 0 ≦ v_100 ≦ 50, 0 ≦ v_50 ≦ 50, 0 ≦ v_10 ≦ 50
//・1 ≦ N ≦ 100
//・100 ≦ b_i ≦ 200, b_i は10の倍数（1 ≦ i ≦ N）
//・0 ≦ x_{i, 500} ≦ 1, 0 ≦ x_{i, 100} ≦ 4, 0 ≦ x_{i, 50} ≦ 1, 0 ≦ x_{i, 10} ≦ 4
//・x_i,500 と x_i,100 は同時に1以上にはならない
//・b_i ≦ 500 × x_{i, 500} + 100 × x_{i, 100} + 50 × x_{i, 50} + 10 × x_{i, 10} (購入金額は投入金額を超えない)


//入力例1
//1 4 1 20
//3
//130 1 0 0 0
//150 0 2 0 0
//100 1 0 0 0
//出力例1
//0 3 1 2
//0 0 0 5
//impossible
//入力例2
//5 7 8 9
//4
//110 0 2 0 0
//120 1 0 0 0
//130 1 0 0 0
//180 0 2 0 2
//出力例2
//0 0 1 4
//0 3 1 3
//0 3 1 2
//impossible