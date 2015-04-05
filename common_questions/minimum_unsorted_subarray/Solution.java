class Solution {
	public void printUnsorted(int arr[]) {
		int n = arr.length;
		int s = 0, e = n - 1, i, max, min;

		for (s = 0; s < n - 1; s++) {
			if (arr[s] > arr[s + 1]) break;
		}
		if (s == n - 1) {
			System.out.println("The complete array is sorted");
			return;
		}

		for (e = n - 1; e > 0; e--) {
			if (arr[e] < arr[e - 1]) break;
		}

		// find min and max in region
		max = arr[s]; min = arr[s];
		for (i = s + 1; i <= e; i++) {
			if (arr[i] > max) max = arr[i];
			if (arr[i] < min) min = arr[i];
		}

		for (i = 0; i < s; i++) {
			if (arr[i] > min) {
				s = i;
				break;
			}
		}

		for (i = n - 1; i >= e + 1; i--) {
			if (arr[i] < max) {
				e = i;
				break;
			}
		}

		System.out.format("Unsorted subarray [%d, %d]\n", s, e);
	}
	public static void main(String[] args) {
		int[] arr;
		Solution s = new Solution();

		arr = new int[] {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};
		s.printUnsorted(arr);

		arr = new int[] {0, 1, 15, 25, 6, 7, 30, 40, 50};
		s.printUnsorted(arr);
	}
}