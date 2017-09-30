package problem.Korea.choi;

//don't place package name.

import java.io.*;
import java.util.*;

//don't change 'Program' class name and without 'public' accessor.
public class Maidas2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = 0;

		int testNum = Integer.parseInt(sc.next());
		String[] test = new String[testNum];

		for (int i = 0; i < testNum; i++) {
			test[i] = sc.next();
		}

		for (int i = 0; i < testNum; i++) {
			char[] a = test[i].toCharArray();
			int size = test[i].length();

			for (int j = 0; j < size / 2; j++) {
				if (a[j] != a[size - 1 - j]) {
					if ((int) a[j] > (int) a[size - 1 - j]) {
						a[j] = (char) ((int) a[j] - 1);
					} else {
						a[size - 1 - j] = (char) ((int) a[size - 1 - j] - 1);
					}
					cnt++;
					j--;
					continue;
				}
			}
			System.out.println(cnt);
			cnt = 0;
		}
	}

}
