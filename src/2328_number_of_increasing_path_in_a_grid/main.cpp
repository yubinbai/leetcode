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
  int ret[1001][1001];
  int m, n;
  vector<vector<int>> g;
  const int MOD = 1000000007;

  int dfs(int row, int col) {
    if (row < 0 || row >= m || col < 0 || col >= n) {
      return 0;
    }
    if (ret[row][col] != 0) {
      return ret[row][col];
    }
    ret[row][col] = 1;
    if (row - 1 >= 0 && g[row - 1][col] > g[row][col]) {
      ret[row][col] += dfs(row - 1, col);
      ret[row][col] %= MOD;
    }
    if (row + 1 < m && g[row + 1][col] > g[row][col]) {
      ret[row][col] += dfs(row + 1, col);
      ret[row][col] %= MOD;
    }
    if (col - 1 >= 0 && g[row][col - 1] > g[row][col]) {
      ret[row][col] += dfs(row, col - 1);
      ret[row][col] %= MOD;
    }
    if (col + 1 < n && g[row][col + 1] > g[row][col]) {
      ret[row][col] += dfs(row, col + 1);
      ret[row][col] %= MOD;
    }
    return ret[row][col];
  }

  int countPaths(vector<vector<int>>& grid) {
    g = grid;
    m = grid.size();
    n = grid[0].size();
    memset(ret, 0, sizeof ret);
    int r = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        r += dfs(i, j);
        r %= MOD;
      }
    }
    return r;
  }
};

int main() {
  Solution sol;
  vector<vector<int>> grid = {{1,1},{3,4}};
  cout << sol.countPaths(grid) << endl;

  grid = {{1}, {2}};
  cout << sol.countPaths(grid) << endl;

  return 0;
}
