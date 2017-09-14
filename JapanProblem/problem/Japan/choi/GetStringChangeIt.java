package problem.Japan.choi;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 문자열을 입력 받고 일부 문자는 숫자로 변환 한다
 * A : 4 / E : 3 / G : 6 / I : 1 / O : 0 / S : 5 / Z : 2
 *
 */

public class GetStringChangeIt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] key = { "A", "E", "G", "I", "O", "S", "Z" }; // 변경할 문자
		String[] value = { "4", "3", "6", "1", "0", "5", "2" }; // 문자가 변경될 숫자
		 Scanner sc = new Scanner(System.in);
	     String line = sc.nextLine();
	     String result = ""; // 변경된 문자열을 담을 인스턴스
	     HashMap hm = new HashMap();
	     
	     for(int i=0; i<key.length; i++) {
	    	 hm.put(key[i], value[i]); // 해쉬맵을 사용하여 변경되는 문자와 숫자를 저장
	     }
	     
	     for(int i=0; i<line.length(); i++) { // 입력된 문자열을 하나씩 차례대로 확인
	    	 if(hm.containsKey(line.substring(i, i+1))) { // 문자가 해쉬맵(hm)에 들어있는 키값중 하나인지 확인
	    		 result += hm.get(line.substring(i, i+1)); // 키값과 일치할 경우 키값의 Value를 저장
	    	 }
	    	 else {
	    		 result += line.substring(i, i+1); // 문자가 해쉬맵에 없을 경우 변경하지 않음
	    	 }
	     }  
	     System.out.println(result);
	     sc.close();

	}

}
