package problem.Korea.codingdojang;

import java.util.Scanner;

public class SpiralArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] result = new int[n][m];
		
		for(int i=0; i < n; i++) {
			for(int j=0; j < m; j++) {
				result[i][j] = -1;
			}
		}
		
		int i=0, j=0, item=0, check = 0;
		while(item < n*m) {
			result[i][j] = item;
			
			if(check%4 == 0) {
				if(j+1 < m && result[i][j+1] == -1) j++;
				else {
					check++;
					i++;
				}
			} else if(check%4 == 1) {
				if(i+1 < n && result[i+1][j] == -1) i++;
				else {
					check++;
					j--;
				}
			} else if(check%4 == 2) {
				if(j > 0 && result[i][j-1] == -1) j--;
				else {
					check++;
					i--;
				}
			} else if(check%4 == 3) {
				if(i > 0 && result[i-1][j] == -1) i--;
				else {
					check++;
					j++;
				}
			}
			
			item++;
		}
		
		for(i=0; i < n; i++) {
			for(j=0; j < m; j++) {
				System.out.print(result[i][j]);
				if(j!=m-1) System.out.print(" ");
			}
			System.out.println();
		}		
		
		sc.close();
	}
}
