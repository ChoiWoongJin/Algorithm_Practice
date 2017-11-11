package Basic.Sort;

/* 분할정복법 ( Divide and Conquer )
 *  ⚫ 분할 : 해결하고자 하는 문제를 작은 크기의 동일한 문제들로 분할
 *  ⚫ 정복 : 각각의 작은 문제를 순환적으로 해결
 *  ⚫ 병합 : 작은 문제의 해를 합하여 ( merge ) 원래 문제에 대한 해를 구함
 * 시간복잡도 – O( nlogn )
 */

public class MergeSort {
	public static void mergeSort(int[] arr, int p, int r) {
		if( p < r ) {
			int q = (p+r)/2;
			mergeSort(arr, p, q);
			mergeSort(arr, q+1, r);
			merge(arr, p, q, r);
		}	
	}
	public static void merge(int[] arr, int p, int q, int r) {
		int i=p, j=q+1, k=p;
		int[] temp = arr.clone();
		
		while( i <= q && j <= r) {
			if( arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		while(i <= q) {
			temp[k++] = arr[i++];
		}
		while(j <= r) {
			temp[k++] = arr[j++];
		}
		
		for(i=p; i <= r; i++) {
			arr[i] = temp[i];
		}
	}
	public static void main(String[] args) {
		
		int[] arr = {7, 6, 5, 8, 4, 11, 0, 1, 3, 2, 15, 10, 14, 37, 13};
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
		mergeSort(arr, 0, arr.length-1);		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}		
	}
}