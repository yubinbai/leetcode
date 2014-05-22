import java.util.*;
public class Solution {
    public String countAndSay(int n) {
        if (n < 0) return "";
        BigInteger curr = new BigInteger(0);
        BigInteger next = new BigInteger();
        BigInteger oneOne = new BigInteger(0);
        BigInteger twoOne = new BigInteger(0);
        BigInteger oneTwo = new BigInteger(1);
        for (int i = 0; i < n; i++) {
            while (curr.bitLength() > 0) {
                if (curr.bitLength() > 1) {
                    if (curr.isEmpty() || (!curr.isEmpty() && curr.peek()) ) {
                    }
                } else {
                    curr.shiftLeft(1);
                    next.shiftLeft(2);
                    next.or(oneOne);
                }

            }
            curr = next;
            next = new BigInteger();
        }



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
    }
}