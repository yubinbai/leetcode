import java.util.*;
public class Solution {
    class Tuple implements Comparable<Tuple> {
        int i, v;
        public Tuple(int i, int v) {
            this.i = i;
            this.v = v;
        }
        public int compareTo(Tuple o) {
            return Integer.compare(this.v, o.v);
        }
    }
    public int[] twoSum(int[] numbers, int target) {
        Tuple[] t = new Tuple[numbers.length];
        for (int i = 0; i < numbers.length; ++i) {
            t[i] = new Tuple(i, numbers[i]);
        }
        Arrays.sort(t);
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int curr = t[left].v + t[right].v;
            if (curr < target) {
                left++;
            } else if (curr > target) {
                right--;
            } else {
                int a = Math.min(t[left].i + 1, t[right].i + 1);
                int b = Math.max(t[left].i + 1, t[right].i + 1);
                return new int[] {a, b};
            }
        }
        return new int[] { -1, -1};
    }
}