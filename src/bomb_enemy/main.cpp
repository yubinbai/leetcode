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
  int maxKilledEnemies(vector<vector<char>>& grid) {
    if (grid.empty() || grid[0].empty()) {
      return 0;
    }
    int m = grid.size();
    int n = grid[0].size();
    int res = 0;
    vector<vector<int>> sum(m, vector<int>(n, 0));

    // rows
    for (int i = 0; i < m; ++i) {
      int start = 0, end = 0;
      while (start < n) {
        int count = 0;
        while (end < n && grid[i][end] != 'Y') {
          if (grid[i][end] == 'X') {
            count++;
          }
          end++;
        }
        for (int j = start; j < end; j++) {
          sum[i][j] += count;
        }
        end++;
        start = end;
      }
    }

    // cols
    for (int j = 0; j < n; ++j) {
      int start = 0, end = 0;
      while (start < m) {
        int count = 0;
        while (end < m && grid[end][j] != 'Y') {
          if (grid[end][j] == 'X') {
            count++;
          }
          end++;
        }
        for (int i = start; i < end; i++) {
          sum[i][j] += count;
        }
        end++;
        start = end;
      }
    }

    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (grid[i][j] == '0') {
          res = max(res, sum[i][j]);
        }
      }
    }
    return res;
  }
};


int main() {
  Solution s;
  vector<vector<char>> grid = {
    {'0', 'X', '0', '0'},
    {'X', '0', 'Y', 'X'},
    {'0', 'X', '0', '0'},
  };
  cout << s.maxKilledEnemies(grid);

  return 0;
}
