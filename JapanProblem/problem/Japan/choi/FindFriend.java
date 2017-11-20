package problem.Japan.choi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class MakeRelation{
	private int queryNum;
	private int[][] querys;
	private List<String> answer;
	private List<Set<Integer>> relationList;
	
	MakeRelation(int queryNum, int[][] querys) {
		this.queryNum = queryNum;
		this.querys = querys.clone();
		this.answer = new ArrayList<String>();
		this.relationList = new ArrayList<Set<Integer>>();	
		
		processingQuery();
	}
	
	private void processingQuery() {
		for(int i=0; i < this.queryNum; i++) {
			if(this.querys[i][0] == 0) { // set Relation
				setRelation(this.querys[i][1]-1, this.querys[i][2]-1);
			} else { // check Relation
				if(checkRelation(this.querys[i][1]-1, this.querys[i][2]-1)) {
					this.answer.add("yes");
				} else {
					this.answer.add("no");
				}
			}
		}
	}
	private void setRelation(int a, int b) {
		int checkAIn = -1, checkBIn = -1;
		for(int i=0; i < this.relationList.size(); i++) {
			if(this.relationList.get(i).contains(a)) {
				checkAIn = i;
			}
			if(this.relationList.get(i).contains(b)) {
				checkBIn = i;
			}
		}
		if(checkAIn == -1 && checkBIn != -1) {
			this.relationList.get(checkBIn).add(a);
		} else if(checkAIn != -1 && checkBIn == -1) {
			this.relationList.get(checkAIn).add(b);
		} else if(checkAIn != -1 && checkBIn != -1) {
			Iterator<Integer> itr = this.relationList.get(checkBIn).iterator();
			while(itr.hasNext()) {
				this.relationList.get(checkAIn).add(itr.next());
			}
			this.relationList.remove(checkBIn);
		} else if(checkAIn == -1 && checkBIn == -1) {
			Set<Integer> newSet = new HashSet<Integer>();
			newSet.add(a);
			newSet.add(b);
			this.relationList.add(newSet);
		}
	}
	private boolean checkRelation(int a, int b) {
		for(int i=0; i < this.relationList.size(); i++) {
			if(this.relationList.get(i).contains(a) && this.relationList.get(i).contains(b)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public List<String> getAnswer() {
		return answer;
	}
	
}

public class FindFriend {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // user num, not used
		int m = sc.nextInt(); // query num
		int[][] querys = new int[m][3];
		for(int i=0; i < m; i++) {
			querys[i][0] = sc.nextInt(); // 0 = set relation, 1 = check relation
			querys[i][1] = sc.nextInt();
			querys[i][2] = sc.nextInt();
		}
		
		MakeRelation mr = new MakeRelation(m, querys);
		List<String> answer = mr.getAnswer();
		Iterator<String> iter = answer.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		sc.close();
	}

}

//あなたは今、SNS サイト「Paizabook」を開発しています。
//
//Paizabook ではサイト上で見つけたユーザに対して友だちリクエストを送ることができ、相手がそれを受理した場合、二人は互いに友だち関係になります。 
//ユーザは皆、個人ページを持っていますが、各ユーザは他のユーザの個人ページを無条件に見ることはできません。
//自分の友人、自分の友人の友人、自分の友人の友人の友人……、というように友だち関係をたどることで相手に到達することができる場合に限り、その人の個人ページを閲覧することができます。
//
//ユーザa がユーザb の個人ページを見ることができるならば、b もa の個人ページを見ることができます。
//このとき、ユーザのペア(a, b) を閲覧可能ペアといいます。
//
//あなたは随時送られてくる友だち関係クエリを処理しながら、閲覧可能ペア判定クエリを処理するプログラムを作成することになりました。
//
//そこでPaizabook のユーザ数N とM 個のクエリが与えられるので、そのクエリを与えられた順に順次処理するプログラムを作成してください。
//
//実際の入力は1行目にユーザー数N、クエリ数Mが半角スペース区切りで入力されます。
//次の行からクエリの種類t、各クエリを処理するユーザーのペアがa、bとして半角スペース区切りでM行入力されます。
//クエリの種類tは友達関係を表すクエリなら0、友達関係を確認するクエリなら1が入力されます。
//
//入力例は以下のようになります。
//入力例
//5 8
//0 1 2
//0 1 3
//1 3 2
//1 3 4
//0 4 5
//1 3 5
//0 1 4
//1 3 5
//
//この入力を受けて処理を行うと以下の図のような流れになります。 
// 
//実際に出力する値は以下のようになります。 
//出力例
//yes
//no
//no
//yes


//入力される値
//ここで、N はユーザの数を、M はクエリの数を表します。N 人のユーザには1 からN までの番号が振られています。 
//2行目以降は各クエリが書かれています。
//
//各クエリにおいて、t_i = 0 のときは友だち関係クエリであり、ユーザa_i とユーザb_i が友だち関係にあることを表しています。
//t_i = 1 のときは閲覧可能ペアの判定クエリであり、ユーザa_i とユーザb_i が閲覧可能ペアであるかの判定を行ってください。
//
//N M　　　#ユーザー数N, クエリの総数M
//t_1 a_1 b_1　　#クエリ1のクエリの種類t, クエリ対象のユーザー番号a, クエリ対象のユーザー番号b
//t_2 a_2 b_2　　#クエリ2のクエリの種類t, クエリ対象のユーザー番号a, クエリ対象のユーザー番号b
//...
//t_M a_M b_M　#クエリMのクエリの種類t, クエリ対象のユーザー番号a, クエリ対象のユーザー番号b
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//閲覧可能ペアの判定クエリが与えられるごとに、それまでの友だち関係クエリの情報を用いて閲覧可能ペアの判定を行い
//閲覧可能ペアであればyes、そうでなければno を一行に出力してください。
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//2 ≦ N ≦ 500000
//1 ≦ 友だち関係クエリの数(つまりt_i=0の入力) < N
//1 ≦ 閲覧可能ペアの判定クエリの数(つまりt_i=1の入力) ≦ 10000
//1 ≦ M < N + 10000
//1 ≦ a_i, b_i ≦ N
//t_i = 0 のとき、a_i ≠ b_i (1 ≦ i ≦ M)



//入力例1
//5 8
//0 1 2
//0 1 3
//1 3 2
//1 3 4
//0 4 5
//1 3 5
//0 1 4
//1 3 5
//出力例1
//yes
//no
//no
//yes
//入力例2
//4 9
//0 3 1
//1 2 4
//1 1 2
//1 1 3
//1 3 2
//0 1 4
//1 2 3
//0 1 2
//1 2 4
//出力例2
//no
//no
//yes
//no
//no
//yes
//入力例3
//10 16
//1 1 10
//0 9 7
//1 2 7
//0 6 8
//0 5 3
//0 2 9
//1 3 8
//0 8 4
//0 10 5
//1 5 7
//1 3 4
//1 9 10
//0 4 1
//0 2 6
//0 10 6
//1 8 3
//出力例3
//no
//no
//no
//no
//no
//no
//yes