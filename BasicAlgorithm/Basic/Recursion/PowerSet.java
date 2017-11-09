package Basic.Recursion;

import java.util.Scanner;

/*
 * 멱집합 ( PowerSet )
 * N크기를 가진 주어진 집합의 모든 부분집합을 가지는 집합이 멱집합
 * {a, b, c, d, e, f}의 모든 부분집합을 나열하려면
 * 		1) a를 제외한 {b, c, d, e, f}의 모든 부분집합을 나열한다
 * 		2) {b, c, d, e, f}의 모든 부분집합에 {a}를 추가한 집합들을 나열한다
 * 결과 : 모든 부분 집합을 나열
 */

/* 입출력 예시

 */

public class PowerSet {
	
	public static void powerSet(char[] data,boolean[] include,  int N, int k) {
		if( k == N ) { // 현재 위치가 리프노드일 경우
			int check = 0; // 공집합 표현을 위해 넣음
			for(int i=0; i < N; i++) {
				if(include[i]) {
					if(check == 0) check++; // 공집합 표현을 위한 check
					System.out.print( data[i] + " ");					
				}
			}
			if(check == 0) { // 데이터가 하나도 없었을 경우
				System.out.print( "Φ"); // 공집합
			}
			System.out.print("\n");
			return;
		} else {
			// include[k]가 false이면 k+1번째를 왼쪽으로 가고 true이면 k+1번째를 오른쪽으로 내려간다고 가정
			include[k] = false; // k번째 데이터를 포함하지 않는다는 표시
			powerSet( data, include, N, k+1 ); // 왼쪽으로 내려간다
			include[k] = true; // k번째 데이터를 포함한다는 표시
			powerSet( data, include, N, k+1 ); // 오른쪽으로도 내려간다
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] data = new char[N];
		int k = 0; // 트리 상에서 현재 위치
		boolean[] include = new boolean[N]; // 트리 상에서 현재 위치 정보를 저장
		for(int i=0; i < N; i++) {
			data[i] = sc.next().charAt(0);
		}
		powerSet(data, include, N, k);
	}
}
