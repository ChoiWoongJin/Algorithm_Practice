package problem.Korea.Algospot;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WeBBaZim {
	
	public static void getPriceNum(String e, String price, int[] eUsedInfo, int m, Set<String> priceInfo) {
		
		// 만들어진 가격(price)이 e와 같지 않고
		// 만들어진 가격(price)의 길이가 기존의 길이 e와 같은지
		// 만들어진 가격(price)이 m의 배수인지
		// 만들어진 가격(price)이 이미 계산되어 가지고 있는 값인지
		// 만들어진 가격(price)이 e보다 작은지 확인
		if( !e.equals(price) && price.length() == e.length() && (Long.parseLong(price)%m == 0) && !priceInfo.contains(price) && checkSize(e, price) ) {
			priceInfo.add(price);
		} else {
			for(int i=0; i < e.length(); i++) {
				if(eUsedInfo[i] == 0) {
					String nextPrice = price + e.substring(i, i+1);
					int[] nextEUsedInfo = new int[eUsedInfo.length];
					System.arraycopy(eUsedInfo, 0, nextEUsedInfo, 0, eUsedInfo.length);
					nextEUsedInfo[i] = 1;
					getPriceNum(e, nextPrice, nextEUsedInfo, m, priceInfo);
				}
			}
		}
	}
	
	// 이전 계란 값이 e보다 작은 지 검사
	public static boolean checkSize(String e, String price) {
		for(int i=0; i < e.length(); i++) {
			if( Integer.parseInt( e.substring(i,i+1) ) > Integer.parseInt( price.substring(i,i+1) ) ) {
				return true;
			} else if( Integer.parseInt( e.substring(i,i+1) ) < Integer.parseInt( price.substring(i,i+1) ) ) {
				return false;
			} 
		}		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCaseNum = sc.nextInt();
		int[] result = new int[testCaseNum];
		
		for(int testCase=0; testCase < testCaseNum; testCase++) {
			String e = sc.next(); // 지금 계란 가격
			String price = "";
			int[] eUsedInfo = new int[e.length()]; // e의 각 자리수 사용 여부 확인
			int m = sc.nextInt(); // 사탕 개수
			Set<String> priceInfo = new HashSet<>(); // e로 만들어 질 수 있는 숫자 확인
			
			getPriceNum(e, price, eUsedInfo, m, priceInfo); // 연산 시작
			
			result[testCase] = priceInfo.size()%1000000007;
		}
		
		for(int testCase=0; testCase < testCaseNum; testCase++) {
			System.out.println(result[testCase]);
		}
		
		sc.close();
	}
}
