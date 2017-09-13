package problem.Japan.choi;

import java.util.*;


/**
 * 흑자 만들기
 * 아래는 Input이다
3 5			// 3은 공연을 보러오는 손님의 수, 5는 공연의 회수이다
3 0 -2		// 3 0 -2는 손님 3명 각각이 만들어 내는 이윤이다. 모두 합하면 1이 된다
1 5 1
-4 1 0
-1 -2 3
0 0 2
 * Output  : 10
 *	공연을 진행할 때 흑자의 최대값을 구하는 문제
 */
public class IdolDream {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next()); // 손님 수
        int M = Integer.parseInt(sc.next()); // 공연 수
        if(N == 0 || M == 0) { // 공연이나 손님이 0인 경우 종료
            System.out.println("0");
            return;
        }
        
        int result = 0, temp = 0; // result : 흑자의 총합
        
        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                temp += Integer.parseInt(sc.next());
            }
            if(temp > 0) { // 흑자인 경우
                result += temp;
            }
            temp = 0; // temp 초기화
            
        }
        
        System.out.println(result);
    }
}


/*"0이었다. 올해의 이익은 0. 작년에도 0. 그 전에도 그 전에도 계속 0. 내년에는 꼭……" 

그렇게 말하는 당신의 친구의 지하 아이돌을 연출하게 되었습니다. 

그녀의 팬 클럽에는 회원이 N사람이 있습니다. 그녀는 팬클럽 회원 한정 라이브 이벤트를 실시합니다만, 
라이브마다 일정 개최 비용이 고객 한명이 걸립니다. 그녀의 팬클럽 회원은 너무 단결력이 강하고 
어떤 콘서트도 개최하면 전원이 꼭 참가했습니다. 그곳에서 전원으로부터 일인당 비용 이상의 입장료를 징수하면 적자가 되지 않지만 
과거 그것을 실행한 곳 팬 클럽 회원이 급감했기 때문에 현재는 무료로 라이브를 개최하고 
물건을 파는 것에서 매출을 얻는 전략을 취하고 있습니다. 

내년은 모두 M회의 라이브 이벤트를 개최할 예정입니다. 
다만 모든 라이브를 적당히 열면 적자 투성이가 될 가능성이 있으므로, 개최하는 라이브를 적절히 선택할 필요가 있습니다. 
각각의 라이브마다 각 팬클럽 회원이 가져올 손익의 정보가 존재합니다. 손익은 과거의 통계 정보로부터 받은 
그 행사에서 각 회원에 대한 예측되는 상품 구매액에서 회원 한 사람당의 라이브 개최 비용을 뺀 것입니다. 
어떤 회원이 별로 물건을 사지 않을 것으로 예측되면 이 값은 지게 되는 일이 있습니다. 
이는 회원들이 손실을 가져오는 것을 의미하고 있습니다. 

예를 들면 회원 수 N=3, 이벤트 횟수 M=5로, 라이브 이벤트 정보를 다음과 같이 했다고 합시다. 

회원 1	회원 2	회원 3
라이브 1	3	0	-2
라이브 2	1	5	1
라이브 3	-4	1	0
라이브 4	-1	-2	3
라이브 5	0	0	2
라이브 1은 회원 1이 3엔의 이익을 가져오는 회원 3이 2엔의 손실을 가져오는 것을 나타내고 있습니다. 그 외에도 마찬가지입니다.
이 경우 열린 라이브와 내년의 그의 손익의 예를 이하에 몇가지 나타냅니다.

개최한 라이브	그녀가 얻은 손익
1	1
3	-3
2, 4	7
3, 4	-3
1, 2, 3	5
또 그녀가 얻는 손익이 마이너스인 경우는 그 수의 크기와 같은 수만큼 손실이 날것으로 합니다.
위 표에 기재한 대로 만약 그녀가 라이브 3, 4를 개최한 경우 그녀는 내년 3엔의 적자가 됩니다.

자, 팬클럽 회원 수 N, 라이브 이벤트 수 M, 라이브별 수익 정보가 주어지기 때문에
당신의 친구 때문에 적절하게 라이브를 개최한 경우 얻는 내년의 이익을 최대치를 구하세요.

다만 N과 M은 각각 값 0을 취할 가능성이 있다는 것을 생각하세요.
또 라이브를 어떻게 개최해도 얻는 최대 손익이 마이너스인 경우, 즉 반드시 적자가 되는 경우,
그렇다면 아무것도 하지 않는 편이 좋다는 것에서 라이브 이벤트를 실시하지 않는, 즉 손익 0라는 처리를 하세요.*/