package problem.Korea.BJ;

import java.util.Arrays;
import java.util.Scanner;

public class ClosestPair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int y_P = sc.nextInt();
		int y_Q = sc.nextInt();
		int[] P = new int[n];
		int[] Q = new int[m];
		int[] distancePQ = new int[n*m];
		int distance;
		int y_PQ = Math.abs(y_P - y_Q);
		int min = 0, minNum = 0;
		
		for(int i=0; i < n; i++) {
			P[i] = sc.nextInt();
		}
		for(int j=0; j < m; j++) {
			Q[j] = sc.nextInt();
		}
		
		int inputCheck = 0;
		for(int i=0; i < n; i++) {
			for(int j=0; j < m; j++) {
				distancePQ[inputCheck++] = Math.abs(P[i] - Q[j]);
			}
		}
		
		Arrays.sort(distancePQ);
		
		// 가장 작은 수 찾기
		min = distancePQ[0];		
		
		// 가장 작은 수의 개수 찾기
		for(int i=0; i < m*n; i++) {
			if(distancePQ[i] == min) {
				minNum++;
			} else {
				break;
			}
		}
		
		min += y_PQ;
		
		System.out.println(min + " " + minNum);
		
	}

}
