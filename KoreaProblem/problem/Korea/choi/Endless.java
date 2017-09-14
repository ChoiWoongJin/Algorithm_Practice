package problem.Korea.choi;

import java.util.Scanner;

// 너무 큰 값을 넣으면 OOME 발생

public class Endless {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String firstInput = sc.nextLine(); // 계속 변화함
		String stringS = sc.nextLine(); // 불변
		char[] charS = stringS.toCharArray(); // 불변
		int repeatNumber = Integer.parseInt(sc.nextLine());
		int min = Integer.parseInt(sc.next());
		int max = Integer.parseInt(sc.next());

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < repeatNumber; i++) {
			for (char c : charS) {
				if (c == '$') {
					sb.append(firstInput);
				} else {
					sb.append(c);
				}
			}
			firstInput = sb.toString();
			sb.delete(0, sb.length()); // sb 초기화
		}
        sc.close();

		System.out.println(firstInput.substring(min-1, max));
	}

}

/*
 * 문제 김지민이 Endless란 프로그램을 만들었다. 맨 처음 이 프로그램을 실행시킬 때는, 어떤 문자열을 입력으로 받는다. 그 이후에는 그
 * 전 실행의 출력이 이번 실행의 입력이 된다.
 * 
 * 처음에 입력되는 문자열은 알파벳 소문자로만 이루어져 있다.
 * 
 * 이 Endless 프로그램이 하는 일은 다음과 같다. 어떤 문자열 S가 정의되어 있다. 이 문자열 S는 알파벳 소문자와 ‘$’로 이루어져
 * 있다. 이제 S에서 ‘$’를 입력으로 들어온 문자열로 모두 바꾼 후에 출력한다.
 * 
 * 예를 들어, 처음 입력이 “a”이고, 문자열 S가 “$meric$”라고 하자.
 * 
 * 그럼 처음 실행될 때는 “america”가 출력된다. 그리고 그 다음 실행 될 때는 그 전의 출력된 문자열이 입력으로 쓰이므로,
 * “americamericamerica”가 출력될 것이다.
 * 
 * 처음 입력 문자열과, 문자열 S, 그리고 이 프로그램을 실행 시킬 횟수가 주어질 때, min번째 문자부터 max번째 문자까지 출력하는
 * 프로그램을 작성하시오.
 * 
 * 
 * 입력 첫째 줄에 이 프로그램의 처음 입력이 주어진다. 길이는 최대 50이다. 둘째 줄에는 문자열 S가 주어진다. 길이는 2보다 크거나
 * 같고, 50보다 작거나 같고, 가장 첫 문자는 항상 ‘$’이다. 셋째 줄에는 실행 시킬 횟수가 주어지며, 1000000000보다 작거나
 * 같은 자연수이다 마지막 줄에는 min과 max가 주어진다. min은1000000000보다 작거나 같은 자연수이고, max는 min보다
 * 크거나 같고, min+99보다 작거나 같은 자연수이다.
 * 
 * 출력 첫째 줄에 문제의 정답을 출력한다. 만약 해당하는 문자가 없을 때는 ‘-‘를 대신 출력한다.
 * 
 * 예제 입력 abc $x$y$z$ 10 30 50 예제 출력 bcyabcxabcyabczabczab
 * 
 * 문제출처 : https://www.acmicpc.net/problem/1055
 */