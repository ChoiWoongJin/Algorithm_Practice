package problem.Western.Codility;

import java.util.Arrays;

public class BinaryGap {
	public static int solution(int N) {
        // write your code in Java SE 8
        int checkN = 0;
        int temp = N;
        while(temp > 0) {
            checkN++;
            temp /= 2;
        }
        int[] binaryN = new int[checkN];
        
        temp = N;
        int check = 0;
        int max = 0;
        int temp2 = 0;
        for(int i=0; i < checkN; i++) {
            binaryN[i] = temp%2;
            temp /= 2;
            
            if(check == 0 && binaryN[i] == 1) {
        		check = 1;
        	} else if(check == 1 && binaryN[i] == 1 && i < checkN-1 && binaryN[i+1] == 0) {
        		if(max < temp2) max = temp2;
        		temp2 = 0;
        	} else if(check == 1 && binaryN[i] == 1) {
        		check = 0;
        		if(max < temp2) max = temp2;
        		temp2 = 0;
        	} else if(check == 1 && binaryN[i] == 0) {
        		temp2++;
        	}
        } // make binary && search

        return max;
    }

	public static void main(String[] args) {
	}

}

// In Binary, get 0's Num, when 0 is between 1
// ex) 100010000     => max = 3
