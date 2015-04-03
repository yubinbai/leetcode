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
public class Solution2 {
    public  int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, new Comparator<Point> () {
            public int compare(Point a, Point b) {
                if (a.y == b.y) {
                    return Integer.compare(a.x, b.x);
                } else {
                    return Integer.compare(a.y, b.y);
                }
            }
        });
        HashMap<Long, Integer> cnt = new HashMap<Long, Integer>();
        int ans = 1;
        // iterate through each shared point
        for (int i = 0; i < points.length; i++) {
            cnt.clear();
            int duplicate = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    duplicate++;
                    continue;
                }
                double cos = (points[j].x - points[i].x)
                             / Math.hypot(points[j].y - points[i].y, points[j].x - points[i].x);
                long cosL = toLong(cos);
                if (cnt.containsKey(cosL)) {
                    cnt.put(cosL, cnt.get(cosL) + 1);
                } else {
                    cnt.put(cosL, 2);
                }
            }

            ans = Math.max(duplicate + 1, ans);
            for (int v : cnt.values()) {
                ans = Math.max(ans, duplicate + v);
            }
        }
        return ans;
    }
    public long toLong(double e) {
        return (long) (e * 1e18);
    }
    public static void main(String[] args) {
        Point[] pts = new Point[3];
        pts[0] = new Point(0, 0);
        pts[1] = new Point(1, 1);
        pts[2] = new Point(1, -1);
        // pts[3] = new Point(0, -70);
        // pts[4] = new Point(0, -70);
        // pts[5] = new Point(1, -1);
        // pts[6] = new Point(21, 10);
        // pts[7] = new Point(42, 90);
        // pts[8] = new Point(-42, -230);
        Solution2 s = new Solution2();
        System.out.println(s.maxPoints(pts));
    }
}