#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
private:
  int n = 0, m = 0;
  vector<vector<int>> grid, cost;
  vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  void _calculateCost(int row, int col) {
    vector<vector<bool>> seen(n, vector<bool>(m, false));
    queue<tuple<int, int, int>> q;
    q.push(make_tuple(row, col, 0));
    while(!q.empty()) {
      int r = 0, c = 0, depth = 0;
      tie(r, c, depth) = q.front();
      q.pop();
      for (auto d: directions) {
        int r1 = r + d.first, c1 = c + d.second;
        if (r1 >= 0 && r1 < n && c1 >=0 && c1 < m &&
            !seen[r1][c1] && grid[r1][c1] == 0) {
          cost[r1][c1] += depth + 1;
          q.push(make_tuple(r1, c1, depth + 1));
          seen[r1][c1] = true;
        }
      }
    }
  }

public:
  int shortestDistance(vector<vector<int>> &grid) {
    n = grid.size();
    if (n == 0) {
      return 0;
    }
    m = grid[0].size();
    this->grid = grid;
    this->cost = vector<vector<int>>(n, vector<int>(m, 0));

    for(int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 1) {
          _calculateCost(i, j);
        }
      }
    }

    int ans = INT_MAX;
    for(int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == 0) {
          ans = min(ans, cost[i][j]);
        }
      }
    }
    return ans == INT_MAX ? -1 : ans;
  }
};

int main() {
  Solution sol;
  vector<vector<int>> grid = {
    {1, 0, 2, 0, 1},
    {0, 0, 0, 0, 0},
    {0, 0, 1, 0, 0},
  };
  cout << sol.shortestDistance(grid) << endl;
  return 0;
}

