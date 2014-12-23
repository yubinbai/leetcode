import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        Arrays.sort(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();

        for (int i = 0; i < num.length - 3; i++) {
            for (int j = i + 1; j < num.length - 2; j++) {
                int k = j + 1;
                int l = num.length - 1;

                while (k < l) {
                    int sum = num[i] + num[j] + num[k] + num[l];

                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        ArrayList<Integer> listOfFour = new ArrayList<Integer>();
                        listOfFour.add(num[i]);
                        listOfFour.add(num[j]);
                        listOfFour.add(num[k]);
                        listOfFour.add(num[l]);
                        if ( !hashSet.contains(listOfFour) ) {
                            hashSet.add(listOfFour);
                        }
                        k++;
                    }
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(hashSet);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1, 0, -1, 0, -2, 2};
        for (ArrayList<Integer> a : s.fourSum(arr, 0)) {
            System.out.print(a);
        }

    }
}
