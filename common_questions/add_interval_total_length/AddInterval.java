import java.util.*;
interface Intervals {
    /**
     * Adds an interval [from, to] into internal structure.
     */
    void addInterval(int from, int to);
    /**
     * Returns a total length covered by intervals.
     * If several intervals intersect, intersection should be counted only once.
     * Example:
     *
     * addInterval(3, 6)
     * addInterval(8, 9)
     * addInterval(1, 5)
     *
     * getTotalCoveredLength() -> 6
     * i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6]
     * [1,6] and [8,9] don't intersect so total covered length is a sum for both intervals, that is 6.
     *
     */
    int getTotalCoveredLength();
}
public class AddInterval implements Intervals {
    List<Interval> list;
    int coverLength;
    public AddInterval() {
        list = new ArrayList<Interval>();
        coverLength = 0;
    }
    public void addInterval(int from, int to) {
        Interval i = new Interval(from, to);
        List<Interval> newList = new ArrayList<Interval>();

        for (Interval curr : list) {
            if (curr.to < i.from) {
                newList.add(curr);
            } else if (curr.from > i.to) {
                coverLength -= curr.getLength();
                coverLength += i.getLength();
                newList.add(i);
                i = curr;
            } else if (i.from <= curr.to && curr.from <= i.to) {
                i = new Interval(Math.min(i.from, curr.from), Math.max(i.to, curr.to));
                coverLength -= curr.getLength();
            }
        }
        newList.add(i);
        coverLength += i.getLength();
        list = newList;
    }
    public int getTotalCoveredLength() {
        return coverLength;
    }
    public static void main(String[] args) {
        AddInterval a = new AddInterval();
        a.addInterval(3, 6);
        System.out.println(a.list);
        System.out.println(a.getTotalCoveredLength());
        a.addInterval(8, 9);
        System.out.println(a.list);
        System.out.println(a.getTotalCoveredLength());
        a.addInterval(1, 5);
        System.out.println(a.list);
        System.out.println(a.getTotalCoveredLength());
    }
}
class Interval {
    int from, to;
    public Interval(int f, int t) {
        from = f;
        to = t;
    }
    public int getLength() {
        return to - from;
    }
    public String toString() {
        return String.format("[%d, %d]", from, to);
    }
}