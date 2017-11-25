package problem.Korea.choi;

import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuffer;

/**
 * 게임 맵의 상태 maps가 매개변수로 주어질 때, 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성. 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return
 * 처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치
 * 조건
   maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수
   	n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않음
 * 입출력 예
	maps															answer
	[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]	  11
	[[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,0],[0,0,0,0,1]]	  -1
 * @author Yuni
 *
 */

class Solution {
    
	public int solution(int[][] maps) {
		int answer = 0;
        Queue<String> q = new LinkedList<String>();
        StringBuffer sb = new StringBuffer();
        q.offer("0,0");
        int move = 1;
        String[] point;
        int qSize = 0, x = 0, y = 0;
        int maxX = maps.length, maxY = maps[0].length;
        
        while(!q.isEmpty()) {
            qSize = q.size();
            for(int i=0; i < qSize; i++) {
                point = q.poll().split(",");
                x = Integer.parseInt(point[0]);
                y = Integer.parseInt(point[1]);
                
                if(maps[x][y] != 1 && x != 0 && y != 0) continue;
                
                maps[x][y] = move;
                
                if(x+1 < maxX && maps[x+1][y] != 0 && maps[x+1][y] == 1) {
                    sb.setLength(0);
                    sb.append(Integer.toString(x+1)).append(",").append(Integer.toString(y));
                    q.offer(sb.toString());
                }
                if(y+1 < maxY && maps[x][y+1] != 0 && maps[x][y+1] == 1) {
                    sb.setLength(0);
                    sb.append(Integer.toString(x)).append(",").append(Integer.toString(y+1));
                    q.offer(sb.toString());
                }
                if(x > 0 && maps[x-1][y] != 0 && maps[x-1][y] == 1 && (x-1 != 0 && y != 0)) {
                    sb.setLength(0);
                    sb.append(Integer.toString(x-1)).append(",").append(Integer.toString(y));
                    q.offer(sb.toString());
                }
                if(y > 0 && maps[x][y-1] != 0 && maps[x][y-1] == 1 && (x != 0 && y-1 != 0)) {
                    sb.setLength(0);
                    sb.append(Integer.toString(x)).append(",").append(Integer.toString(y-1));
                    q.offer(sb.toString());
                }
            }
            move++;
        }
        
		return (maps[maxX-1][maxY-1] != 1) ? maps[maxX-1][maxY-1] : -1;
	}
}