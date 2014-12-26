import java.util.*;
public class Solution {
    ArrayList<String> ret;
    int L;
    public List<String> fullJustify(String[] words, int L) {
        this.L = L;
        ret = new ArrayList<String>();
        ArrayList<String> currList = new ArrayList<String>();
        int curr = 0;
        for (String s : words) {
            if (curr == 0) {
                curr += s.length();
                currList.add(s);
            } else {
                if (curr + 1 + s.length() <= L) {
                    curr += 1 + s.length();
                    currList.add(s);
                } else {
                    ret.add(construct(currList));
                    curr = s.length();
                    currList = new ArrayList<String>();
                    currList.add(s);
                }
            }
        }
        if (!currList.isEmpty()) ret.add(constructLast(currList));
        return ret;
    }
    public String construct(ArrayList<String> list) {
        int totalLen = 0;
        for (String s : list) {
            totalLen += s.length();
        }
        int blanks = L - totalLen;
        int size = list.size();
        int extra = (size <= 1) ? 0 : (blanks) % (size - 1);
        int width = (size <= 1) ? 0 : (blanks) / (size - 1);

        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i = 1; i < size; i++) {
            if (extra > 0) {
                sb.append(" ");
                extra--;
            }
            for (int j = 0; j < width; j++) {
                sb.append(" ");
            }
            sb.append(list.get(i));
        }
        while (sb.length() < L) {
            sb.append(" ");
        }
        return sb.toString();
    }
    public String constructLast(ArrayList<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
            sb.append(" ");
        }

        while (sb.length() < L) {
            sb.append(" ");
        }
        return sb.substring(0, L);
    }

    public static void main(String[] args) {
        // String[] data = {"What", "must", "be", "shall", "be."};
        // String[] data = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] data = {""};
        Solution sol = new Solution();
        for (String s : sol.fullJustify(data, 0)) {
            System.out.format("\"%s\"", s);
        }
    }
}