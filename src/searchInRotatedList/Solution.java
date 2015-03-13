public class Solution {
    public boolean search(int[] A, int target) {
    	int left = 0, right = A.length - 1;
    	while (left <= right) {
    		int mid = left + (right - left) / 2;
    		if (target == A[mid]) {
    			return true;
    		}
    		if (A[left] < A[mid]) {
    			if (target >= A[left] && target < A[mid]) {
    				right = mid - 1;
    			} else {
    				left = mid + 1;
    			}
    		} else if (A[left] > A[mid]) {
    			if (target > A[mid] && target <= A[right]) {
    				left = mid + 1;
    			} else {
    				right = mid - 1;
    			}
    		} else {
    			left++;
    		}
    	}
    	return false;
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] data = new int[] {1, 3, 1, 1, 1};
    	System.out.println(s.search(data, 2));
    	System.out.println(s.search(data, 1));
    }
}