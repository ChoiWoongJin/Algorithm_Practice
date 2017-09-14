package problem.Korea.choi;

import java.util.*;

public class kakao1 {
    public static Map<String, Integer> hm = new HashMap<String, Integer>();
    
    public static void checkFour(int i, int j, int max_D, int max_R, int[][] picture) { // 상하좌우 인접한것 중 같은게 있는지 찾아본다
        
        String ij = "";
        
        ij = Integer.toString(i) + "," + Integer.toString(j);
        hm.put(ij, picture[i][j]); // 자신의 값을 저장
        
        // 상 탐색
        ij = Integer.toString(i-1) + "," + Integer.toString(j);
        if(i-1 >= 0 && hm.containsKey(ij) == false) { // SOF 방지, 이미 탐색한 것이 아닐 경우
            if(picture[i][j] == picture[i-1][j]) { // 상과 색이 같을 경우
                checkFour(i-1, j, max_D, max_R, picture); // 상의 값에서도 탐색 시작
            }
        }
        // 하 탐색         
        ij = Integer.toString(i+1) + "," + Integer.toString(j);
        if(i+1 < max_D && hm.containsKey(ij) == false) { // SOF 방지, 이미 탐색한 것이 아닐 경우
            if(picture[i][j] == picture[i+1][j]) { // 하와 색이 같을 경우
                checkFour(i+1, j, max_D, max_R, picture); // 하의 값에서도 탐색 시작
            }
        }
        // 좌 탐색         
        ij = Integer.toString(i) + "," + Integer.toString(j-1);
        if(j-1 >= 0 && hm.containsKey(ij) == false) { // SOF 방지, 이미 탐색한 것이 아닐 경우
            if(picture[i][j] == picture[i][j-1]) { // 좌와 색이 같을 경우
                checkFour(i, j-1, max_D, max_R, picture); // 좌의 값에서도 탐색 시작
            }
        }
        // 우 탐색         
        ij = Integer.toString(i) + "," + Integer.toString(j+1);
        if(j+1 < max_R && hm.containsKey(ij) == false) { // SOF 방지, 이미 탐색한 것이 아닐 경우
            if(picture[i][j] == picture[i][j+1]) { // 우와 색이 같을 경우
                checkFour(i, j+1, max_D, max_R, picture); // 우의 값에서도 탐색 시작
            }
        }                                     
    }
    
  public static int[] solution(int m, int n, int[][] picture) {
      int numberOfArea = 0;
      int maxSizeOfOneArea = 0;
      int getSize = 0;
      String ij = "";
      
      for(int i=0; i<m; i++) {
          for(int j=0; j<n; j++) {
              ij = Integer.toString(i) + "," + Integer.toString(j);
              if(picture[i][j] != 0 && hm.containsKey(ij) == false) { // 색이 들어 있고, 탐색한 색이 아닐 경우
                  checkFour(i, j, m, n, picture);
                  if(maxSizeOfOneArea < hm.size() - getSize) { // 탐색 결과 나온 영역의 크기 중 최대값을 계속 최신화
                      maxSizeOfOneArea = hm.size() - getSize;
                  }
                  getSize = hm.size();
                  numberOfArea++;
              }
          }
      }      

      int[] answer = new int[2];
      answer[0] = numberOfArea;
      answer[1] = maxSizeOfOneArea;
	  System.out.println(answer[0] + "," + answer[1]);
      return answer;
  }
  
  public static void main(String[] args) {
	  int[] testcase1 = {13, 16};
	  int[][] testarr1 = { {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
			  {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
			  {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0},
			  {0, 1, 1, 1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 2, 1, 2, 1, 1, 2, 1, 2, 1, 1, 1, 0},
			  {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 1, 3, 3, 3, 1, 1, 1, 1, 1, 1, 3, 3, 3, 1, 0},
			  {0, 1, 1, 1, 1, 1, 2, 1, 1, 2, 1, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 0, 0},
			  {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0} };
	  int[] testanswer1 = {12, 120};	  
	  
	  int[] answer = new int[2];
	  answer = solution(testcase1[0], testcase1[1], testarr1);
	  
	  System.out.println("실행됨?");
	  for(int i=0; i<2; i++) {
		  if(testanswer1[i] == answer[i]) {
			  System.out.println("정답입니다!");
		  }
	  }	  
  }  
}


/*카카오 프렌즈 컬러링북

출판사의 편집자인 어피치는 네오에게 컬러링북에 들어갈 원화를 그려달라고 부탁하여 여러 장의 그림을 받았다. 여러 장의 그림을 난이도 순으로 컬러링북에 넣고 싶었던 어피치는 영역이 많으면 색칠하기가 까다로워 어려워진다는 사실을 발견하고 그림의 난이도를 영역의 수로 정의하였다. (영역이란 상하좌우로 연결된 같은 색상의 공간을 의미한다.)

그림에 몇 개의 영역이 있는지와 가장 큰 영역의 넓이는 얼마인지 계산하는 프로그램을 작성해보자.

alt text

위의 그림은 총 12개 영역으로 이루어져 있으며, 가장 넓은 영역은 어피치의 얼굴면으로 넓이는 120이다.

입력 형식
입력은 그림의 크기를 나타내는 m과 n, 그리고 그림을 나타내는 m × n 크기의 2차원 배열 picture로 주어진다. 제한조건은 아래와 같다.

1 <= m, n <= 100
picture의 원소는 0 이상 2^31 - 1 이하의 임의의 값이다.
picture의 원소 중 값이 0인 경우는 색칠하지 않는 영역을 뜻한다.
출력 형식
리턴 타입은 원소가 두 개인 정수 배열이다. 그림에 몇 개의 영역이 있는지와 가장 큰 영역은 몇 칸으로 이루어져 있는지를 리턴한다.

예제 입출력
m	n	picture	answer
6	4	[[1, 1, 1, 0], [1, 2, 2, 0], [1, 0, 0, 1], [0, 0, 0, 1], [0, 0, 0, 3], [0, 0, 0, 3]]	[4, 5]
예제에 대한 설명
예제로 주어진 그림은 총 4개의 영역으로 구성되어 있으며, 왼쪽 위의 영역과 오른쪽의 영역은 모두 1로 구성되어 있지만 상하좌우로 이어져있지 않으므로 다른 영역이다. 가장 넓은 영역은 왼쪽 위 1이 차지하는 영역으로 총 5칸이다.*/