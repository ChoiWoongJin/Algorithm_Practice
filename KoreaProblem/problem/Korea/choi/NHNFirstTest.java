package problem.Korea.choi;

import java.util.Scanner;
import java.util.StringTokenizer;

class NHNFirstTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.nextLine());
		int[] getNum = new int[st.countTokens()];
		int[] pocket = new int[3];
		int i = 0, j = 0;
		boolean checkOut = false;

		while (st.hasMoreTokens()) {
			getNum[i] = Integer.parseInt(st.nextToken());
			i++;
		}

		for (i = 0; i < getNum.length; i++) {
			if (i == 0) {
				pocket[0] = getNum[i];
			} else if (i == 1) {
				pocket[1] = getNum[i];
			} else if (i == 2) {
				pocket[2] = getNum[i];
			} else if (i > 2) {
				if (check(pocket, getNum[i]) == -1) {
					System.out.println(pocket[0]);
					checkOut = true;
					pocket[0] = pocket[1];
					pocket[1] = pocket[2];
					pocket[2] = getNum[i];
				} else {
					switch (check(pocket, getNum[i])) {
					case 0:
						pocket[0] = pocket[1];
						pocket[1] = pocket[2];
						pocket[2] = getNum[i];
						break;
					case 1:
						pocket[1] = pocket[2];
						pocket[2] = getNum[i];
						break;
					case 2:
						break;
					}
				}
			}
		}

		if (checkOut == false) {
			System.out.println(0);
		}

	}

	public static int check(int[] pocket, int getNum) {
		for (int i = 0; i < 3; i++) {
			if (pocket[i] == getNum) {
				return i;
			}
		}
		return -1;
	}
}
