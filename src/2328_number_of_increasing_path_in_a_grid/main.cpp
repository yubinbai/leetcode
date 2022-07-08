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

struct Cell {
  int v;
  int row;
  int col;
};

struct cmpCell {
  bool operator()(Cell a, Cell b) const {
    return a.v < b.v;
  }
};

const int MOD = 1000000007;

class Solution {
public:
  int countPaths(vector<vector<int>>& grid) {
    priority_queue<Cell, vector<Cell>, cmpCell> pq;
    int m = grid.size();
    int n = grid[0].size();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        struct Cell c = {grid[i][j], i, j};
        pq.push(c);
      }
    }
    int ret[1001][1001] = {0};
    while (!pq.empty()) {
      Cell c = pq.top();
      pq.pop();
      if (ret[c.row][c.col] == 0) {
        ret[c.row][c.col] = 1;
      }
      int ii = c.row - 1;
      int jj = c.col;
      if (ii >= 0 && grid[ii][jj] > c.v) {
        ret[c.row][c.col] += ret[ii][jj];
        ret[c.row][c.col] %= MOD;
      }
      ii = c.row + 1;
      jj = c.col;
      if (ii < m && grid[ii][jj] > c.v) {
        ret[c.row][c.col] += ret[ii][jj];
        ret[c.row][c.col] %= MOD;
      }
      ii = c.row;
      jj = c.col - 1;
      if (jj >= 0 && grid[ii][jj] > c.v) {
        ret[c.row][c.col] += ret[ii][jj];
        ret[c.row][c.col] %= MOD;
      }
      ii = c.row;
      jj = c.col + 1;
      if (jj < n && grid[ii][jj] > c.v) {
        ret[c.row][c.col] += ret[ii][jj];
        ret[c.row][c.col] %= MOD;
      }
    }
    int r = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        r += ret[i][j];
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
