package problem.Korea.choi;

import java.util.Scanner;

/**
 * 전치행렬 생성 문제
 * Input 예제
 * 3
 * 1 2 3
 * 4 5 6
 * 7 8 9
 * Output예제
 * 1 4 7
 * 2 5 8
 * 3 6 9
 */
class NHNpretest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());
		String[] matrix = new String[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0) {
					matrix[j] = sc.next();
				} else {
					matrix[j] += " " + sc.next();
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.println(matrix[i]);
		}

	}
}
