package Basic.Sort;

/* 오름차순 정렬일 때 : 1부터 시작하여 n까지 순차적으로 정렬해 나간다
 * 시간복잡도 – O( n² )
 */

public class InsertionSort {
	public static int[] insertionSort(int[] arr) {
		int temp = 0, tempPoint = 0;
		for(int i=1; i < arr.length; i++) {
			tempPoint = i;
			for(int j=i-1; j >= 0; j--) {
				if(arr[tempPoint] < arr[j]) {
					temp = arr[tempPoint];
					arr[tempPoint] = arr[j];
					arr[j] = temp;
					tempPoint = j;
				} else {
					break;
				}
			}
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
		
		insertionSort(arr);		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}		
	}
}