package problem.Japan.choi;

import java.util.Scanner;

public class VoteSpeech {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(); // Speecher number
		int Voter = sc.nextInt(); // Voter number
		int K = sc.nextInt(); // speech number
		int[] Speecher = new int[M];
		int speeching;
		
		for(int i=0; i < M; i++) {
			Speecher[i] = 0;
		}
		
		for(int i=0; i < K; i++) {
			speeching = sc.nextInt() - 1;
			
			if(Voter > 0) {
				Speecher[speeching]++;
				Voter--;
			}
			for(int j=0; j < M; j++) {
				if(j != speeching) {
					if(Speecher[j] > 0) {
						Speecher[speeching]++;
						Speecher[j]--;
					}
				}
			}
		}
		
		int max = 0;
		for(int i=0; i < M; i++) {
			if(max < Speecher[i]) {
				max = Speecher[i];
			}
		}
		
		for(int i=0; i < M; i++) {
			if(max == Speecher[i]) {
				System.out.println(i+1);
			}
		}
	}
}


//Paiza 国の選挙シーズンがやってきました。 今回の選挙では M 人の立候補者と N 人の有権者がいます。
//Paiza 国の人々は政治に無関心なので、最初、すべての有権者はどの立候補者も支持していません。
//
//Paiza 国には大きな広場が一つあります。 選挙活動の期間中、立候補者たちはこの広場で一人ずつ演説をします。
//（同じ人が複数回演説することもあれば、1 回も演説しないこともあります。）
//
//演説が終わるたびに、「他のそれぞれの立候補者の支持者から 1 人ずつ」および「誰も支持していない有権者から 1 人」が演説をした人を支持するようになります。
//
//次の図は支持者の人数の変化の一例を表しています。 
//この例では 3 人の立候補者 (A、B、C とする) と 3 人の有権者がおり、A → A → B → C の順に計 4 回の演説が行われます。
//
// 
//すべての演説が終わった後、最も支持者が多い立候補者を求めてください。



//入力される値
//入力は以下のフォーマットで与えられます。
//
//M N K
//a_1
//a_2
//...
//a_K
//
//1 行目には 3 つの整数 M, N, K が入力されます。 M は立候補者の人数を、N は有権者の人数を、K は演説が行われる回数を表します。
//続く K 行には、誰がどの順番で演説したかを表す整数 a_1, ..., a_K が入力されます。 これは、i 番目の演説が a_i 番目の立候補者によってされたことを表しています。 
//
//ここで、M 人の立候補者は 1, 2, ..., M と番号づけられているものとします。
//
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//すべての演説が終わった後、最も支持者が多い立候補者の番号を出力してください。
//そのような立候補者が複数いる場合は、それらを番号の小さい順に改行区切りですべて出力してください。
//
//最後は改行し、余計な文字、空行を含んではいけません。



//条件
//すべてのテストケースで以下の条件を満たします。
//
//・1 ≦ M, N, K ≦ 100
//・1 ≦ a_i ≦ M


//入力例1
//3 3 4
//1
//1
//2
//3
//出力例1
//3
//入力例2
//2 100 4
//2
//2
//2
//1
//出力例2
//1
//2