package Basic.Recursion;

import java.util.Scanner;

/*
 * Counting Cells in a Blob
 * 서로 연결되어 있는 Pixel의 크기를 구하는 방법
 * 현재 픽셀이 속한 blob의 크기를 카운트 하기 위해서는 아래의 조건을 만족해야 함
 * 		1) 현재 픽셀이 image color가 아니라면 0을 반환한다
 * 		2) 현재 픽셀이 image color라면 먼저 현재 픽셀을 카운트한다 ( count = 1 )
 * 		3) 현재 픽셀이 중복 카운트되는 것을 방지하기 위해 다른 색으로 칠한다
 * 		4) 현재 픽셀에 이웃한 모든 픽셀들에 대해서 1) ~ 3)을 진행한다
 * 		5) 카운터를 반환한다
 * 결과 : 현재 픽셀과 연결되어 있는 픽셀의 크기를 int 타입으로 반환
 */

/* 입출력 예시
5 5
1 1 1 0 0
0 0 1 0 0
0 1 1 1 0
0 1 0 1 1
1 1 0 1 3

(0,0) 확인
결과 : 1 = 13

5 5
1 1 1 0 0
0 0 1 0 0
0 1 1 0 0
0 1 0 1 1
1 1 0 1 3

(0,0) 확인
결과 : 1 = 12

5 5
1 1 1 0 0
0 0 1 0 0
0 1 1 0 0
0 1 0 0 1
1 1 0 1 3

(0,0) 확인
결과 : 1 = 9
 */

public class CountingCellsInABlob {
	public static int countCells(int[][] map, int x, int y, int findColor) {
		int result;
		if(x < 0 || x >= map.length || y < 0 || y >= map[0].length) { // map의 범위를 벗어날 때
			return 0;
		} else if(map[x][y] != findColor) { // 찾는 색이 아닐 때
			return 0;
		} else {
			map[x][y] = -1; // 이미 확인된 색으로 변경
			return 1 + countCells(map, x+1, y+1, findColor) + countCells(map, x+1, y, findColor)
						+ countCells(map, x-1, y+1, findColor) + countCells(map, x-1, y, findColor)
						+ countCells(map, x+1, y-1, findColor) + countCells(map, x, y+1, findColor)
						+ countCells(map, x-1, y-1, findColor) + countCells(map, x, y-1, findColor);			
		}	
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt(); // 맵의 높이 H
		int W = sc.nextInt(); // 맵의 넓이 W
		int[][] map = new int[H][W];	
		
		// 0 : 색칠안되어있음, -1 : 이미 확인된 픽셀, 그외 : 색깔
		for(int i=0; i < H; i++) {
			for(int j=0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		// (0, 0)의 색과 연결된 색 확인
		if(map[0][0] == 0 || map[0][0] == -1) { // (0, 0)이 0이거나 -1일 경우 탐색 안함 
			System.out.println("올바른 색상이 아닙니다");
		} else {
			System.out.println(map[0][0] + "색의 개수 = " + countCells(map, 0, 0, map[0][0]));
		}

	}

}
