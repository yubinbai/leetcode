import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        int n = num.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && num[i] == num[i - 1]) continue;
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum > target) {
                        while (l > 0 && num[l] == num[l - 1]) l--;
                        l--;
                    } else if (sum < target) {
                        while (k < n - 1 && num[k] == num[k + 1]) k++;
                        k++;
                    } else {
                        ArrayList<Integer> listOfFour = new ArrayList<Integer>();
                        listOfFour.add(num[i]);
                        listOfFour.add(num[j]);
                        listOfFour.add(num[k]);
                        listOfFour.add(num[l]);
                        ret.add(listOfFour);
                        while (l > 0 && num[l] == num[l - 1]) l--;
                        l--;
                        while (k < n - 1 && num[k] == num[k + 1]) k++;
                        k++;
                    }
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr;
        arr = new int[] {1, 1, -1, 0, -1, 0, -2, 2};
        for (ArrayList<Integer> a : s.fourSum(arr, 0)) {
            System.out.println(a);
        }
        arr = new int[] {0, 0, 0, 0};
        for (ArrayList<Integer> a : s.fourSum(arr, 0)) {
            System.out.println(a);
        }

    }
}
