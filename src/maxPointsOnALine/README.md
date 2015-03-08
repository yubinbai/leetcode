Problem
===
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Solution
===

http://rleetcode.blogspot.com/2014/01/max-points-on-linejava.html

remember that  a line can be represented by y=kx+d, if p1 and p2 are in same line, then y1=x1k+d, y2=kx2+d, so y2-y1=kx2-kx1, so k=(y2-y1)/(x2-x1), then we can apply this formular to check if two points are in same line, however how to handle the duplicate points problem?

So instead to calculate the line with maximum points , we should calculate longest line(maximum points) through same point,