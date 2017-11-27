package problem.Korea.Algospot;

import java.util.Arrays;
import java.util.Scanner;

public class DecideParticipationOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCaseNum = sc.nextInt();
		int playerNum = 0;
		int[] teamEnemy;
		int[] teamKorea;
		int result = 0, curEnemy = 0, curKorea = 0;
		for(int testCase = 0; testCase < testCaseNum; testCase++) {
			// Input Sequence
			result = 0;
			curEnemy = 0;
			curKorea = 0;
			playerNum = sc.nextInt();
			teamEnemy = new int[playerNum];
			teamKorea = new int[playerNum];
			for(int i=0; i < playerNum; i++) {
				teamEnemy[i] = sc.nextInt();
			}
			for(int i=0; i < playerNum; i++) {
				teamKorea[i] = sc.nextInt();
			}
			Arrays.sort(teamEnemy);
			Arrays.sort(teamKorea);
			// /Input Sequence


			while(curKorea < playerNum) {
				if(teamEnemy[curEnemy] > teamKorea[curKorea]) {
					curKorea++;
				} else {
					curEnemy++;
					curKorea++;
					result++;
				}
			}
			// 1900 2200 2500 2700 2800 3000
			// 1800 2000 2600 2750 2800 2995
			
			System.out.println(result);
		}
		
		sc.close();
	}

}
