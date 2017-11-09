package Basic.Recursion;

import java.util.Scanner;

/*
 * N Queens Problem
 * 가로, 세로 크기가 N인 2차원 체스판이 주어질 때
 * N개의 말을 놓았을 때 어떠한 말도 동일한 행, 열, 대각선 방향에 오지 않도록 놓는 방법
 * Backtracking 문제 / 상태공간트리 문제
 * 결과 : N개의 말이 놓아지는지 여부를 boolean 타입으로 반환
 */

/* 입출력 예시
5

가능

2

불가능

3

불가능


4

가능
 */

public class NQueensProblem {
	
	public static boolean queens(int[] map, int level, int N) {
		if(!promising(map, level)) { // 말을 놓을 수 있는지 검사
			return false;
		} else if( level == N) { // 마지막 위치까지 도착했을 경우
			for(int i=1; i <= N; i++) {
				System.out.println("( " + i + ", " + map[i] + " )");
			}
			return true;
		}
		for(int i=1; i <= N; i++) {
			map[ level + 1] = i;
			if( queens(map, level+1, N)) { // level + 1번째 말을 각각 열에 넣어서 확인
				return true;
			}
		}
		return false;
	}
	
	// level번째 말이 현재 위치에 올 수 있는지 여부를 확인
	// 이미 놓여있는 말과 같은 열인지, 같은 대각선인지를 검사
	public static boolean promising(int[] map, int level) {
		for(int i=1; i < level; i++) { // level 보다 높은 수에는 아직 말이 없으므로 level보다 낮은 수만 검사
			// ma[i]의 값은 i번째 level에서 말의 가로 위치를 의미
			if(map[i] == map[level]) { // 같은 열에 이미 말이 놓여있을 경우 안됨
				return false;
			} else if( (level-i) == Math.abs(map[level] - map[i]) ) { // 같은 대각선에 이미 말이 놓여있을 경우 안됨
				// (X1, Y1) (X2, Y2)라는 두 점이 있다고 가정했을 때
				// 이때 level-i는 X1 - X2, map[level]-map[i]는 Y1 - Y2로 볼 수 있다
				// X의 차와 Y의 차가 같을 경우 두 점은 대각선상에 있다 
				return false;
			}
		}
		return true; // 위의 조건들을 만족할 때 현재 위치에 말을 놓을 수 있다
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] map = new int[N+1]; // map 배열에 말들을 1, 2, 3 ... N까지 편리하게 배치하기 위해 N+1크기로 생성. map[0]은 사용하지 않는다
		
		if(queens(map, 0, N)) {
			System.out.println(N + "개의 퀸을 놓을 수 있습니다");
		} else {
			System.out.println("이 체스판에는 " + N + "개의 퀸을 놓을 수 없습니다");
		}
		
		

	}

}
