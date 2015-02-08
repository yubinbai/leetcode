import java.util.*;
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<Integer> seen = new HashSet<Integer>();
        HashSet<Integer> duplicate = new HashSet<Integer>();
        for (int i = 0; i <= s.length() - 10; ++i) {
            String sub = s.substring(i, i + 10);
            int subI = seqToInt(sub);
            if (!seen.contains(subI)) {
                seen.add(subI);
            } else {
                duplicate.add(subI);
            }
        }
        ArrayList<String> ret = new ArrayList<String>();
        for (int i : duplicate) {
            ret.add(intToSeq(i));
        }
        return ret;
    }
    public int seqToInt(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); ++i) {
            ret <<= 2;
            switch (s.charAt(i)) {
            case 'A':
                ret |= 0;
                break;
            case 'G':
                ret |= 1;
                break;
            case 'C':
                ret |= 2;
                break;
            case 'T':
                ret |= 3;
                break;
            }
        }
        return ret;
    }
    public String intToSeq(int subI) {
        char[] c = new char[10];
        for (int i = 9; i >= 0; --i) {
            int last = subI & 3;
            switch (last) {
            case 0:
                c[i] = 'A';
                break;
            case 1:
                c[i] = 'G';
                break;
            case 2:
                c[i] = 'C';
                break;
            case 3:
                c[i] = 'T';
                break;
            }
            subI >>= 2;
        }
        return new String(c);
    }
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        // String s = "GAGAGAGAGAGA";
        Solution sol = new Solution();
        System.out.println(sol.findRepeatedDnaSequences(s));
    }
}