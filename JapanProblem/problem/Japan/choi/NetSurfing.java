package problem.Japan.choi;

import java.util.Scanner;
import java.util.Stack;

public class NetSurfing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] log = new String[N];
		sc.nextLine();
		Stack<String> st = new Stack<String>();
		for(int i=0; i < N; i++) {
			log[i] = "";
		}
		
		for(int i=0; i < N; i++) {
			String[] check = sc.nextLine().split(" ");
			if(i==0) {
				for(int j=2; j < check.length; j++) {
					if(j==2) {
						log[i] += check[j];
					} else {
						log[i] += " " + check[j];
					}
				}
			}else if(check[0].equals("go")) { // go to
				for(int j=2; j < check.length; j++) {
					if(j==2) {
						log[i] += check[j];
					} else {
						log[i] += " " + check[j];
					}
				}
				st.push(log[i-1]);
			} else { // use the back button
				log[i] = st.pop();
			}
		}
		
		for(int i=0; i < N; i++) {
			System.out.println(log[i]);
		}		
	}

}

//あなたは今、暇つぶしのため、以下のルールに従ってネットサーフィンをしています。
//
//・最初は必ず "blank page" を開く。
//・現在のページが "blank page" である場合、"blank page" 以外の指定されたページを開く。
//・現在のページが "blank page" でない場合、ブラウザの戻るボタンを使うことでひとつ前ヘ戻るか、リンクをたどり "blank page" 以外の指定されたページを開く。
//
//入力例1を表した図 
// 
//どのページを開くか、または戻るボタンを使うかの情報がクエリとして与えられるので、開かれたページを時系列順に表示するプログラムを作成してください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//n
//q_1
//q_2
//...
//q_n
//
//n はクエリの数を表す整数
//
//q_i (1 ≦ i ≦ n) は
//"use the back button" 
//直前に開いていたページを開くクエリ
//"go to [page_name]"
//[page_name] という名前のページを開くクエリを表します。
//[page_name] は英小文字と半角スペースからなる文字列です。また、 q_1 は必ず "go to blank page" です。
//
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//開かれたページを時系列順に改行区切りで出力してください。
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//・1 ≦ n ≦ 100
//・クエリ q_i の文字列は 100 文字以下
//・q_1 = "go to blank page"
//・[page_name] の先頭と末尾は必ずアルファベットである


//入力例1
//5
//go to blank page
//go to bja n
//go to va
//use the back button
//use the back button
//出力例1
//blank page
//bja n
//va
//bja n
//blank page
//入力例2
//7
//go to blank page
//go to nkah
//use the back button
//go to gi
//go to in
//go to nkah
//use the back button
//出力例2
//blank page
//nkah
//blank page
//gi
//in
//nkah
//in
//入力例3
//5
//go to blank page
//go to paiza
//go to paiza
//use the back button
//use the back button
//出力例3
//blank page
//paiza
//paiza
//paiza
//blank page