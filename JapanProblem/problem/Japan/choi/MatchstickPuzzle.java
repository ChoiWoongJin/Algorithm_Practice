package problem.Japan.choi;

import java.util.*;

public class MatchstickPuzzle {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！

        Scanner sc = new Scanner(System.in);
        char[] charS = sc.next().toCharArray();
        List<String> result = new ArrayList<String>();
                
        
        
        String[][] number = new String[10][3];
        number = setNumber(number);
        
        int point = 0;
        int point2 = 0;
        char[] temp = new char[charS.length];
        temp = getAnother(temp, charS);
        String output = "";
        for(int i=0; i < charS.length; i++) {
        	for(int j=0; j < 3; j++) { // 자리수마다 3번씩 진행
        		point = charS[i] - '0'; // i번째 숫자
        		
        		for(int k=0; k < number[point][j].length(); k++) { // 자리의 숫자가 0,1,2에 맞춰 1개라도 있을 경우 진행
        			if(j == 0) { // 0일 경우, 자기 자신만 변화!
        				temp[i] = number[point][0].charAt(k); // i번째 숫자를 변경
        				output = String.valueOf(temp); // 출력값 저장 
						result.add(output);
						temp = getAnother(temp, charS); // temp 초기화
        			} else if(j == 1) {
        				for(int l=i+1; l < charS.length; l++) { //  i 이후의 값에 대해 확인
        					point2 = charS[l] - '0'; // point2는 i 이후의 l번째 자리의 숫자
    						for(int m=0; m < number[point2][2].length(); m++) { // l번째 자리의 숫자가 3차 조건 만족하는 숫자가 있을 경우
    							temp[i] = number[point][1].charAt(k); // i번째 숫자를 변경 					
    							temp[l] = number[point2][2].charAt(m); // l번째 숫자를 변경
    							output = String.valueOf(temp);
    							result.add(output);
    							temp = getAnother(temp, charS);
    						}        					
        				}
        			} else {
        				for(int l=i+1; l < charS.length; l++) { //  i 이후의 값에 대해 확인
        					point2 = charS[l] - '0';
    						for(int m=0; m < number[point2][1].length(); m++) {
    							temp[i] = number[point][2].charAt(k);        							
    							temp[l] = number[point2][1].charAt(m);
    							output = String.valueOf(temp);
    							result.add(output);
    							temp = getAnother(temp, charS);
    						}        					
        				}
        			}
        		}        		
        	}
        }
        
        Collections.sort(result);
        
        String outputTemp = "";
        if(result.size() == 0) {
        	System.out.println("none");
        } else {
	        for(int i=0; i < result.size(); i++) {
	        	outputTemp = result.get(i);
	        	System.out.println(outputTemp);
	        	
	        }
        }
        sc.close();        
    }
    
    public static char[] getAnother(char[] a, char[] b) {
    	
    	for(int i=0; i < a.length; i++) {
    		a[i] = b[i];
    	}    	
    	return a;
    }
    
    public static String[][] setNumber(String[][] number) {
    	// [][0] : 1차, [][1] : 2차. [][2] : 3차        
        // 1차 : 혼자 바뀌는것 0
        // 2차 : 1개 얻어서 바뀌는 것 +1
        // 3차 : 1개 줘서 바뀌는 것 -1
    	
    	 number[0][0] = "69";
         number[0][1] = "8";
         number[0][2] = "";
         
         number[1][0] = "";
         number[1][1] = "7";
         number[1][2] = "";
         
         number[2][0] = "3";
         number[2][1] = "";
         number[2][2] = "";         
         
         number[3][0] = "25";
         number[3][1] = "9";
         number[3][2] = "";
         
         number[4][0] = "";
         number[4][1] = "";
         number[4][2] = "";
         
         number[5][0] = "3";
         number[5][1] = "69";
         number[5][2] = "";
                  
         number[6][0] = "09";
         number[6][1] = "8";
         number[6][2] = "5";
         
         number[7][0] = "";
         number[7][1] = "";
         number[7][2] = "1";         
         
         number[8][0] = "";
         number[8][1] = "";
         number[8][2] = "069";         
         
         number[9][0] = "06";
         number[9][1] = "8";
         number[9][2] = "35";
    	
    	return number;
    }
}


//マッチ棒を使って数を作りましょう。 たとえば 0 から 9 をマッチ棒で作ると次の図のようになります。
//
//
//
//今、あなたの前にはマッチ棒で作られた数が 1 つあります。
//この数からマッチ棒をちょうど 1 本だけ移動させて (つまり、マッチ棒を 1 本取り除いて、それを別の位置に置くことで) 作ることができる数をすべて求めてください。
//ただし、上の図にある 0 から 9 を並べてできる数のみを考えることとし、マッチ棒をマイナス符号の代わりにするなどはできないものとします。
//
//たとえば、16 からマッチ棒をちょうど 1 本だけ移動させることで 10, 19, 75 の 3 種類の数を作ることができます。


//入力される値
//入力は以下のフォーマットで与えられます。
//
//s
//
//s はマッチ棒で作られた数を表す文字列
//
//入力値最終行の末尾に改行が１つ入ります。
//文字列は標準入力から渡されます。標準入力からの値取得方法はこちらをご確認ください


//期待する出力
//入力された数に対して、マッチ棒をちょうど 1 本だけ動かして作る事ができる数を小さい順に改行区切りで出力してください。 
//ただし、出力する数の先頭が 0 の場合には、先頭の 0 を省略せずに出力してください。
//
//また、そのような数が 1 つもない場合は "none" と出力してください。 
//
//最後は改行し、余計な文字、空行を含んではいけません。


//条件
//すべてのテストケースで以下の条件を満たします。
//
//・1 ≦ (s の長さ) ≦ 10
//・s は '0', '1', ..., '9' からなる文字列


//入力例1
//16
//出力例1
//10
//19
//75
//入力例2
//01234567
//出力例2
//01224567
//01234367
//01234507
//01234581
//01234597
//01234657
//01234661
//01234957
//01234961
//01254567
//01294557
//01294561
//01334567
//07234557
//07234561
//61234567
//81234557
//81234561
//91234567
//入力例3
//888
//出力例3
//none