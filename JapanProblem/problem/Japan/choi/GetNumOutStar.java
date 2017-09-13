package problem.Japan.choi;

import java.util.Scanner;

/**
 * 입력받은 숫자 만큼 별을 출력하는 코드
 */

public class GetNumOutStar {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        int num = Integer.parseInt(sc.nextLine());
        
        for(int i=0; i<num; i++) {
            sb.append("*");
        }        
        
        System.out.println(sb.toString());
    }
}