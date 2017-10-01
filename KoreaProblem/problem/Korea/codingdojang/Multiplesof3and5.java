package problem.Korea.codingdojang;

import java.util.Scanner;

//10미만의 자연수에서 3과 5의 배수를 구하면 3,5,6,9이다. 이들의 총합은 23이다.
//1000미만의 자연수에서 3,5의 배수의 총합을 구하라.

public class Multiplesof3and5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = Integer.parseInt(sc.next()) - 1; // 미만 이므로 1을 뺀다
		int result = 0, i = 0;
		
		// +  3 5 의 배수
		// -   15 의 배수
		
		// 3의 배수 더하기
		for(i=1; i<=input/3; i++) {
			result += 3*i;
		}
		// 5의 배수 더하기
		for(i=1; i<=input/5; i++) {
			result += 5*i;
		}
		// 15의 배수 빼기
		for(i=1; i<input/15; i++) {
			result -= 15*i;
		}
		
		System.out.println(result);

	}

}
