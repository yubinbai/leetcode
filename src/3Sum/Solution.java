import java.lang.Integer;
import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();

        for (int i = 0; i < num.length - 2; i++) {
            int k = i + 1;
            int l = num.length - 1;

            while (k < l) {
                int sum = num[i]  + num[k] + num[l];

                if (sum > 0) {
                    l--;
                } else if (sum < 0) {
                    k++;
                } else {
                    ArrayList<Integer> listOfThree = new ArrayList<Integer>();
                    listOfThree.add(num[i]);
                    listOfThree.add(num[k]);
                    listOfThree.add(num[l]);
                    if ( !hashSet.contains(listOfThree) ) {
                        hashSet.add(listOfThree);

                    }
                    k++;
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(hashSet);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = { -1, 0, 1, 2, -1, -4};
        for (ArrayList<Integer> a : s.threeSum(arr)) {
            System.out.println(a);
        }

    }
}