package problem.Korea.choi;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;

/**
 * 여러 개의 자연수를 표준 입력(standard input)에서 읽은 후, 그 수들을 이어 붙여서 만들 수 있는 가장 큰 수와 가장 작은 수의 합을 구하세요.
 * @int[] getNum : 표준 입력 받은 숫자를 저장
 * @int max, min : 최소값, 최대값 저장
 */
class NHNtest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int[] getNum = new int[st.countTokens()];
		int i = 0, max = 0, min = 0, temp = 0;

		sc.close();

		while (st.hasMoreTokens()) {
			getNum[i] = Integer.parseInt(st.nextToken()); // 표준 입력을 int형 배열에 저장
			i++;
		}

		// 숫자 정렬 : 앞뒤 숫자를 비교해서 일의자리, 십의자리 숫자가 하나라도 클 경우 뒤로 보낸다
		for (i = 0; i < getNum.length - 1; i++) {
			for (int j = i + 1; j < getNum.length; j++) {
				if (getNum[i] < 10 && getNum[j] < 10) { // 둘다 10보다 작을 때
					if (getNum[i] > getNum[j]) { // i번째가 j번째보다 크면 i번째를 뒤로 보낸다
						temp = getNum[i];
						getNum[i] = getNum[j];
						getNum[j] = temp;
					}
				} else if (getNum[i] >= 10 && getNum[j] < 10) { // i번째가 10보다 클 때
					if ((getNum[i] / 10) > getNum[j]) { // i번째의 10의 자리가 j보다 크면 뒤로 보낸다
						temp = getNum[i];
						getNum[i] = getNum[j];
						getNum[j] = temp;
					} else if ((getNum[i] / 10) == getNum[j] && (getNum[i] % 10) > getNum[j]) { // i의 10의자리가 j랑 같은 경우,
																								// i의 1의자리가 j보다 크면 뒤로
																								// 보낸다
						temp = getNum[i];
						getNum[i] = getNum[j];
						getNum[j] = temp;
					}
				} else if (getNum[i] < 10 && getNum[j] >= 10) { // j번째가 10보다 클 때
					if (getNum[i] > (getNum[j] / 10)) { // i번째의 숫자가 j번째의 10의자리 크면 뒤로 보낸다
						temp = getNum[i];
						getNum[i] = getNum[j];
						getNum[j] = temp;
					} else if (getNum[i] == (getNum[j] / 10) && getNum[i] > (getNum[j] % 10)) { // i가 j의 10의자리랑 같은 경우,
																								// i가 j의 1의자리보다 크면 뒤로
																								// 보낸다
						temp = getNum[i];
						getNum[i] = getNum[j];
						getNum[j] = temp;
					}
				} else if (getNum[i] >= 10 && getNum[j] >= 10) { // 둘다 10보다 클 때
					if (getNum[i] > getNum[j]) { // i가 j보다 크면 뒤로 보낸다
						temp = getNum[i];
						getNum[i] = getNum[j];
						getNum[j] = temp;
					}
				}
			}
		}

		for (i = 0; i < getNum.length; i++) {
			if (getNum[getNum.length - i - 1] < 10) {
				max = (max * 10) + getNum[getNum.length - i - 1]; // 가장 큰 숫자부터 저장
			} else {
				max = (max * 100) + getNum[getNum.length - i - 1]; // 가장 큰 숫자부터 저장
			}

			if (getNum[i] < 10) {
				min = (min * 10) + getNum[i]; // 가장 작은 숫자부터 저장
			} else {
				min = (min * 100) + getNum[i]; // 가장 작은 숫자부터 저장
			}
		}

		System.out.println(max + min); // 가장 큰 수와 가장 작은 수의 합 도출

	}
}
