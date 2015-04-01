import java.util.*;
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new ArrayList<Integer>();
        List<Integer> next = new ArrayList<Integer>(), swap;
        curr.add(1);
        if (rowIndex < 1) return curr;

        for (int i = 0; i < rowIndex; ++i) {
            next.clear();
            next.add(1);
            for (int j = 1; j < curr.size(); j++) {
                next.add(curr.get(j - 1) + curr.get(j));
            }
            next.add(1);

            swap = next;
            next = curr;
            curr = swap;
        }
        return curr; 
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getRow(0));
        System.out.println(s.getRow(1));
        System.out.println(s.getRow(2));
        System.out.println(s.getRow(3));
    }
}