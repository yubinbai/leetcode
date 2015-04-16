import java.util.*;
class Solution {
    public List<Long> getUntil(int n) {
        ArrayList<Long> a = new ArrayList<Long>();
        a.add(1L);
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 3; i < n; i++) {
            long prev = a.get(a.size() - 1);
            while (p2 + 1 < a.size() && a.get(p2) * 2 <= prev) {
                p2++;
            }
            while (p3 + 1 < a.size() && a.get(p3) * 3 <= prev) {
                p3++;
            }
            while (p5 + 1 < a.size() && a.get(p5) * 5 <= prev) {
                p5++;
            }
            long next = Math.min(a.get(p2) * 2, a.get(p3) * 3);
            next = Math.min(a.get(p5) * 5, next);
            a.add(next);
        } 
        return a;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getUntil(100));
        // s.getUntil(10000000);
    }
}