package problem.Japan.choi;

import java.util.Scanner;

public class ConversionToMultipleForm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] voca = new String[N];
		for(int i=0; i < N; i++) {
			voca[i] = sc.next();
			if( voca[i].charAt(voca[i].length()-1) == 's' ||
				voca[i].charAt(voca[i].length()-1) == 'o' ||
				voca[i].charAt(voca[i].length()-1) == 'x') {
				voca[i] = voca[i] + "es";
			}else if( voca[i].substring(voca[i].length()-2, voca[i].length()).equals("sh") ||
					   voca[i].substring(voca[i].length()-2, voca[i].length()).equals("ch") ) {
				voca[i] = voca[i] + "es";
			}else if( voca[i].charAt(voca[i].length()-1) == 'f') {
				voca[i] = voca[i].substring(0, voca[i].length()-1) + "ves";
			}else if( voca[i].substring(voca[i].length()-2, voca[i].length()).equals("fe") ) {
				voca[i] = voca[i].substring(0, voca[i].length()-2) + "ves";
			}else if( voca[i].charAt(voca[i].length()-1) == 'y' &&
					   voca[i].charAt(voca[i].length()-2) != 'a' &&
					   voca[i].charAt(voca[i].length()-2) != 'i' &&
					   voca[i].charAt(voca[i].length()-2) != 'u' &&
					   voca[i].charAt(voca[i].length()-2) != 'e' &&
					   voca[i].charAt(voca[i].length()-2) != 'o'  ) { // end == y, end-1 != a, i, u, e, o
				voca[i] = voca[i].substring(0, voca[i].length()-1) + "ies";
			} else {
				voca[i] = voca[i] + "s";
			}
		}
		
		for(int i=0; i < N; i++) {
			System.out.println(voca[i]);
		}

	}
}


//あなたは英語の文法チェック・修正システムの作成を担当しています。 このシステムを実現するには、英単語を複数形に変換する機能が必要です。
//
//単語の複数形への変換は、次のルールに従い行われます。
//
//・末尾が s, sh, ch, o, x のいずれかである英単語の末尾に es を付ける
//・末尾が f, fe のいずれかである英単語の末尾の f, fe を除き、末尾に ves を付ける
//・末尾の1文字が y で、末尾から2文字目が a, i, u, e, o のいずれでもない英単語の末尾の y を除き、末尾に ies を付ける
//・上のいずれの条件にも当てはまらない英単語の末尾には s を付ける
//
//入力された英単語を複数形に変換するプログラムを作成してください。
//
//※必ずしも実在の英単語が入力されるわけではありません。単純に文字列を上記のルールに沿って変換するプログラムを作成してください。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//N #入力される単語の数
//a_1 #1個目の単語
//a_2 #2個目の単語
//...
//a_N #N個目の単語
//
//必ずしも実在の英単語が入力されるわけではありません。
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください



//期待する出力
//英単語 a_i を複数形に変換した答えを i 行目に出力してください。 
//
//最後は改行し、余計な文字、空行を含んではいけません。
//

//条件
//すべてのテストケースで以下の条件を満たします。
//
//・1 ≦ N ≦ 10
//・a_i は a～z のアルファベット小文字の並べた文字列
//・2 ≦ (a_i の長さ) ≦ 20
//・架空の英単語が与えられることがあります
//
//N は変換しなければならない英単語の数を表します。
//a_i は複数形に変換しなければならない英単語を表します。


//入力例1
//3
//dog
//cat
//pig
//出力例1
//dogs
//cats
//pigs
//入力例2
//7
//box
//photo
//axis
//dish
//church
//leaf
//knife
//出力例2
//boxes
//photoes
//axises
//dishes
//churches
//leaves
//knives
//入力例3
//2
//study
//play
//出力例3
//studies
//plays