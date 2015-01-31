import java.util.*;
class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return Integer.compare(i1.start, i2.start);
            }
        });
        ArrayList<Interval> ret = new ArrayList<Interval>();
        Iterator<Interval> it = intervals.iterator();
        Interval curr = it.next();
        while (it.hasNext()) {
            Interval curr2 = it.next();
            if (curr.end >= curr2.start) {
                // merge
                curr.end = Math.max(curr.end, curr2.end);
            } else {
                // cannot merge
                ret.add(curr);
                curr = curr2;
            }
        }
        ret.add(curr);
        return ret;
    }
    public static void main(String[] args) {
        int[][] intArray = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        for (int[] a : intArray) {
            intervals.add(new Interval(a[0], a[1]));
        }
        Solution s = new Solution();
        for (Interval i : s.merge(intervals)) {
            System.out.format("%d %d\n", i.start, i.end);
        }
    }
}