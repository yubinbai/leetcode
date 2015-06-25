public class Solution {
    public int romanToInt(String s) {
        int ret = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            switch (s.charAt(i)) {
                case 'I':
                    ret += (ret < 5) ? 1 : -1;
                    break;
                case 'V':
                    ret += (ret >= 10) ? -5 : 5;
                    break;
                case 'X':
                    ret += (ret >= 50) ? -10 : 10;
                    break;
                case 'L':
                    ret += (ret >= 100) ? -50 : 50;
                    break;
                case 'C':
                    ret += (ret >= 500) ? -100 : 100;
                    break;
                case 'D':
                    ret += 500;
                    break;
                case 'M':
                    ret += 1000;
                    break;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.romanToInt("IV"));
        System.out.println(s.romanToInt("VI"));
        System.out.println(s.romanToInt("XCIX"));
        System.out.println(s.romanToInt("MMMCMXCIX"));
    }
}