import java.util.*;

class Solution {

	int partition(int a[], int l, int h) {
		int x = a[h];
		int i = (l - 1);

		for (int j = l; j < h; j++) {
			if (a[j] < x) {
				i++;
				swap(a, i, j);
			}
		}
		swap(a, i + 1, h);
		return (i + 1);
	}
	void swap(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	void quickSortIterative(int a[], int low, int high) {
		Stack<Integer> stack = new Stack<Integer>();

		stack.push(low);
		stack.push(high);

		while ( !stack.isEmpty() ) {
			high = stack.pop();
			low = stack.pop();

			int p = partition( a, low, high );

			if ( p - 1 > low ) {
				stack.push(low);
				stack.push(p - 1);
			}

			if ( p + 1 < high ) {
				stack.push(p + 1);
				stack.push(high);
			}
		}
	}
	public static void main(String[] args) {
		int n = 10;
		Random r = new Random();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt(1000);
		}
		Solution s = new Solution();
		s.quickSortIterative(arr, 0, arr.length - 1);
		for (int i : arr) System.out.format("%d\t", i);
	}
}