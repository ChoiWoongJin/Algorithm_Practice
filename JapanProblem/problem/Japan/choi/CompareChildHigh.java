package problem.Japan.choi;

import java.util.*;


/**
 * 아이들끼리 서로의 키를 재고있다. 한명의 아이 빼고 나머지 아이들의 키는 알고 있을 때
 * 한명의 아이에 대한 키의 정보를 알아내자!
 * Input : 첫번째 줄은 아이들의 수, 두번째 줄부터 비교할 키의 정보와 키의 높이
 * 			ge : 다음에 오는 숫자의 키보다는 크거나 같다(greater than or equal to)
 * 			le : 다음에 오는 숫자의 키보다는 작거나 같다(less than or equal to) 
//15
//ge 121.7
//ge 125.0
//le 162.4
//le 153.5
//ge 119.6
//le 182.4
//le 149.4
//le 192.7
//le 168.8
//ge 110.0
//le 180.9
//ge 119.9
//le 152.7
//le 180.8
//le 152.4 
 * Output : 키의 범위는 125.0보다 크고 149.4보다 작다는 의미 
//125.0 149.4
 * @author asus
 *
 */

public class CompareChildHigh {
   public static void main(String[] args) {
       // 自分の得意な言語で
       // Let's チャレンジ！！
       Scanner sc = new Scanner(System.in);
       int numChild = Integer.parseInt(sc.nextLine());
       String lege = "";
       double ge1 = 0, ge2 = 0, le1 = 0, le2 = 0;
       
       for(int i=0; i<numChild ; i++) {
           lege = sc.next();
           if(lege.equals("le")) { // le 인 경우
               le2 = Double.parseDouble(sc.nextLine());
               if(le1 == 0) {
                   le1 = le2;
               } else if(le1 > le2) {
                   le1 = le2;
               }
           } else if(lege.equals("ge")) { // ge 인 경우
               ge2 = Double.parseDouble(sc.nextLine());
               if(ge1 == 0) {
                   ge1 = ge2;
               } else if(ge1 < ge2) {
                   ge1 = ge2;
               }
           }
       }
       
       System.out.println(ge1 + " " + le1);          
   }
}