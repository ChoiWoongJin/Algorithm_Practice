package problem.Japan.choi;

import java.util.*;

/**
 * 입력은 1행으로 이루어져 있다 입력은 0~5050의 정수이다 Input 예제 : 5 3 위의 경우 덧셈 문제 5개와 뺄셈 문제 3가지를
 * 만들어 내야 한다 문제의 조건은 아래와 같다 더하거나 뺏을 때의 결과는 0~99 사이의 정수이다 문제는 중복되면 안된다 a와 b가 서로다른
 * 숫자일 경우 a + b = / b + a = 는 서로 다른 문제이다.
 * 
 */

public class MathWorkbook {

	public static void makePM(int p, int m) {
		int preNum = 0, postNum = 0, checkP = 0, checkM = 0;
		int[][] check = new int[100][100];
		Random r = new Random();
		
		for(int i=0; i<100; i++) {
		    for(int j=0; j<100; j++) {
		        check[i][j] = 0;
		    }
		}

		while (checkP < p || checkM < m) {
			preNum = r.nextInt(100); // 0~99
			postNum = r.nextInt(100); // 0~99
            if(checkP < p && preNum + postNum < 100 && check[preNum][postNum] == 0) { // 플러스 값을 충족, 중복이 아닐 때
				check[preNum][postNum] = 1;
				System.out.println(preNum + " + " + postNum + " =");
				checkP++;
            }
			
			preNum = r.nextInt(100); // 0~99
			postNum = r.nextInt(100); // 0~99
			if(checkM < m && preNum - postNum >= 0 && check[preNum][postNum] == 0) { // 마이너스 값을 충족, 중복이 아닐 때
    			check[preNum][postNum] = 1;
    			System.out.println(preNum + " - " + postNum + " =");
    			checkM++;
			}
		}
	}

	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int p = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		makePM(p, m);
	}
}

/*public class MathWorkbook {

	public static void makePM(int p, int m) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int preNum = 0, postNum = 0, checkP = 0, checkM = 0;
		Random r = new Random();

		while (checkP < p || checkM < m) {
			preNum = r.nextInt(100); // 0~99
			postNum = r.nextInt(100); // 0~99

			if (preNum + postNum < 100 && checkP < p) { // 플러스의 경우를 충족시킬 때
				if (hm.containsKey(preNum) == true && hm.get(preNum) != postNum) { // 키는 같지만 값은 같지 않을 때
					hm.put(preNum, postNum);
					System.out.println(preNum + " + " + postNum + " =");
					checkP++;
				} else if (hm.containsKey(preNum) == false) { // 처음부터 다를 때, 바로 넣어 주자
					hm.put(preNum, postNum);
					System.out.println(preNum + " + " + postNum + " =");
					checkP++;
				}
			} else if (preNum - postNum >= 0 && checkM < m) { // 마이너스의 경우를 충족시킬 때
				if (hm.containsKey(preNum) == true && hm.get(preNum) != postNum) { // 키는 같지만 값은 같지 않을 때
					hm.put(preNum, postNum);
					System.out.println(preNum + " - " + postNum + " =");
					checkM++;
				} else if (hm.containsKey(preNum) == false) { // 처음부터 다를 때, 바로 넣어 주자
					hm.put(preNum, postNum);
					System.out.println(preNum + " - " + postNum + " =");
					checkM++;
				}
			}
		}
	}

	public static void main(String[] args) {
		// 自分の得意な言語で
		// Let's チャレンジ！！

		Scanner sc = new Scanner(System.in);
		int p = Integer.parseInt(sc.next());
		int m = Integer.parseInt(sc.next());

		makePM(p, m);
	}
}*/