package problem.Japan.choi;

import java.util.*;

public class TrainCrossTime {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 상행 열차가 올 때 a초 전에 건널목 닫음
        int b = sc.nextInt(); // b초 후에 건널목 염
        int c = sc.nextInt(); // 하행 열차가 올 때 c초 전에 건널목 닫음
        int d = sc.nextInt(); // d초 후에 건널목 염
        int e = sc.nextInt(); // e초 안에 다시 내려야 하면 건널목 안염
        int n = sc.nextInt(); // 시간표 개수
        // 0 : 상행 / 1 : 하행
        // 열차 도착시간 / 출발 시간
        int[][] trainTime = new int[n][5];
        String[] temp = new String[2];
        for(int i=0; i < n; i++) {
        	trainTime[i][0] = sc.nextInt();
        	temp = sc.next().split(":");
        	trainTime[i][1] = Integer.parseInt(temp[0]);
        	trainTime[i][2] = Integer.parseInt(temp[1]);
        	temp = sc.next().split(":");
        	trainTime[i][3] = Integer.parseInt(temp[0]);
        	trainTime[i][4] = Integer.parseInt(temp[1]);
        }        
        
        int[][] cl = new int[n][3]; // HH:MM:SS
        int[][] op = new int[n][3]; // HH:MM:SS
        for(int i=0; i < n; i++) {
        	if(trainTime[i][0] == 0) { // 상행
        		cl[i] = closeTime(cl[i], trainTime[i], a);
        		op[i] = openTime0(op[i], trainTime[i], b);
        	} else { // 하행
        		cl[i] = closeTime(cl[i], trainTime[i], c);
        		op[i] = openTime1(op[i], trainTime[i], d);
        	}
        }
        
        cl = timeSort(cl);
        op = timeSort(op);

        int[][] result = new int[n][6];
        result = clopResult(cl, op, e, result);

        
        int i=0;
        String resultOut = "";
        while(result[i][0] != 0) {
        	for(int j=0; j < 11; j++) {
        		if(j == 5) {
        			resultOut += " - ";
        		} else if( j%2 == 1) {
        			resultOut += ":";
        		} else {
        			if(result[i][j/2] < 10) {
        				resultOut += "0"; 
        			}
        			resultOut += Integer.toString(result[i][j/2]);
        		}
        	}
        	
        	System.out.println(resultOut);
        	i++;
        	resultOut = "";
        	if(i == result.length) {
        		break;
        	}
        }
        
        sc.close();
    }
    
    public static int[][] timeSort(int[][] a) {
    	int[] temp = new int[3];
    	
    	for(int i=0; i < a.length - 1; i++) {
    		for(int j=0; j < a.length - 1 - i; j++) {
    			if(timeGap(a[j], a[j+1]) == 1) {
    				temp = a[j];
    				a[j] = a[j+1];
    				a[j+1] = temp;
    			}
    		}
    	}
    	
    	return a;
    }
    
    public static int timeGap(int[] a, int[] b) {
    	int result = 1; // 0 : 같다, -1 : b가 늦다, 1 : a가 늦다
    	int[] c = new int[3];
    	c[0] = a[0] - b[0];
    	c[1] = a[1] - b[1];
    	c[2] = a[2] - b[2];
    	
    	if(c[0] == 0 && c[1] == 0 && c[2] == 0) {
    		result = 0;
    	} else if( (c[0] == 0 && c[1] == 0 && c[2] < 0) || // b가 클 경우
    			    (c[0] == 0 && c[1] < 0) || 
    			     c[0] < 0 ){
    		result = -1;
    	}    	
    	
    	return result;
    }
    
    public static int[][] clopResult(int[][] cl, int[][] op, int e, int[][] result) {    	
    	    	
    	for(int i=0; i < cl.length - 1; i++) {
    		// 조건 1 : cl1,op1 cl2,op2 일때, cl2보다 op1이 늦으면 op1,op2중 늦은 걸 선택
        	//            결과적으로 cl1 ~ op1(2) 가 된다
    		if( timeGap(op[i], cl[i+1]) == 1 ) { 
    			cl[i+1] = cl[i];
    			if(timeGap(op[i], op[i+1]) == 1) { // op[i] 선택
    				op[i+1] = op[i];
    			} else { // op[i+1] 선택
    				op[i] = op[i+1];
    			}
    			continue;
    		}
    		
        	// 조건 2 : op1과 cl2 사이의 간격이 e초 이하일 경우 안염
        	//            결과적으로 cl1 ~ op2 가 된다    		
    		if( checkTimeGap(op[i], cl[i+1], e) ) {
    			cl[i+1] = cl[i];
    			op[i] = op[i+1];
    		} 
    	}
    	
    	result[0][0] = cl[0][0];
    	result[0][1] = cl[0][1];
    	result[0][2] = cl[0][2];
    	result[0][3] = op[0][0];
    	result[0][4] = op[0][1];
    	result[0][5] = op[0][2];
    	int check = 0;
    	for(int i=1; i <cl.length; i++) {
    		if(result[check][0] == cl[i][0] && result[check][1] == cl[i][1] && result[check][2] == cl[i][2] &&
    		   result[check][3] == op[i][0] && result[check][4] == op[i][1] && result[check][5] == op[i][2] ) {
    			continue;
    		}
			check++;
			result[check][0] = cl[i][0];
	    	result[check][1] = cl[i][1];
	    	result[check][2] = cl[i][2];
	    	result[check][3] = op[i][0];
	    	result[check][4] = op[i][1];
	    	result[check][5] = op[i][2];

    	}
    	
    	return result;
    }
    
    public static boolean checkTimeGap(int[] a, int[] b, int e) {
    	int aSum = a[0]*60*60 + a[1]*60 + a[2];
    	int bSum = b[0]*60*60 + b[1]*60 + b[2];
    	int result = Math.abs(aSum - bSum);
    	
    	if(result < e) {
    		return true;
    	}    	
    	
    	return false;
    }
    
    public static int[] closeTime(int[] cl, int[] trainTime, int a) {
    	cl[2] = 60 - a;
    	if(trainTime[2] != 0) { // 0분이 아닐 경우
    		cl[0] = trainTime[1]; // 시간 그대로
    		cl[1] = trainTime[2] - 1; // 1분 뺀 값
    	} else { // 0분일 경우
    		if(trainTime[1] != 0) { // 0시 아닐 경우
    			cl[0] = trainTime[1] - 1; // 1시 뺀 값
    		} else { // 0시일 경우
    			cl[0] = 23; // 23시
    		}    		
    		cl[1] = 59; // 59분
    	}
    	
    	return cl;
    }
    
    public static int[] openTime0(int[] op, int[] trainTime, int b) {
    	op[0] = trainTime[3];
    	op[1] = trainTime[4];
    	op[2] = b;    	
    	
    	return op;
    }
    public static int[] openTime1(int[] op, int[] trainTime, int b) {
    	op[0] = trainTime[1];
    	op[1] = trainTime[2];
    	op[2] = b;    	
    	
    	return op;
    }
    
}

//あなたの家の近くには駅があり、駅のすぐとなりには踏切があります。 駅にはたくさんの電車が出入りするので、ときにその踏切は非常に長い時間閉まっていることがあります。
//
//そこで、駅の時刻表などのデータから、その踏切の開閉時刻表を作成することにしました。
//
//線路には向きがあり、駅から踏切のほうへ進む向きのことを上り、踏切から駅のほうへ進む向きのことを下りと呼ぶことにします。 時刻表には、駅に出入りする上り下りすべての電車に対して、駅に到着する時刻と駅を出発する時刻が書かれています。
//
//踏切は以下のルールに従って稼働しています。
//
//・上りの電車が駅に到着する a 秒前に踏切を閉じ、駅を出発した b 秒後に踏切を開きます。
//・下りの電車が駅に到着する c 秒前に踏切を閉じ、駅に到着した d 秒後に踏切を開きます。
//
//ただし、以下のような例外が存在します。
//・踏切が閉まっている状態においてさらに踏切を閉じる必要が生じた場合、踏切を開く時刻がより遅いほうに従って踏切を開きます。
//・踏切を開く時刻から e 秒以内に再度踏切を閉じる必要がある場合、踏切を開きません。
//
//さて、整数 a, b, c, d, e と駅の時刻表が与えられるので、踏切の開閉時刻表を作成してください。



//入力される値
//a b c d e
//n
//f_1 t_1 s_1
//f_2 t_2 s_2
//...
//f_n t_n s_n
//
//・入力の 1 行目に問題文の定義に沿って a, b, c, d, e がこの順に半角スペース区切りで与えられます。
//・入力の 2 行目に駅に出入りする電車の本数を表す n が与えられます。
//
//・続く n 行のうちの i 行目 (1 ≦ i ≦ n) に は i 番目の電車の情報を表す f_i, t_i, s_i がこの順に半角スペース区切りで与えられます。
//　・f_i が 0 のときは i 番目の電車が上りの電車であること、1 のときは下りの電車であることを意味します。
//　・t_i, s_i は i 番目の電車の到着時刻、出発時刻をそれぞれ表す文字列で、0 埋め二桁の数字で時 = hh、分 = mmとし hh:mm 形式で与えられます。
//
//・入力は合計で n + 2 行となり、入力値最終行の末尾に改行が１つ入ります。
//
//それぞれの値は文字列で標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください



//期待する出力
//踏切の開閉時刻を以下の形式で出力してください。
//
//cl_1 - op_1
//cl_2 - op_2
//...
//cl_m - op_m
//
//・時刻表に記載される開閉時刻の組の総数を m として、期待する出力は m 行からなります。
//・出力の m 行目のうち i 行目 (1 ≦ i ≦ n) に i 番目に踏切が閉じる時刻、開く時刻をそれぞれ表す文字列 cl_i, op_i をこの順にハイフン (-) 区切りで出力してください。ただしハイフンと cl_i, op_i の間にそれぞれ半角スペースを入れてください。
//　・出力する時刻 cl_i, op_i は必ず 0 埋め二桁の数字で時 = hh、分 = mm、秒 = ssとし hh:mm:ss 形式に従うようにしてください。
//　・i < j のとき cl_i は cl_j よりも早い時刻を表すように、すなわち閉じる時刻が早いものから順に出力してください。
//・m 行目の出力の最後に改行を入れ、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//添字の範囲は 1 ≦ i ≦ n とする。
//
//・a, b, c, d, e, n は整数
//・1 ≦ a, b, c, d, e ≦ 59
//・1 ≦ n ≦ 200
//・f_i は整数値で 0, 1 のいずれか
//・s_i, t_i は半角数字およびコロン (:) で構成される文字列
//・(s_i の長さ),(t_i の長さ) = 5
//・s_i は t_i よりも1分以上遅い時刻を表す
//・上りの電車と下りの電車はそれぞれ、駅には同時に高々1台ずつしか存在しない。すなわち、上りと下りの電車合わせて2台までしか同時に駅に存在することはない
//・与えられる時刻表は、到着時刻の早いものから順に与えられ、同じ時刻の場合は上りの電車から順に与えられる
//・もっとも到着の早い電車の到着時刻は、06:00:00 より早くなることはない
//・もっとも出発の遅い電車の出発時刻は、23:59:59 より遅くなることはない


//入力例1
//3 10 15 1 2
//5
//0 06:00 06:01
//1 06:05 06:07
//0 06:10 06:11
//0 06:15 06:17
//1 06:15 06:17
//出力例1
//05:59:57 - 06:01:10
//06:04:45 - 06:05:01
//06:09:57 - 06:11:10
//06:14:45 - 06:17:10
//入力例2
//23 31 35 2 11
//4
//0 06:46 06:53
//1 09:28 09:36
//0 14:18 14:24
//1 14:40 14:41
//出力例2
//06:45:37 - 06:53:31
//09:27:25 - 09:28:02
//14:17:37 - 14:24:31
//14:39:25 - 14:40:02