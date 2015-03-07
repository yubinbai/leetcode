import java.lang.Integer;
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int n = num.length;

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            int k = i + 1;
            int l = n - 1;

            while (k < l) {
                int sum = num[i]  + num[k] + num[l];

                if (sum > 0) {
                    while (l > 0 && num[l] == num[l - 1]) l--;
                    l--;
                } else if (sum < 0) {
                    while (k < n - 1 && num[k] == num[k + 1]) k++;
                    k++;
                } else {
                    ArrayList<Integer> listOfThree = new ArrayList<Integer>();
                    listOfThree.add(num[i]);
                    listOfThree.add(num[k]);
                    listOfThree.add(num[l]);
                    ret.add(listOfThree);
                    while (l > 0 && num[l] == num[l - 1]) l--;
                    l--;
                    while (k < n - 1 && num[k] == num[k + 1]) k++;
                    k++;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr;
        arr = new int[] { -1, 0, 1, 2, -1, -4};
        for (ArrayList<Integer> a : s.threeSum(arr)) {
            System.out.println(a);
        }
        arr = new int[] { 0, 0, 0, 0};
        for (ArrayList<Integer> a : s.threeSum(arr)) {
            System.out.println(a);
        }

    }
}