import java.util.*;
public class Solution {
    static long[] factorial = new long[30];
    static {
        factorial[0] = factorial[1] = 1;
        for (int i = 2; i < 21; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }
    public String getPermutation(int n, int k) {
        k--;
        ArrayList<Integer> result = new ArrayList<Integer>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            curr.add(i);
        }
        long fact = factorial[curr.size()];
        int choice;
        k %= fact;
        while (!curr.isEmpty()) {
            fact /= curr.size();
            choice = (int) (k / fact);
            k %= fact;
            int ret = curr.remove(choice);
            result.add(ret);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 1; i < 7; i++) {
            System.out.println(sol.getPermutation(3, i));
        }
    }
}

