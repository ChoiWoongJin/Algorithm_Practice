package problem.Korea.codingdojang;


//어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.
//
//예를 들어
//
//d(91) = 9 + 1 + 91 = 101
//이 때, n을 d(n)의 제네레이터(generator)라고 한다. 위의 예에서 91은 101의 제네레이터이다.
//
//어떤 숫자들은 하나 이상의 제네레이터를 가지고 있는데, 101의 제네레이터는 91 뿐 아니라 100도 있다. 그런데 반대로, 제네레이터가 없는 숫자들도 있으며, 이런 숫자를 인도의 수학자 Kaprekar가 셀프 넘버(self-number)라 이름 붙였다. 예를 들어 1,3,5,7,9,20,31 은 셀프 넘버 들이다.
//
//1 이상이고 5000 보다 작은 모든 셀프 넘버들의 합을 구하라.

public class NexonTest {
	
	public static int selfNumberSum(int input) {
		int result = 0, i = 0, num_i = 0;
		int generatorCheck = 0;
		int[] selfNumber = new int[input];
		
		for(i=0; i<input; i++) {
			selfNumber[i] = 0;
		} // 셀프 넘버 일 경우 0으로 남도록 한다
		
		for(i=1; i<=input; i++) {
			num_i = i;
			generatorCheck = num_i; // 제너레이터를 통해 만들어지는 숫자를 저장. 최초로 자신을 더하도록 한다
			while(num_i != 0) { // 각 자릿수를 더하도록 한다
				generatorCheck += num_i%10;
				num_i /= 10;			
			}
			if(generatorCheck <= input) {
				selfNumber[generatorCheck-1] = 1;
			}
		} // 제너레이터가 있는 숫자일 경우 1로 바꾸도록 한다
		
		for(i=0; i<input; i++) {
			if(selfNumber[i] == 0) {
				result += i+1;
			}
		} // 0이 담겨져 있는 숫자의 경우 셀프 넘버이므로 이 숫자를 result에 더하도록 한다
		
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(selfNumberSum(5000));

	}

}
