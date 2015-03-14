import java.util.*;
public class Solution {

    public String getPermutation(int n, int k) {
        int[] result = new int[n];
        ArrayList<Integer> curr = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            curr.add(i);
        }
        long fact = factorial(n);
        k--;
        k %= fact;
        int choice;
        for (int i = 0; i < n; i++) {
            fact /= (n - i);
            choice = (int) (k / fact);
            k %= fact;
            result[i] = curr.get(choice);
            curr.remove(choice);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i);
        }
        return sb.toString();
    }
    public long factorial(int n) {
        if (n <= 1) return 1L;
        long ret = 1;
        for (int i = 2; i <= n; i++) ret *= i;
        return ret;
    }
    public static void main(String[] args) {
        Solution sol = new Solution();
        for (int i = 1; i < 7; i++) {
            System.out.println(sol.getPermutation(3, i));
        }
    }
}
