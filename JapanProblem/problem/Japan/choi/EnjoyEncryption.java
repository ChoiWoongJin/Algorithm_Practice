package problem.Japan.choi;

import java.util.*;

public class EnjoyEncryption {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int encryptionNum = Integer.parseInt(sc.next());
		char[] keyValue = new char[26];
		keyValue = sc.next().toCharArray();
		String getValue = sc.nextLine();
		getValue = sc.nextLine();
		char[] encryptValue = new char[getValue.length()];
		encryptValue = getValue.toCharArray();

		for (int i = 0; i < encryptionNum; i++) {
			for (int j = 0; j < encryptValue.length; j++) {
				encryptValue[j] = encrypt(keyValue, encryptValue[j]);
			}
		}

		System.out.println(encryptValue);
	}

	public static char encrypt(char[] keyValue, char encryptValue) {
		for (int i = 0; i < 26; i++) {
			if (keyValue[i] == encryptValue) {
				return (char) (i + 97);
			}
		}
		return (char) 32;
	}
}

//あなたは転職のためのスキルチェックを受けようと受験ボタンを押しました。
//ところが、表示された問題文は呪文のようでまるで読めません。
//問題は暗号化されて公開されるようになっていたのです。
//まず最初に暗号を解かなければスキルチェックを行う事すら出来ないのです。
//
//
//幸いにも暗号の文字列と共に、半角英小文字 a, b, c, ... x, y, z に対してどのように変わる置換を行ったか、問題文に何回置換を行ったかが与えられています。
//スキルチェックの問題に答えられるように、暗号を解読し復号するプログラムを書いてください。
//
//
//入力例1の例では、a, b, c, ... , x, y, z に対して, q, w, e, ... , b, n, m に 1 回置換されているため、逆の置換 (q, w, e, ... , b, n, m に対して a, b, c, ... , x, y, z への変換) を 1 回行って復号します。
//最初の単語 "hqomq" に逆の置換をすると "paiza" という単語に復号されます。
//
//
//図1 
//同じように全ての単語に逆の置換を1回適用することで "paiza online hackathon" という復号結果が得られます。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//n T
//S
//・1行目に置換回数 n と 小文字アルファベットの置換を表す文字列 T がスペース区切りで与えられます。 置換は英字 a, b, ..., z の i 文字目 (1 ≦ i ≦ 26) を T の i 文字目に置き換える形で行います。
//・2行目に置換された文字列 S が一行で与えられます。
//・入力は合計 2 行であり、 最終行の末尾に改行が1つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//入力例1
//1 qwertyuiopasdfghjklzxcvbnm
//hqomq gfsoft iqeaqzigf
//出力例1
//paiza online hackathon
//入力例2
//100 poiuytrewqlkjhgfdsamnbvcxz
//snn xufu ngebmv qwtg
//出力例2
//cpp java python ruby