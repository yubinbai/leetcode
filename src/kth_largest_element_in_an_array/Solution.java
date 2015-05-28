public class Solution {
	public int findKthLargest(int[] nums, int k) {
		return findKthLargest(nums, k, 0, nums.length - 1);
	}
	private int findKthLargest(int[] nums, int k, int low, int high) {
		int p = partition(nums, low, high);
		if (p == high - k + 1) {
			return nums[p];
		} else if (p > high - k + 1) {
			return findKthLargest(nums, k - (high - p + 1), low, p - 1);
		} else {
			return findKthLargest(nums, k, p + 1, high);
		}
	}
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
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums;
		int k;

		nums = new int[] {3, 2, 1, 5, 6, 4};
		k = 2;
		System.out.println(s.findKthLargest(nums, k));

		nums = new int[] {3, 2, 1, 5, 6, 4};
		k = 1;
		System.out.println(s.findKthLargest(nums, k));

		nums = new int[] {3, 2, 1, 5, 6, 4};
		k = 4;
		System.out.println(s.findKthLargest(nums, k));
	}
}