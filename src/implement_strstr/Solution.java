public class Solution {
    public String strStr(String haystack, String needle) {

        int needleLen = needle.length();
        int haystackLen = haystack.length();

        if (needleLen == haystackLen && needleLen == 0)
            return "";

        if (needleLen == 0)
            return haystack;

        for (int i = 0; i < haystackLen; i++) {
            // make sure in boundary of needle
            if (haystackLen - i + 1 < needleLen)
                return null;

            int k = i;
            int j = 0;

            while (j < needleLen && k < haystackLen && needle.charAt(j) == haystack.charAt(k)) {
                j++;
                k++;
                if (j == needleLen)
                    return haystack.substring(i);
            }

        }

        return null;
    }

}