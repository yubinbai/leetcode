import java.util.*;
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> ret = new ArrayList<String>();
        StringBuilder sb;
        int n = s.length();
        if (n > 12) return ret;
        for (int i = 1; i < n; i++) {
            if (!validPiece(s.substring(0, i))) continue;
            for (int j = i + 1; j < n; j++) {
                if (!validPiece(s.substring(i, j))) continue;
                for (int k = j + 1; k < n; k++) {
                    if (!validPiece(s.substring(j, k))) continue;
                    if (!validPiece(s.substring(k, n))) continue;
                    sb = new StringBuilder();
                    sb.append(s.substring(0, i));
                    sb.append('.');
                    sb.append(s.substring(i, j));
                    sb.append('.');
                    sb.append(s.substring(j, k));
                    sb.append('.');
                    sb.append(s.substring(k, n));
                    ret.add(sb.toString());
                }
            }
        }
        return ret;
    }
    public boolean validPiece(String s) {
        int n = s.length();
        if (n > 3) return false;
        if (Integer.parseInt(s) > 255) return false;
        if (n > 1 && s.charAt(0) == '0') return false;
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String ip = "010010";
        for (String str : s.restoreIpAddresses(ip)) {
            System.out.println(str);
        }
    }
}