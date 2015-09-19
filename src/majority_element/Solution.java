import java.util.*;
public class Solution {
  public int majorityElement(int[] num) {
    int n = num.length;
    int candidate = num[0], counter = 0;
    for (int i : num) {
      if (counter == 0) {
        candidate = i;
        counter = 1;
      } else {
        if (i == candidate) {
          counter++;
        } else {
          counter--;
        }
      }
    }

    // counter = 0;
    // for (int i : num) {
    //     if (i == candidate) counter++;
    // }
    // if (counter < (n + 1) / 2) return -1;
    return candidate;
  }
  public int majorityElement_BySorting(int[] num) {
    int n = num.length;
    Arrays.sort(num);
    return num[n >> 1];
  }
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.format("%d\n", s.majorityElement(new int[] {1, 2, 3}));
    System.out.format("%d\n", s.majorityElement(new int[] {2, 2, 3}));
  }
}
