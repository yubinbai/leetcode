import java.util.*;

class IterativeMergeSort {
	public void mergeSort(int[] arr) {
		int n = arr.length;
		// Merge subarrays in bottom up manner.  First merge subarrays of
		// size 1 to create sorted subarrays of size 2, then merge subarrays
		// of size 2 to create sorted subarrays of size 4, and so on.
		for (int size = 1; size <= n - 1; size = 2 * size) {
			for (int low = 0; low < n - 1; low += 2 * size) {
				int mid = low + size - 1;
				if (mid >= n - 1) continue;
				int high = Math.min(low + 2 * size - 1, n - 1);
				merge(arr, low, mid, high);
			}
		}
	}
	/* Function to merge the two haves arr[l..m] and arr[m+1..r] of array arr[] */
	private void merge(int[] arr, int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 =  r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		for (i = 0; i < n1; i++) L[i] = arr[l + i];
		for (j = 0; j < n2; j++) R[j] = arr[m + 1 + j];

		i = 0;
		j = 0;
		k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy the remaining elements of L[], if there are any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy the remaining elements of R[], if there are any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {
		int n = 21;
		Random r = new Random();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = r.nextInt(1000);
		}
		IterativeMergeSort ims = new IterativeMergeSort();
		ims.mergeSort(arr);
		for (int i : arr) System.out.format("%d\t", i);
	}

}