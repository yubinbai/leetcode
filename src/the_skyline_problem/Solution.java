import java.util.*;

public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        HashSet<Integer> pointSet = new HashSet<Integer>();
        for (int[] b : buildings) {
            pointSet.add(b[0]);
            pointSet.add(b[1]);
        }
        int n = pointSet.size();
        Integer[] pts = new Integer[n];
        pointSet.toArray(pts);
        Arrays.sort(pts);
        int[] heights = new int[n];
        for (int[] b : buildings) {
            int start = Arrays.binarySearch(pts, b[0]);
            int end = Arrays.binarySearch(pts, b[1]);
            for (int i = start; i < end; ++i) {
                heights[i] = Math.max(heights[i], b[2]);
            }
        }
        List<int[]> result = new ArrayList<int[]>();
        int prevHeight = 0;
        for (int i = 0; i < n; ++i) {
            if (heights[i] != prevHeight) {
                result.add(new int[] {pts[i], heights[i]});
                prevHeight = heights[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] buildings = new int[][] {{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8} };
        for (int[] pt : s.getSkyline(buildings)) {
            System.out.format("%d %d\n", pt[0], pt[1]);
        }
    }
}