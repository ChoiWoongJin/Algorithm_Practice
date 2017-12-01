package problem.Korea.BJ;

import java.util.Scanner;

class CheckPath {
	
	private static int planetInfoNum = 3;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int planetNum;
	private int[][] planetInfo;
	private int pathResult;
	
	CheckPath(int x1, int y1, int x2, int y2, int planetNum, int[][] planetInfo) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.planetNum = planetNum;
		this.planetInfo = new int[this.planetNum][planetInfoNum];
		System.arraycopy(planetInfo, 0, this.planetInfo, 0, planetInfo.length);
		this.pathResult = 0;
		
		checkPath();
	}
	
	private void checkPath() {
		// 1. 왕자가 원안에 있고 도착지는 원 밖에 있을 경우
		// 2. 왕자가 원 밖에 있고 도착지는 원 안에 있는 경우
		
		double distanceStart = 0;
		double distanceEnd = 0;
		for(int i=0; i < this.planetNum; i++) {
			distanceStart = Math.sqrt(Math.pow(planetInfo[i][0]-this.x1, 2) + Math.pow(planetInfo[i][1]-this.y1, 2));
			distanceEnd = Math.sqrt(Math.pow(planetInfo[i][0]-this.x2, 2) + Math.pow(planetInfo[i][1]-this.y2, 2));
			if(distanceStart < planetInfo[i][2] && distanceEnd >= planetInfo[i][2] ) this.pathResult++;
			else if(distanceStart >= planetInfo[i][2] && distanceEnd < planetInfo[i][2] ) this.pathResult++;
		}
	}
	
	public int getPathResult() {
		return this.pathResult;
	}
	
}

public class LittlePrince {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int testCaseNum = sc.nextInt();
		int planetInfoNum = 3;
		
		for(int testCase=0; testCase < testCaseNum; testCase++) {
			int x1 = sc.nextInt(); // 출발점 x
			int y1 = sc.nextInt(); // 출발점 y
			int x2 = sc.nextInt(); // 도착점 x
			int y2 = sc.nextInt(); // 도착점 y
			int planetNum = sc.nextInt(); // 행성계의 개수
			int[][] planetInfo = new int[planetNum][planetInfoNum];
			
			for(int planet=0; planet < planetNum; planet++) {
				for(int info=0; info < planetInfoNum; info++) {
					planetInfo[planet][info] = sc.nextInt();
				}
			}
			
			CheckPath cp = new CheckPath(x1, y1, x2, y2, planetNum, planetInfo);
			System.out.println(cp.getPathResult());
			
		}
		
		sc.close();
	}

}
