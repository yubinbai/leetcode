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
public:
  int minTotalDistance(vector<vector<int>>& grid) {
    int m = grid.size();
    int n = grid[0].size();
    vector<int> rows, cols;
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (grid[i][j] == 1) {
          rows.push_back(i);
          cols.push_back(j);
        }
      }
    }
    return getMin(rows)+getMin(cols);
  }
     
  // total distance to median
  // can also view as converging all points to median
  int getMin(vector<int> &vec){
    int n = vec.size(), ret = 0;
    sort(vec.begin(), vec.end());
    for (int i = 0, j = n - 1; i < j; i++, j--) {
      ret += vec[j]-vec[i];
    }
    return ret;
  }
};

int main() {
  Solution sol;
  vector<vector<int>> vvi = {{0, 1}, {1, 0}}; 
  cout << sol.minTotalDistance(vvi) << endl;

  vvi = {{1,0,0,0,1}, {0,0,0,0,0}, {0,0,1,0,0}}; 
  cout << sol.minTotalDistance(vvi) << endl;
  return 0;
}
