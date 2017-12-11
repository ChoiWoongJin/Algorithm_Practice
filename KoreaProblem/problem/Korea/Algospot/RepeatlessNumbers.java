package problem.Korea.Algospot;

import java.util.Scanner;

public class RepeatlessNumbers {
	
	public static void checkRepeatlessNumber(int checkNumber, int[] repeatlessNumber) {
		int numCount = 0;
		int num = 0;	
		
		while(numCount < checkNumber) {
			num++;			
			int[] repeatCounter = new int[10];
			int tempNum = num;
			while(tempNum > 0) {
				repeatCounter[tempNum%10]++;
				tempNum = tempNum/10;
			}
			
			if(checkRepeat(repeatCounter)) {
				repeatlessNumber[numCount] = num;
				numCount++;
			}
		}
	}
	public static boolean checkRepeat(int[] repeatCounter) {
		for(int i=0; i < repeatCounter.length; i++) {
			if(repeatCounter[i] > 1) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int checkNumber = 0;
		int[] repeatlessNumber = new int[1000000];
		checkRepeatlessNumber(1000000, repeatlessNumber);
		
		while((checkNumber = sc.nextInt()) != 0) {
			System.out.println(repeatlessNumber[checkNumber-1]);
		}
		
		
		
		sc.close();
	}
}
/*
예제 입력

25
10000
0

예제 출력

27
26057
*/