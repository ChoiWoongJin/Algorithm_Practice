package problem.Japan.choi;

import java.util.*;

public class DistributeCookie {
	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int machineNum = Integer.parseInt(sc.next());
		int cookieNum = Integer.parseInt(sc.next());
		int[] machineDiv = new int[machineNum];
		int checkMin = cookieNum, checkNum = 0, checkDiv = 0;
		int leftCookie = 0;

		for (int i = 0; i < machineNum; i++) {
			machineDiv[i] = Integer.parseInt(sc.next());
		}

		for (int i = 0; i < machineNum; i++) {
			leftCookie = cookieNum % machineDiv[i];
			if (checkMin > leftCookie) {
				checkMin = leftCookie;
				checkNum = i + 1;
				checkDiv = machineDiv[i];
			} else if (checkMin == leftCookie && checkDiv < machineDiv[i]) {
				checkNum = i + 1;
				checkDiv = machineDiv[i];
			}
		}

		System.out.println(checkNum);

	}
}


//お菓子製造工場で働いている Bob は、小分け販売のためにお菓子を分配する作業を行っています。
//
//
//作業には、 M 種類の機械が用いられます。
//
//i 種類目の機械は、積み込まれたお菓子を m_i 個の容器に均等に分配し、余りを排出します。
//
//
//Bob は、作業効率を上げるために、排出される余りが最も少なくなるようなお菓子の分配方法を知りたいと思っています。 ただし、このような分配方法が複数あった場合には、可能な限り小分け販売できるように、分配される容器の総数が最も多くなる方法を優先したいと考えています。
//
//N 個のお菓子を分配するとき、 Bob の考えに沿う機械はどれでしょうか？
//
//
//入力例 1 の図解を以下に示します。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//M N
//m_1
//m_2
//...
//m_M
//・1 行目には、機械の数を表す整数 M と、詰め込むお菓子の数を表す整数 N が、空白区切りで与えられます。
//・続く M 行のうち i (1 ≦ i ≦ M) 行目には、 i 番目の機械によって、お菓子が分配される容器の数を表す整数 m_i が与えられます。
//・入力は合計で N + 1 行となり、入力値最終行の末尾に改行が１つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//排出される余りが最も少ない機械の番号を 1 行に出力してください。ただしそのような機械が複数ある場合は、その中で分配される容器の総数が多い機械の番号を出力してください。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースにおいて、以下の条件をみたします。
//
//・2 ≦ M ≦ 100
//・M ≦ N ≦ 1,000
//・1 ≦ m_i ≦ N (1 ≦ i ≦ M)
//・各 i, j (1 ≦ i, j ≦ M) について、i ≠ j ならば m_i ≠ m_j


//入力例1
//3 7
//2
//3
//4
//出力例1
//2
//入力例2
//5 15
//12
//13
//7
//5
//8
//出力例2
//4