package problem.Japan.choi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ExtractionLog {
	private String[] searchIP;
	private int logNum;
	private String[] logInfo;
	private List<String> resultLog; 
	
	ExtractionLog(String searchIP, int logNum, String[] logInfo) {
		this.searchIP = searchIP.split("\\.");
		this.logNum = logNum;
		this.logInfo = logInfo.clone();
		this.resultLog = new ArrayList<>();
		
		this.checkLogFile();
	}
	
	private void checkLogFile() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i < logNum; i++) {		
			String[] ipCheck = this.logInfo[i].split(" - - ");
			if(checkIP(ipCheck[0].split("\\."))) {
				sb.setLength(0);
				sb.append(ipCheck[0]).append(" ");
				String[] getOthers = ipCheck[1].split(" +");
				sb.append(getOthers[0].substring(1)).append(" ").append(getOthers[3]);
				this.resultLog.add(sb.toString());
			}
		}
	}
	private boolean checkIP(String[] IP) {
		if(!this.searchIP[0].equals(IP[0]))
			return false;
		if(!this.searchIP[1].equals(IP[1]))
			return false;
		if(this.searchIP[2].substring(0, 1).equals("[")) {
			String[] ipRange = this.searchIP[2].substring(1, this.searchIP[2].length()-1).split("-");
			if(Integer.parseInt(IP[2]) < Integer.parseInt(ipRange[0]) || Integer.parseInt(IP[2]) > Integer.parseInt(ipRange[1]) ) {
				return false;
			}
		} else if(!this.searchIP[2].substring(0, 1).equals("*")) {
			if(!this.searchIP[2].equals(IP[2]))
				return false;
		}
		if(this.searchIP[3].substring(0, 1).equals("[")) {
			String[] ipRange = this.searchIP[3].substring(1, this.searchIP[3].length()-1).split("-");
			if(Integer.parseInt(IP[3]) < Integer.parseInt(ipRange[0]) || Integer.parseInt(IP[3]) > Integer.parseInt(ipRange[1]) ) {
				return false;
			}
		} else if(!this.searchIP[3].substring(0, 1).equals("*")) {
			if(!this.searchIP[3].equals(IP[3]))
				return false;
		}
		
		return true;
	}
	
	public void printResultLog() {		
		for(int i=0; i < this.resultLog.size(); i++) {
			System.out.println(this.resultLog.get(i));
		}
	}
}

public class ExtractionLogFile {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String searchIP = sc.next();
		int logNum = sc.nextInt();
		String[] logInfo = new String[logNum];
		sc.nextLine();
		for(int i=0; i < logNum; i++) {
			logInfo[i] = sc.nextLine();
		}
		
		ExtractionLog el = new ExtractionLog(searchIP, logNum, logInfo);
		el.printResultLog();
		
		sc.close();
	}

}


//あなたは管理しているサーバーのアクセスログから、特定のIPのアクセスを抽出しようとしています。
//IPアドレスを指定する書式の例は以下のようになっており、IPv4のみを対象としています。
//※ # 以降はコメントです。
//192.168.0.1 #192.168.0.1のみを対象
//192.168.0.[10-20] #192.168.0.10~192.168.0.20の範囲を対象
//192.168.[1-2].[10-20] #192.168.1.10~192.168.1.20と192.168.2.10~192.168.2.20の範囲を対象
//192.168.0.* #192.168.0.0~192.168.0.255の範囲を対象
//192.168.*.* #192.168.0.0~192.168.255.255の範囲を対象
//　#*は[0-255]と等価
//IPアドレスは「.」で区切られて左から第1.第2.第3.第4オクテットと呼ばれます。
//範囲指定ができるのは第3、第4オクテットまでとします。
//Apacheのログが以下のような書式であります。ログは上から古い順に記録されているとします。
//「IPアドレス identユーザー名 認証ユーザー名 [アクセス日時] "リクエストヘッダ ファイル名 プロトコル" ステータスコード 転送されたバイト数 呼び出し元URL ブラウザ情報等」
//IPアドレス
//identユーザー名
//認証ユーザー名
//[アクセス日時]
//"リクエストヘッダ ファイル名 プロトコル"
//ステータスコード
//転送されたバイト数
//呼び出し元URL
//ブラウザ情報等
//※半角スペース区切り
//
//101.80.23.49 - - [08/Jul/2013:16:55:14 +0900] "GET /index.html HTTP/1.1" 200 12345 "http://google.com" "safari"
//51.185.9.25 - - [08/Jul/2013:17:05:10 +0900] "GET / HTTP/1.1" 200 12345 "http://google.com" "chrome"
//……
//日付のフォーマットは[日付/月/西暦4桁:時:分:秒 タイムゾーン]で入力されます。
//各値は0詰めされてるとします。
//月の表記はそれぞれ1月から順に以下のように記録されています。
//
//Jan,Feb,Mar,Apr,May,Jun,Jul,Aug,Sep,Oct,Nov,Dec
//……
//抽出対象のIPアドレスの指定、入力されるログの行数、ログの入力から対象のアクセスを抽出し、
//IPアドレス、タイムゾーンの指定を除外した日付、ファイル名をスペース区切りで
//出力するプログラムを作成してください。


//入力される値
//1行目に検索条件として、IPアドレスが入力されます。範囲指定も可能で第3、第4オクテットは* (0から255全て)、[S-E] (SからEまで)で指定することが可能です。
//2行目には入力されるログの行数Nが入力されます。
//3行目以降には2行目で入力された行数分のApacheのログが入力されます。ログ１行の長さMは500文字以内とします。


//期待する出力
//入力されたIPアドレスの範囲のIPアドレスを入力されたログから抽出し、IPアドレス、日付(+9000等のタイムゾーンの表記なし)、ファイル名をスペース区切りで日付の古い順に出力してください。
//192.168.186.70 10/Jul/2013:18:52:12 /top.html


//条件
//IPアドレスはIPv4の0.0.0.0から255.255.255.255までとします。
//予約アドレス等の特殊なアドレスの入力に関しては考慮しなくてよいものとします。
//最大で192.168.*.*のような入力の場合192.168.0.0~192.168.255.255の
//65536アドレスを対象とする場合があります。
//S < E
//0 ≦ S,E ≦ 255
//1 ≦ N ≦ 1000
//M ≦ 500


//入力例
//192.168.186.70
//3
//192.168.110.238 - - [10/Jul/2013:18:40:43 +0900] "GET /top.html HTTP/1.1" 404 8922 "http://gi-no.jp" "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116 Safari/537.36"
//192.168.186.70 - - [10/Jul/2013:18:52:12 +0900] "GET /top.html HTTP/1.1" 404 3628 "http://facebook.com" "Mozilla/5.0 (Windows NT 5.1; rv:22.0) Gecko/20100101 Firefox/22.0"
//192.168.105.56 - - [10/Jul/2013:20:13:52 +0900] "GET /top.html HTTP/1.1" 200 1863 "http://paiza.jp" "Mozilla/5.0 (iPad; CPU OS 6_0_1 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) Version/6.0 Mobile/10A523 Safari/8536.25"
//出力例
//192.168.186.70 10/Jul/2013:18:52:12 /top.html
//入力例2
//192.168.[0-100].*
//3
//192.168.99.112 - - [10/Jul/2013:13:53:15 +0900] "GET /top.html HTTP/1.1" 404 1426 "http://facebook.com" "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116 Safari/537.36"
//192.168.81.20 - - [10/Jul/2013:15:06:33 +0900] "GET /hogehoge.html HTTP/1.1" 404 4374 "http://paiza.jp" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/27.0.1453.116 Safari/537.36"
//192.168.223.58 - - [10/Jul/2013:21:32:01 +0900] "GET /hoge.html HTTP/1.1" 304 6601 "http://paiza.jp" "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:22.0) Gecko/20100101 Firefox/22.0"
//出力例2
//192.168.99.112 10/Jul/2013:13:53:15 /top.html
//192.168.81.20 10/Jul/2013:15:06:33 /hogehoge.html