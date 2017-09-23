package problem.Korea.choi;

import java.util.Scanner;

class NHNFirstTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String checkED = sc.next();
		char[] secretKey = sc.next().toCharArray();
		int lotate = Integer.parseInt(sc.next());
		char[] origin = sc.next().toCharArray();
		int limit = secretKey.length, j = 0;
		char temp = ' ';

		if (checkED.equals("encrypt")) {
			for (int i = 0; i < origin.length; i++) {
				if (((int) origin[i] + (int) secretKey[j] - 97) < 123) {
					origin[i] = (char) ((int) origin[i] + (int) secretKey[j] - 97);
				} else {
					origin[i] = (char) ((int) origin[i] + (int) secretKey[j] - 97 - 26);
				}
				j++;
				if (j == limit)
					j = 0;
			}

			if (lotate > 0) {
				for (int i = 0; i < lotate; i++) {
					temp = origin[0];
					for (j = 0; j < origin.length - 1; j++) {
						origin[j] = origin[j + 1];
					}
					origin[origin.length - 1] = temp;
				}
			} else {
				lotate = -lotate;
				for (int i = 0; i < lotate; i++) {
					temp = origin[origin.length - 1];
					for (j = origin.length - 1; j > 0; j--) {
						origin[j] = origin[j - 1];
					}
					origin[0] = temp;
				}
			}

		} else if (checkED.equals("decrypt")) {
			if (lotate > 0) {
				for (int i = 0; i < lotate; i++) {
					temp = origin[origin.length - 1];
					for (j = origin.length - 1; j > 0; j--) {
						origin[j] = origin[j - 1];
					}
					origin[0] = temp;
				}
			} else {
				lotate = -lotate;
				for (int i = 0; i < lotate; i++) {
					temp = origin[0];
					for (j = 0; j < origin.length - 1; j++) {
						origin[j] = origin[j + 1];
					}
					origin[origin.length - 1] = temp;
				}
			}

			for (int i = 0; i < origin.length; i++) {
				if (((int) origin[i] - ((int) secretKey[j] - 97)) > 96) {
					origin[i] = (char) ((int) origin[i] - ((int) secretKey[j] - 97));
				} else {
					origin[i] = (char) ((int) origin[i] - ((int) secretKey[j] - 97) + 26);
				}
				j++;
				if (j == limit)
					j = 0;
			}

		}

		for (int i = 0; i < origin.length; i++) {
			System.out.print(origin[i]);
		}

	}
}
