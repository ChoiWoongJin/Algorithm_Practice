package problem.Western.Codility;

import java.util.*;

// 집합에서 짝이 없는 개체 뽑아내기

public class OddOccurrencesInArray {
	
	 public int solution(int[] A) {
	        // write your code in Java SE 8
	        Set<Integer> hs = new HashSet<Integer>();
	        for(int i=0; i < A.length; i++) {
	            if(hs.contains(A[i])) {
	                hs.remove(A[i]);
	            } else {
	                hs.add(A[i]);
	            }
	        }        
	        Iterator<Integer> it = hs.iterator();        
	        return it.next();
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
