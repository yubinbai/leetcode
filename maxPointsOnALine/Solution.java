import java.util.*;
// Solution:
// http://rleetcode.blogspot.com/2014/01/max-points-on-linejava.html
// remember that  a line can be represented by y=kx+d, if p1 and p2 are in same line, then y1=x1k+d,
// y2=kx2+d, so y2-y1=kx2-kx1, so k=(y2-y1)/(x2-x1), then we can apply this formular to check
// if two points are in same line, however how to handle the duplicate points problem?
// So instead to calculate the line with maximum points , we should calculate
// longest line(maximum points) through same point,
class Point {
    int x;
    int y;
    Point() {
        x = 0;
        y = 0;
    }
    Point(int a, int b) {
        x = a;
        y = b;
    }
}
public class Solution {
    public  int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();;
        int max = 1;
        for (int i = 0; i < points.length; i++) {
            // shared point changed, map should be cleared and server the new point
            map.clear();
            // maybe all points contained in the list are same points,and same points' k is
            // represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);
            int dup = 0;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }
                // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
                // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
                // problem
                // if the line through two points are parallel to y coordinator, then K(slop) is
                // Integer.MAX_VALUE
                double key = points[j].x - points[i].x == 0 ?
                             Integer.MAX_VALUE :
                             0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }
            }
            for (int temp : map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }
        }
        return max;
    }
}