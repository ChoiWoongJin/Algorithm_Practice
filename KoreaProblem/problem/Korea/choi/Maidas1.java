package problem.Korea.choi;

//don't place package name.

import java.io.*;
import java.util.*;

//don't change 'Program' class name and without 'public' accessor.
class Maidas1 {
public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   
   int n = Integer.parseInt(sc.next());
   int m = Integer.parseInt(sc.next());
   int k = Integer.parseInt(sc.next());
   int r = 0;
   int[][] worldInfo = new int[n][m];
   int[][] trainInfo = new int[k][3];
   
   for(int i=0; i<n; i++) {
       for(int j=0; j<m; j++) {
           worldInfo[i][j] = 0;
       }
   }
   for(int i=0; i<k; i++) {
       trainInfo[i][0] = Integer.parseInt(sc.next());
       trainInfo[i][1] = Integer.parseInt(sc.next());
       trainInfo[i][2] = Integer.parseInt(sc.next());
       r = trainInfo[i][0]-1;
       for(int j=trainInfo[i][1]-1; j<trainInfo[i][2]; j++) {
           worldInfo[r][j] = 1;
       }
   }
   
   int count = 0;
   
   for(int i=0; i<n; i++) {
       for(int j=0; j<m; j++) {
      	 if(worldInfo[i][j] == 0) {
      		 count++;
      	 }
       }
   }
   
   System.out.println(count);
   
}
}