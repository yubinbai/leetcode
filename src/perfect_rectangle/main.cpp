#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
private:
  bool isOverlap(vector<int> r, vector<int> rr) {
    // (RectA.Left < RectB.Right && RectA.Right > RectB.Left &&
    //  RectA.Top > RectB.Bottom && RectA.Bottom < RectB.Top )
    return (r[0] < rr[2] && r[2] > rr[0] &&
            r[3] > rr[1] && r[1] < rr[3]) ;
  }
public:
  bool isRectangleCover(vector<vector<int>>& rectangles) {
    if (rectangles.size() == 0) {
      return false;
    }
    int min_x = rectangles[0][0];
    int min_y = rectangles[0][1];
    int max_a = rectangles[0][2];
    int max_b = rectangles[0][3];

    for (auto r: rectangles) {
      min_x = min(min_x, r[0]);
      min_y = min(min_y, r[1]);
      max_a = max(max_a, r[2]);
      max_b = max(max_b, r[3]);
    }

    long total_area = 1L * (max_a - min_x) * (max_b - min_y);
    for (auto r: rectangles) {
      long area = 1L * (r[2] - r[0]) * (r[3] - r[1]);
      total_area -= area;
    }
    if (total_area != 0) {
      return false;
    }

    for (int i = 0; i < rectangles.size(); i++) {
      for (int ii = i + 1; ii < rectangles.size(); ii++) {
        if (isOverlap(rectangles[i], rectangles[ii])) {
          return false;
        }
      }
    }

    return true;
  }
};

int main() {

  Solution sol;
  vector<vector<int>> rectangles;

  rectangles = {{1,1,3,3},{3,1,4,2},{3,2,4,4},{1,3,2,4},{2,3,3,4}};
  cout << sol.isRectangleCover(rectangles) << endl;

  rectangles = {{1,1,2,3},{1,3,2,4},{3,1,4,2},{3,2,4,4}};
  cout << sol.isRectangleCover(rectangles) << endl;

  rectangles = {{1,1,3,3},{3,1,4,2},{1,3,2,4},{3,2,4,4}};
  cout << sol.isRectangleCover(rectangles) << endl;

  rectangles = {{1,1,3,3},{3,1,4,2},{1,3,2,4},{2,2,4,4}};
  cout << sol.isRectangleCover(rectangles) << endl;

  return 0;
}
