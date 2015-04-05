import java.util.*;
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        boolean mergeIsDone = false;
        for (Interval i : intervals) {
            if (mergeIsDone || i.end < newInterval.start) {
                result.add(i);
            } else if (newInterval.end < i.start) {
                result.add(newInterval);
                result.add(i);
                mergeIsDone = true;
            } else if (i.start <= newInterval.end && newInterval.start <= i.end) {
                newInterval = new Interval(
                    Math.min(i.start, newInterval.start),
                    Math.max(i.end, newInterval.end)
                );
            }
        }
        if (!mergeIsDone) result.add(newInterval);
        return result;
    }
    public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                return Integer.compare(a.start, b.start);
            }
        });
        List<Interval> result = new ArrayList<Interval>();
        Interval curr = intervals.get(0);
        for (Interval i : intervals) {
            if (i.start <= curr.end) {
                curr.end = Math.max(i.end, curr.end);
            } else {
                result.add(curr);
                curr = i;
            }
        }
        result.add(curr);
        return result;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        List<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(1, 2));
        list.add(new Interval(6, 9));
        Interval e = new Interval(3, 7);

        for (Interval i : s.insert(list, e)) {
            System.out.format("%d %d\n", i.start, i.end);
        }
    }
}