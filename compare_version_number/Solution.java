import java.util.*;
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int ret = 0;
        for (int i = 0; i < Math.min(v1.length, v2.length); ++i) {
            int a = Integer.parseInt(v1[i]);
            int b = Integer.parseInt(v2[i]);
            ret = Integer.compare(a, b);
            if (ret != 0) return ret;
        }
        if (v1.length == v2.length) {
            return 0;
        } else if (v1.length > v2.length) {
            for (int i = v2.length; i < v1.length; ++i) {
                if (Integer.parseInt(v1[i]) != 0) return 1;
            }
            return 0;
        } else {
            for (int i = v1.length; i < v2.length; ++i) {
                if (Integer.parseInt(v2[i]) != 0) return -1;
            }
            return 0;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.format("%d\n", s.compareVersion("0.1", "1.0"));
        System.out.format("%d\n", s.compareVersion("1.2", "1.2.1"));
        System.out.format("%d\n", s.compareVersion("01", "1"));
        System.out.format("%d\n", s.compareVersion("1.0", "1"));
    }
}