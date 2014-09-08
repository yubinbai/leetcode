import java.util.*;
public class Solution {
    int n, w;
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
        Solution sol = new Solution();
        String s;
        String[] l;
        s = "barfoothefoobarman";
        l = new String[]{"foo", "bar"};
        System.out.println(sol.findSubstring(s, l));

        s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        l = new String[]{"fooo", "barr", "wing", "ding", "wing"};
        System.out.println(sol.findSubstring(s, l));

        s = "a";
        l = new String[]{"a"};
        System.out.println(sol.findSubstring(s, l));

        s = "aaa";
        l = new String[]{"a", "a"};
        System.out.println(sol.findSubstring(s, l));

        s = "mississippi";
        l = new String[]{"is"};
        System.out.println(sol.findSubstring(s, l));
    }
}