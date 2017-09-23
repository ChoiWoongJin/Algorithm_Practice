package problem.Korea.choi;

import java.util.Scanner;
import java.util.StringTokenizer;

class NHNFirstTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] checkN = new int[3];
		checkN[0] = Integer.parseInt(sc.next());
		checkN[1] = Integer.parseInt(sc.next());
		checkN[2] = Integer.parseInt(sc.next());
		int manNum = Integer.parseInt(sc.next());
		String[] manInfo = new String[manNum];
		String temp = "";
		sc.nextLine();

		for (int i = 0; i < manNum; i++) {
			manInfo[i] = sc.nextLine();
		}
		for (int i = 0; i < manNum - 1; i++) {
			for (int j = i; j < manNum; j++) {
				if (check(manInfo[i], manInfo[j], checkN) == 1) {
					temp = manInfo[i];
					manInfo[i] = manInfo[j];
					manInfo[j] = temp;
				}
			}
		}

		for (int i = 0; i < manNum; i++) {
			System.out.println(manInfo[i]);
		}

	}

	// 0 = equal, 1 = true, -1 = false
	public static int check(String manInfo1, String manInfo2, int[] checkN) {
		StringTokenizer st1 = new StringTokenizer(manInfo1);
		StringTokenizer st2 = new StringTokenizer(manInfo2);
		String[] man1 = new String[3];
		String[] man2 = new String[3];
		int c = 0, i = 0, loop = 1;

		while (st1.hasMoreTokens()) {
			man1[i] = st1.nextToken();
			i++;
		}
		if (i == 2) {
			man1[2] = "No";
		}
		i = 0;
		while (st2.hasMoreTokens()) {
			man2[i] = st2.nextToken();
			i++;
		}
		if (i == 2) {
			man2[2] = "No";
		}

		int age1 = Integer.parseInt(man1[1]);
		int age2 = Integer.parseInt(man2[1]);
		int man1C3, man2C3;

		if (man1[2].equals("PW")) {
			man1C3 = 3;
		} else if (man1[2].equals("DP")) {
			man1C3 = 2;
		} else if (man1[2].equals("P")) {
			man1C3 = 1;
		} else {
			man1C3 = 0;
		}
		if (man2[2].equals("PW")) {
			man2C3 = 3;
		} else if (man2[2].equals("DP")) {
			man2C3 = 2;
		} else if (man2[2].equals("P")) {
			man2C3 = 1;
		} else {
			man2C3 = 0;
		}

		while (loop > 0 && c < 3) {
			if (checkN[c] == 1) {
				if (man1[0].equals(man2[0])) {
					c++;
				} else if (man1[0].equals("M") && man2[0].equals("F")) {
					return 1;
				} else {
					return -1;
				}
			} else if (checkN[c] == 2) {
				if (age1 == age2) {
					c++;
				} else if (age1 < 8 && age2 < 8 && age1 > age2) {
					return 1;
				} else if (age1 > 7 && age2 < 8) {
					return 1;
				} else if (age1 > 7 && age2 > 7 && age1 < age2) {
					return 1;
				} else {
					return -1;
				}
			} else if (checkN[c] == 3) {
				if (man1C3 == man2C3) {
					c++;
				} else if (man1C3 < man2C3) {
					return 1;
				} else {
					return -1;
				}
			}
		}

		return 0;
	}
}
