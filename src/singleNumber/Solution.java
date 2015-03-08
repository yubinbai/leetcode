public class Solution {
    public int singleNumber(int[] A) {
        int ret = 0;
        for (int a : A) {
        	ret ^= a;
        }
        return ret;
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	System.out.println(s.singleNumber(new int[] {1,1,2}));
    }
}