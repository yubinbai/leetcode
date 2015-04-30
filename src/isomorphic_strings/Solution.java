import java.util.*;
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);
            if (map.containsKey(ss) && tt != map.get(ss)) {
                return false;
            } else if (map2.containsKey(tt) && ss != map2.get(tt)) {
                return false;
            } else {
                map.put(ss, tt);
                map2.put(tt, ss);
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("egg", "abb"));
        System.out.println(s.isIsomorphic("aba", "baa"));
        System.out.println(s.isIsomorphic("ab", "aa"));
    }
}