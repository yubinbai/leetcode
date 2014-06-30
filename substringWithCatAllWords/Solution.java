import java.util.*;
public class Solution {
    int n, w;
    int[] used;
    String s;
    HashMap<String, Integer> mapBackup = new HashMap<String, Integer>();
    public List<Integer> findSubstring(String S, String[] L) {
        this.s = S;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        n = L.length;
        w = L[0].length();
        for (int i = 0; i < n; i++) {
            Integer slot = mapBackup.get(L[i]);
            mapBackup.put(L[i], slot == null ? 1 : slot + 1);
        }
        int totalLen = w * n;
        for (int pos = 0; pos <= S.length() - totalLen; pos++) {
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (String s : mapBackup.keySet()) {
                map.put(s, mapBackup.get(s));
            }
            int step = 0;
            for (; step < n; step++) {
                String sub = s.substring(pos + w * step, pos + w + w * step);
                Integer slot = map.get(sub);
                if (slot != null && slot > 0) {
                    map.put(sub, slot - 1);
                } else {
                    break;
                }
            }
            if (step == n) ret.add(pos);
        }
        return ret;
    }
    public static void main(String[] args) {
        // String s = "barfoothefoobarman";
        // String[] l = {"foo", "bar"};
        // String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        // String[] l = {"fooo", "barr", "wing", "ding", "wing"};
        // String s = "a";
        // String[] l = {"a"};
        String s = "aaa";
        String[] l = {"a", "a"};
        // String s = "mississippi";
        // String[] l = {"is"};
        Solution sol = new Solution();
        System.out.println(sol.findSubstring(s, l));
    }
}