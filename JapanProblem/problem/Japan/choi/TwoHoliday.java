package problem.Japan.choi;

import java.util.Scanner;

public class TwoHoliday {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.next());
		int[] day = new int[N];
		int result = 0;
		
		for(int i=0; i < N; i++) {
			day[i] = Integer.parseInt(sc.next());
		}		
		
		result = checkBest(day);
		
		System.out.println(result);
	}
	public static int checkBest(int[] day) {
		int result = 0;
		int checkHoliday = 0;
		int checkWeekday = 0;
		int daySum = 0;
		
		for(int i=0; i < day.length; i++) {
			for(int j=i; j < day.length; j++) {
				if(day[j]==0) {
					checkHoliday++;
				} else if(day[j] == 1) {
					checkWeekday++;
				}
				daySum++;
				
				if(checkWeekday>5 && checkHoliday < 2) {
					daySum--;
					break;
				} else if(day[j]==1 && checkHoliday >= 2 && checkWeekday == 5) {
					checkHoliday = 0;
					checkWeekday = 0;
				}				
			}
			
			if(result < daySum && daySum >= 7) {
				result = daySum;
			}
			checkHoliday = 0;
			checkWeekday = 0;
			daySum = 0;
		}		
		
		return result;
	}

}
