import java.util.*;
public class Solution {
    public List<Integer> findSubstring(String s, String[] L) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        int n = L.length;
        int w = L[0].length();
        for (int pos = 0; pos <= s.length() - w * n; pos++) {
            HashMap<String, Integer> strCount = new HashMap<String, Integer>();
            for (String str : L) {
                Integer currCount = strCount.get(str);
                strCount.put(str, currCount == null ? 1 : currCount + 1);
            }
            int step = 0;
            for (; step < n; step++) {
                String sub = s.substring(pos + w * step, pos + w + w * step);
                Integer currCount = strCount.get(sub);
                if (currCount != null && currCount > 0) {
                    strCount.put(sub, currCount - 1);
                } else {
                    break;
                }
            }
            if (step == n) ret.add(pos);
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        String s;
        String[] l;
        s = "barfoothefoobarman";
        l = new String[] {"foo", "bar"};
        System.out.println(sol.findSubstring(s, l));

        s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        l = new String[] {"fooo", "barr", "wing", "ding", "wing"};
        System.out.println(sol.findSubstring(s, l));

        s = "a";
        l = new String[] {"a"};
        System.out.println(sol.findSubstring(s, l));

        s = "aaa";
        l = new String[] {"a", "a"};
        System.out.println(sol.findSubstring(s, l));

        s = "mississippi";
        l = new String[] {"is"};
        System.out.println(sol.findSubstring(s, l));
    }
}