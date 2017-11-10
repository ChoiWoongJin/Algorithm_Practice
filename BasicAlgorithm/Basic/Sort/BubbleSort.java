package Basic.Sort;

/* 오름차순 정렬일 때 : 가장 큰 값을 제일 뒤로 보내는 작업을 반복
 * 시간복잡도 – O( n² )
 */

public class BubbleSort {

	public static int[] selectionSort(int[] arr) {
		int temp = 0;
		for(int i=0; i < arr.length-1; i++) {
			for(int j=i+1; j < arr.length; j++) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {29, 10, 14, 37, 13};
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		selectionSort(arr);
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}		
	}
}