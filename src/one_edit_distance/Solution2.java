import java.util.*;
public class Solution2 {
    public boolean isOneEditDistance(String s, String t) {
        ArrayList<Character> iters = new ArrayList<Character>();
        for (char c : s.toCharArray()) {
            iters.add(c);
        }
        ArrayList<Character> itert = new ArrayList<Character>();
        for (char c : t.toCharArray()) {
            itert.add(c);
        }
        return isOneEditDistance(iters.iterator(), itert.iterator());
    }
    public boolean isOneEditDistance(Iterator<Character> s, Iterator<Character> t) {
        char currS = 0, currT = 0, prevS = 0, prevT = 0;
        boolean noDiff = true, canChange = true, canRemove = true, canInsert = true;
        while (s.hasNext() && t.hasNext()) {
            prevS = currS; currS = s.next();
            prevT = currT; currT = t.next();
            if (noDiff) {
                if (currS != currT) noDiff = false;
            } else {
                if (canChange) canChange = (currS == currT);
                if (canInsert) canInsert = (prevS == currT);
                if (canRemove) canRemove = (currS == prevT);
                if (!canChange && !canInsert && !canRemove) return false;
            }
        }
        if (noDiff) {
            if (s.hasNext()) {
                s.next();
                return !s.hasNext();
            } else if (t.hasNext()) {
                t.next();
                return !t.hasNext();
            } else {
                return false;
            }
        }
        if (canChange && !s.hasNext() && !t.hasNext()) return true;
        if (canRemove && s.hasNext() && !t.hasNext()) {
            currS = s.next();
            if (currS == currT) return true;
        }
        if (canInsert && t.hasNext() && !s.hasNext()) {
            currT = t.next();
            if (currT == currS) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.format("%s\n", s.isOneEditDistance("abc", "abc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "bbbc"));

        System.out.format("%s\n", s.isOneEditDistance("abc", "abd"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "abcc"));
        System.out.format("%s\n", s.isOneEditDistance("abcc", "abc"));
        System.out.format("%s\n", s.isOneEditDistance("aabc", "abc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "aabc"));
        System.out.format("%s\n", s.isOneEditDistance("abc", "abbc"));

        System.out.println("CATS");
        System.out.format("%s\n", s.isOneEditDistance("cat", "dog"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "cats"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "cut"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "cast"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "at"));
        System.out.format("%s\n", s.isOneEditDistance("cat", "acts"));

    }
}