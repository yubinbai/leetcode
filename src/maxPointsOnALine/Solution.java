import java.util.*;

class Point {
    int x, y;
    Point() {
        x = 0; y = 0;
    }
    Point(int a, int b) {
        x = a; y = b;
    }
}
public class Solution {
    public static long LARGE = (long) 1e9;
    public  int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        HashMap<Long, Integer> cnt = new HashMap<Long, Integer>(); // count points with the same slope
        int ans = 1;
        // iterate through each shared point
        for (int i = 0; i < points.length; i++) {
            cnt.clear();
            cnt.put( LARGE * Integer.MIN_VALUE, 1);
            int duplicate = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    duplicate++;
                    continue;
                }
                long slope = points[j].x - points[i].x == 0 ?
                             LARGE * Integer.MAX_VALUE :
                             (long) ( LARGE * (0.0 + points[j].y - points[i].y) / (0.0 + points[j].x - points[i].x) );
                // System.out.println(slope);
                if (cnt.containsKey(slope)) {
                    cnt.put(slope, cnt.get(slope) + 1);
                } else {
                    cnt.put(slope, 2);
                }
            }
            // System.out.println(cnt);
            for (int v : cnt.values()) {
                ans = Math.max(ans, duplicate + v);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Point[] pts = new Point[9];
        // pts[0] = new Point(2, 3);
        // pts[1] = new Point(3, 3);
        // pts[2] = new Point(-5, 3);
        pts[0] = new Point(84, 250);
        pts[1] = new Point(0, 0);
        pts[2] = new Point(1, 0);
        pts[3] = new Point(0, -70);
        pts[4] = new Point(0, -70);
        pts[5] = new Point(1, -1);
        pts[6] = new Point(21, 10);
        pts[7] = new Point(42, 90);
        pts[8] = new Point(-42, -230);
        Solution s = new Solution();
        System.out.println(s.maxPoints(pts));
    }
}