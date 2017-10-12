package problem.Japan.choi;

import java.util.*;

//あなたはとあるゲーム大会の事務係になりました。あなたの仕事は各試合の結果報告をまとめ、勝敗の結果がひと目で分かる表をつくることです。これを自動化するプログラムをつくりましょう。
//
//この大会は総当りのリーグ戦なのですべての参加者どうしが試合を行います。なお、このゲームに引き分けは存在しません。
//
//例)
//
//参加者数: 3 (参加者 1 ~ 3)
//結果報告:
//参加者 1 と 3 が試合を行い、参加者 1 の勝利
//参加者 1 と 2 が試合を行い、参加者 2 の勝利
//参加者 2 と 3 が試合を行い、参加者 2 の勝利
//
//これをまとめると以下のような表にすることができます。ここで、i 行 j 列目 (i ≠ j) は参加者 i から見た参加者 j との試合の結果を表し、勝利なら "W"、敗北なら "L" となります。i 行 i 列目は「参加者 i と参加者 i の試合」という存在しない試合に対応するので半角ハイフン ("-") で埋めます。
//
//これは入力例 1 に対応しています。
//
//    1  2  3  
// 1 -  L  W
// 2 W -  W
// 3 L  L   -
//
//参加者の数と各試合の結果の情報が与えられるので、上のような表の内部 (参加者番号を除いた部分) を出力してください。


//Input1
//3
//1 3
//2 1
//2 3
//Output1
//- L W
//W - W
//L L -

//Input2
//5
//5 2
//1 4
//2 3
//3 4
//1 5
//2 4
//1 2
//5 3
//1 3
//5 4
//Output2
//- W W W W
//L - W W L
//L L - W L
//L L L - L
//L W W W -

public class LeagueSeetMaking {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        int team = Integer.parseInt(sc.next());
        int teamCase = (team*(team-1)) / 2;
        int winner = 0, loser = 0;
        String[][] seet = new String[team][team];
        
        for(int i=0; i < team; i++) {
            seet[i][i] = "-";
        }
        
        for(int i=0; i < teamCase; i++) {
            winner = Integer.parseInt(sc.next()) - 1;
            loser = Integer.parseInt(sc.next()) - 1;
            
            seet[winner][loser] = "W";
            seet[loser][winner] = "L";
        }
        
        for(int i=0; i < team; i++) {
            for(int j=0; j < team; j++) {
                System.out.print(seet[i][j]);
                if(j != team-1) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
        }
    }
}