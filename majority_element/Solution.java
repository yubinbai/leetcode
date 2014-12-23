import java.util.*;
public class Solution {
    public int majorityElement(int[] num) {
        int n = num.length;
        Arrays.sort(num);
        return num[n >> 1];
    }
}