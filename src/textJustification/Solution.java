import java.util.*;
public class Solution {
    ArrayList<String> result, currList;
    int L;
    public List<String> fullJustify(String[] words, int L) {
        this.L = L;
        result = new ArrayList<String>();
        currList = new ArrayList<String>();
        int currLen = 0;
        for (String s : words) {
            if (currLen == 0) {
                currLen += s.length();
                currList.add(s);
            } else {
                if (currLen + s.length() + currList.size() <= L) {
                    currLen += s.length();
                    currList.add(s);
                } else {
                    result.add(construct(currLen));
                    currLen = s.length();
                    currList.clear();
                    currList.add(s);
                }
            }
        }
        if (!currList.isEmpty()) result.add(constructLast());
        return result;
    }
    private String construct(int totalLen) {
        int blanks = L - totalLen;
        int size = currList.size();
        int extra = (size <= 1) ? 0 : (blanks) % (size - 1);
        int width = (size <= 1) ? 0 : (blanks) / (size - 1);

        StringBuilder sb = new StringBuilder();
        sb.append(currList.get(0));
        for (int i = 1; i < size; i++) {
            if (extra > 0) {
                sb.append(" ");
                extra--;
            }
            for (int j = 0; j < width; j++) {
                sb.append(" ");
            }
            sb.append(currList.get(i));
        }
        while (sb.length() < L) {
            sb.append(" ");
        }
        return sb.toString();
    }
    private String constructLast() {
        StringBuilder sb = new StringBuilder();
        for (String s : currList) {
            sb.append(s);
            sb.append(" ");
        }
        while (sb.length() < L) {
            sb.append(" ");
        }
        return sb.substring(0, L);
    }

    public static void main(String[] args) {
        String[] data;
        Solution sol = new Solution();
        data = new String[] {"What", "must", "be", "shall", "be."};
        for (String s : sol.fullJustify(data, 10)) {
            System.out.format("__%s__\n", s);
        }

        data = new String[] {"This", "is", "an", "example", "of", "text", "justification."};
        for (String s : sol.fullJustify(data, 20)) {
            System.out.format("__%s__\n", s);
        }

        data = new String[] {""};
        for (String s : sol.fullJustify(data, 0)) {
            System.out.format("__%s__\n", s);
        }
    }
}