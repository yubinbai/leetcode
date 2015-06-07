import java.util.*;

public class Solution {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeMap<Long, Long> map = new TreeMap<Long, Long>();
		ArrayDeque<Long> q  = new ArrayDeque<Long>();
		for (int i : nums) {
			long ii = i;
			Long ceil = map.ceilingKey(ii);
			if (ceil != null && ceil - ii <= t) return true;
			Long floor = map.floorKey(ii);
			if (floor != null && ii - floor <= t) return true;
			if (k != 0 && map.size() == k) {
				map.remove(q.pollFirst());
			}
			if (k != 0) {
				map.put(ii, 1L);
				q.add(ii);
			}
		}
		return false;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums;
		int k, t;

		nums = new int[] {1, 2, 3};
		k = 2;
		t = 1;
		System.out.println(s.containsNearbyAlmostDuplicate(nums, k, t));

		nums = new int[] {1, 3, 5};
		k = 2;
		t = 1;
		System.out.println(s.containsNearbyAlmostDuplicate(nums, k, t));

		nums = new int[] {0};
		k = 0;
		t = 0;
		System.out.println(s.containsNearbyAlmostDuplicate(nums, k, t));

		nums = new int[] {1, 2};
		k = 0;
		t = 1;
		System.out.println(s.containsNearbyAlmostDuplicate(nums, k, t));
	}
}