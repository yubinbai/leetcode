#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
  bool isReflected(vector<pair<int, int>>& points) {
    unordered_map<int, set<int>> m;
    int mx = INT_MIN, mn = INT_MAX;
    for (auto p : points) {
      mx = max(mx, p.first);
      mn = min(mn, p.first);
      m[p.first].insert(p.second);
    }
    double y = (double)(mx + mn) / 2;
    for (auto p : points) {
      int t = 2 * y - p.first;
      if (!m.count(t) || !m[t].count(p.second)) {
        return false;
      }
    }
    return true;
  }
};

int main() {
  Solution sol;
  vector<pair<int, int>> points;

  points = {{1, 1}, {-1, 1}};
  cout << sol.isReflected(points) << endl;

  points = {{1, 1}, {-1, -1}};
  cout << sol.isReflected(points) << endl;
  return 0;
}
