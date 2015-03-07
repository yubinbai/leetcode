public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = 0;
        for (int i = 0; i < 32; ++i) {
            int curr = 1 & n;
            ret <<= 1;
            ret |= curr;
            n >>= 1;
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseBits(2));
        System.out.println(s.reverseBits(43261596));
    }
}