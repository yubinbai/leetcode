import java.util.*;
import java.math.*;
public class Solution {
    public String largestNumber(int[] num) {
        int n = num.length;
        Integer[] numbers = new Integer[n];
        for (int i = 0; i < n; ++i) {
            numbers[i] = num[i];
        }
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                long first = Long.parseLong(String.format("%d%d", a, b));
                long second = Long.parseLong(String.format("%d%d", b, a));
                return Long.compare(first, second) * -1;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            sb.append(numbers[i]);
        }
        BigInteger bi = new BigInteger(sb.toString());
        return bi.toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr;
        arr = new int[] {3, 30, 34, 5, 9};
        System.out.format("%s\n", s.largestNumber(arr));
        arr = new int[] {0, 0};
        System.out.format("%s\n", s.largestNumber(arr));
    }
}