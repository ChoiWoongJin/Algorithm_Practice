package problem.Japan.choi;

import java.util.*;

/**
 * 마을(지도)의 크기 W x H 값을 받는다
 * 쥐의 위치 x, y 값을 받는다
 * 문자 . 의 경우 서민의 집을 의미
 * 문자 *의 경우 부자의 집을 의미
 * 쥐는 가장 처음에는 북쪽(위)을 바라보고 있다
 * 쥐의 위치가 서민의 집일 경우 : 부자의 집으로 바꾸고 오른쪽으로 90도 회전 후 1칸 전진
 * 쥐의 위치가 부자의 집일 경우 : 서민의 집으로 바꾸고 왼쪽으로 90도 회전 후 1칸 전진
 * 쥐는 2000회 이동 이후에는 마을 밖으로 나온다.
 * 아래는 입출력 예

입력값
10 10
5 5
..........
..........
..........
..........
..........
..........
..........
..........
..........
..........

출력값
..****....
.*....*...
***....*..
********..
.**.*..*..
.*...*.**.
*..**.***.
.*.....*..
*..****...
..........

 */
public class Mouse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] map = new char[Integer.parseInt(sc.next())][Integer.parseInt(sc.next())];
		int firstX = Integer.parseInt(sc.next()) - 1, firstY = Integer.parseInt(sc.next()) - 1;
		int checkWay = 0, checkNum = 0;

		for (int i = 0; i < map.length; i++) {
			map[i] = sc.next().toCharArray();
		}

		// 북쪽(위) : x -1 0
		// 동쪽(우) : y +1 1
		// 남족(밑) : x +1 2
		// 서쪽(좌) : y -1 3
		while (checkNum < 2000 && firstX >= 0 && firstX < map.length && firstY >= 0 && firstY < map[0].length) {
			// .인지 *인지 확인
			// 방향(동서남북) 확인
			switch (map[firstX][firstY]) {
			case '.': // 서민집, 부자집(*)로 바꾸고 오른쪽 90도 전환 후 1칸 이동
				map[firstX][firstY] = '*';
				if (checkWay == 0) { // 원래 북쪽일 경우 동쪽으로 이동
					checkWay = 1;
					firstY++;
				} else if (checkWay == 1) {
					checkWay = 2;
					firstX++;
				} else if (checkWay == 2) {
					checkWay = 3;
					firstY--;
				} else if (checkWay == 3) {
					checkWay = 0;
					firstX--;
				}
				break;
			case '*': // 부자집, 서민집(.)로 바꾸고 왼쪽 90도 전환 후 1칸 이동
				map[firstX][firstY] = '.';
				if (checkWay == 0) { // 원래 북쪽일 경우 서쪽으로 이동
					checkWay = 3;
					firstY--;
				} else if (checkWay == 1) {
					checkWay = 0;
					firstX--;
				} else if (checkWay == 2) {
					checkWay = 1;
					firstY++;
				} else if (checkWay == 3) {
					checkWay = 2;
					firstX++;
				}
				break;

			}
			checkNum++;
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.print("\n");
		}

	}
}