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
  int memo[1001][1001];
  int m, n;
  vector<vector<int>> g;
  const int MOD = 1000000007;

  int dfs(int row, int col) {
    if (memo[row][col] != 0) {
      return memo[row][col];
    }
    memo[row][col] = 1;
    if (row - 1 >= 0 && g[row - 1][col] > g[row][col]) {
      memo[row][col] += dfs(row - 1, col);
      memo[row][col] %= MOD;
    }
    if (row + 1 < m && g[row + 1][col] > g[row][col]) {
      memo[row][col] += dfs(row + 1, col);
      memo[row][col] %= MOD;
    }
    if (col - 1 >= 0 && g[row][col - 1] > g[row][col]) {
      memo[row][col] += dfs(row, col - 1);
      memo[row][col] %= MOD;
    }
    if (col + 1 < n && g[row][col + 1] > g[row][col]) {
      memo[row][col] += dfs(row, col + 1);
      memo[row][col] %= MOD;
    }
    return memo[row][col];
  }

  int countPaths(vector<vector<int>>& grid) {
    g = grid;
    m = grid.size();
    n = grid[0].size();
    memset(memo, 0, sizeof memo);
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

int main(int argc, const char * argv[]) {
  Solution sol;
  vector<vector<int>> grid = {{1,1},{3,4}};
  cout << sol.countPaths(grid) << endl;

  grid = {{1}, {2}};
  cout << sol.countPaths(grid) << endl;

  return 0;
}
