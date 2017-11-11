package Basic.Sort;

/* 오름차순 정렬일 때 : 가장 큰 값을 제일 뒤로 보내는 작업을 반복
 * 시간복잡도 – O( n² )
 */

public class SelectionSort {

	public static int[] selectionSort(int[] arr) {
		int max = 0, temp = 0;
		for(int i=0; i < arr.length-1; i++) {
			max = 0;
			for(int j=0; j < arr.length-i; j++) {
				if(arr[max] < arr[j]) max = j;
			}
			temp = arr[max];
			arr[max] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		return arr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7, 6, 5, 8, 4, 11, 0, 1, 3, 2, 15, 10, 14, 37, 13};
		
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
