import java.util.*;
public class Solution {
    public String countAndSay(int n) {
        if (n < 0) return "";
        char[] original = new char[] { '1' };
        StringBuffer sb = null;

        for (int i = 1; i < n; i++) {
            sb = new StringBuffer();
            int len = original.length;
            int begin = 0;

            for (int j = 1; j <= len; j++)
                if (j == len || original[j] != original[begin]) {
                    sb.append("" + (j - begin));
                    sb.append(original[begin]);
                    begin = j;
                }
            original = sb.toString().toCharArray();
        }
        return new String(original);

    }

    // TLE
    public String _countAndSay(int n) {
        if (n < 0) return "";

        LinkedList<Boolean> curr = new LinkedList<Boolean>();
        LinkedList<Boolean> next = new LinkedList<Boolean>();
        curr.offer(false);
        for (int i = 0; i < n; i++) {
            while (!curr.isEmpty()) {
                if (!curr.peek()) {
                    curr.poll();
                    if (curr.isEmpty() || (!curr.isEmpty() && curr.peek()) ) {
                        next.offer(false);
                        next.offer(false);
                    } else {
                        if (!curr.isEmpty() && !curr.peek()) {
                            curr.poll();
                            next.offer(true);
                            next.offer(false);
                        }
                    }
                } else {
                    curr.poll();
                    next.offer(false);
                    next.offer(true);
                }

            }
            curr = next;
            next = new LinkedList<Boolean>();
        }

        StringBuilder sb = new StringBuilder();
        for (Boolean b : curr) {
            if (b)
                sb.append('2');
            else
                sb.append('1');
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(-1));
        System.out.println(s.countAndSay(0));
        System.out.println(s.countAndSay(1));
        System.out.println(s.countAndSay(2));
        System.out.println(s.countAndSay(3));
        System.out.println(s.countAndSay(4));
        System.out.println(s.countAndSay(30).length());
    }
}