package Basic.Sort;

/* Heap 혹은 Binary Heap(이진 힙)이라는 자료구조로 정렬
 * 시간복잡도 – O( n log n )
 * Complete Binary Tree를 만족해야 함
 */

class Heap {
	
	int[] arr;
	int arrLength;
	
	public Heap(int[] arr) {
		this.arrLength = arr.length + 1;
		this.arr = new int[this.arrLength];
		for(int i=1; i < this.arr.length; i++) {
			this.arr[i] = arr[i-1];
		} // Init this.arr
		
		buildMaxHeap();
		for(int i=this.arr.length-1; i > 0; i--) {
			swap(1, i);
			arrLength--;
			max_Heapify(1);
		}		
	}
	
	public void max_Heapify(int i) {
		if( i*2 >= arrLength && i*2+1 >= arrLength) {
			return;
		}
		
		int leftChild = i*2;
		int rightChild = i*2 + 1;
		int largeChild;
		
		if( leftChild < arrLength && arr[leftChild] > arr[i] ) {
			largeChild = leftChild;
		} else {
			largeChild = i;
		}
		if( rightChild < arrLength && arr[rightChild] > arr[largeChild]) {
			largeChild = rightChild;
		}
		if( largeChild != i) {
			swap(i, largeChild);
			max_Heapify(largeChild);
		} else return;
	}
	
	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	private void buildMaxHeap() {
		if( arr == null || arrLength < 1) {
			return;
		}
		for(int i=arrLength/2; i > 0; i--) {
			max_Heapify(i);
		}
	}
	
	public void printArr() {
		for(int i=1; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
	}
	
	public int[] heapSort() {
		int[] arr = new int[this.arr.length-1];
		for(int i=0; i < arr.length; i++) {
			arr[i] = this.arr[i+1];
		}		
		return arr;
	}
	
}

public class HeapSort {

	public static void main(String[] args) {
		int[] arr = {7, 6, 5, 8, 4, 11, 0, 1, 3, 2, 15, 10, 14, 37, 13};
		
		Heap heap = new Heap(arr);
		int[] result;
		result = heap.heapSort();
		
		for(int i=0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for(int i=0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
