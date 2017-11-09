package Basic.Recursion;

import java.util.Scanner;

/*
 * 미로 찾기 ( Decision Problem )
 * 현재 위치에서 출구까지 가는 경로가 있으려면 아래의 조건을 만족해야 함
 * 		1) 현재 위치가 출구이다.
 * 		2) 1)이 아니면 이웃한 셀들 중 하나에서 현재 위치를 지나지 않고 출구까지 가는 경로가 있다
 * 결과 : 출구까지 경로를 찾을 수 있는지 여부를 boolean 타입으로 반환
 */

/* 입출력 예시
5 5
1 1 1 0 0
0 0 1 0 0
0 1 1 1 0
0 1 0 1 1
1 1 0 1 3

출구 찾음

5 5
1 1 1 0 0
0 0 1 0 0
0 1 1 0 0
0 1 0 1 1
1 1 0 1 3

출구 못찾음
 */

public class DecisionProblem {
	public static boolean findPath(int[][] map, int x, int y) {
		if(map[x][y] == 0 || map[x][y] == 2) { // 현재 위치가 벽( 0 )이거나 이미 방문한 경로( 2 )일 경우 false 반환
			return false;
		}
		if(map[x][y] == 3) { // 현재 위치가 출구( 3 )인 경우 true 반환
			return true;
		} else {
			map[x][y] = 2; // 현재 위치를 이미 방문한 경로로 지정
			if(x > 0 ) { // map의 범위를 벗어나지 않을 때
				if(findPath(map, x-1, y)) {
					return true;
				}
			}
			if(y > 0 ) { // map의 범위를 벗어나지 않을 때
				if(findPath(map, x, y-1)) {
					return true;
				}
			}
			if(x+1 < map.length ) { // map의 범위를 벗어나지 않을 때
				if(findPath(map, x+1, y)) {
					return true;
				}
			}
			if(y+1 < map[0].length ) { // map의 범위를 벗어나지 않을 때
				if(findPath(map, x, y+1)) {
					return true;
				}
			}
			
		}
		
		
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(); // 맵의 높이 H
		int W = sc.nextInt(); // 맵의 넓이 W
		int[][] map = new int[H][W];	
		// 입력값 => 0 : 벽, 1 : 길, 2 : 이미 방문한 경로, 3 : 출구
		// (0,0)에서 시작하도록 한다
		for(int i=0; i < H; i++) {
			for(int j=0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		if(findPath(map, 0, 0) ) {
			System.out.println("출구를 찾았습니다.");
		} else {
			System.out.println("출구를 찾지 못했습니다.");
		}

	}
}

