package Basic.Sort;

/* 빠른 정렬(Quick Sort)
 *  ⚫ 분할 : 배열을 다음과 같은 조건이 만족되도록 두 부분으로 나눈다
                          ( 기준 값(pivot)보다 작은 값과 큰 값으로 구분 )
 *  ⚫ 정복 : 각 부분을 순환적으로 정렬
 *  ⚫ 병합 : nothing to do
 * 시간복잡도 – O( nlogn )
 * Pivot의 선택 : right
 */

public class QuickSort {

	public static void quickSort(int[] arr, int p, int r) {
		if( p < r ) {
			int q = partition(arr, p, r); // 분할
			quickSort(arr, p, q-1); // 왼쪽 부분배열 정렬
			quickSort(arr, q+1, r); // 오른쪽 부분배열 정렬
		}	
	}
	public static int partition(int[] arr, int p, int r) {
//		배열 arr[p...r]의 원소들을 arr[r]을 기준으로 양쪽으로 재배치하고
//       arr[r]이 자리한 위치를 return 한다;
		int x = arr[r];
		int i = p-1;
		int temp;
		for(int j=p; j <= r; j++) {
			if(arr[j] <= x && j != r ) { // 피벗값을 바꿀 필요는 없음
				i++;
				temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		temp = arr[i+1];
		arr[i+1] = arr[r];
		arr[r] = temp;

		return i+1;
	}
	public static void main(String[] args) {
		
		int[] arr = {7, 6, 5, 8, 4, 11, 0, 1, 3, 2, 15, 10, 14, 37, 13};
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		quickSort(arr, 0, arr.length-1);		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}		
	}

}
