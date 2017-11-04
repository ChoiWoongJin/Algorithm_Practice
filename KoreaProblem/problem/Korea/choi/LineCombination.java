package problem.Korea.choi;

import java.util.Arrays;

class LineCombination {
	public int[] setAlign(int n, long k) {
		int[] answer = new int[n];
		int[] number = new int[n];
		long x; // x = n!
		for (int i = 1; i <= n; i++) {
			number[i - 1] = i;
		}

		int N = n;
		int point;
		for (int i = 0; i < n; i++) {
			x = factorial(N);
			point = (int) ((k - 1) / (x / N));
			answer[i] = number[point];
			number[point] = 0;
			int[] temp = numberReset(number);
			number = new int[number.length - 1];
			number = temp;

			k = k % (x / N);
			if (k == 0) {
				k = x / N;
			}
			N--;
		}

		// n명 일 때 첫번째 글자가 ! 까지순
		// 1번 : n!/n * 1 까지
		// 2번 : n!/n * 2 까지
		// 3번 : n!/n * 3
		// n = 4, n! = 24
		// 제일 앞 글자 구하는 법
		// k번째의 제일 앞 글자는?
		// n = {1, 2, 3, 4}
		// int point = (k-1)/(n!/n);
		// k번째의 제일 앞 글자는 n[point]
		// 1234 1
		// 1243 2
		// 1324 3
		// 1342 4
		// 1423 5
		// 1432 6
		// 제일 앞 글자 빼고 다시 정렬
		// n = {1, 3, 4}
		// int point = (k-1)/(n!/n);
		// k번째의 제일 앞 글자는 n[point]
		// 1회 시행 후 k = k % (n!/n) : 0인 경우 k = (n!/n)
		// 1회 시행 후 n = n-1;
		// 2 134 7 1
		// 2 143 8 2
		// 2 314 9 3
		// 2 341 10 4
		// 2 413 11 5
		// 2 431 12 6

		// 3124 13

		return answer;
	}

	public static long factorial(int n) {
		long f = 1;
		for (int i = 1; i <= n; i++) {
			f *= i;
		}
		return f;
	}

	public static int[] numberReset(int[] a) {
		int[] result = new int[a.length - 1];
		int add = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				result[add++] = a[i];
			}
		}
		return result;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(3, 5)));
	}
}
