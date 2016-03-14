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
  const int UNDEFINED = -1;
  const int BLACK = 0;
  const int WHITE = 1;
  const vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  int rows = 0;
  int cols = 0;
  vector<vector<int>> color, matrix, memo;

  int dfs(int row, int col) {
    if (memo[row][col] != UNDEFINED) {
      return memo[row][col];
    }
    int ans = 0;
    color[row][col] = BLACK;
    for (auto d: directions) {
      int r = row + d.first;
      int c = col + d.second;
      if (r >= rows || r < 0 || c >= cols || c < 0) {
        continue;
      } else if (color[r][c] == WHITE && matrix[row][col] < matrix[r][c]) {
        ans = max(ans, dfs(r, c) + 1);
      }
    }
    color[row][col] = WHITE;
    return memo[row][col] = ans;
  }
public:
  int longestIncreasingPath(vector<vector<int>>& matrix) {
    rows = matrix.size();
    if (rows == 0) {
      return 0;
    }
    cols = matrix[0].size();
    if (cols == 0) {
      return 0;
    }
    this->matrix = matrix;
    memo = vector<vector<int>>(rows, vector<int>(cols, UNDEFINED));
    color = vector<vector<int>>(rows, vector<int>(cols, WHITE));

    int ans = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        ans = max(ans, dfs(i, j));
      }
    }
    return ans + 1;
  }
};

int main() {
  Solution sol;
  vector<vector<int>> nums = {
    {9,9,4},
    {6,6,8},
    {2,1,1},
  };
  cout << sol.longestIncreasingPath(nums) << endl;

  nums = {
    {3,4,5},
    {3,2,6},
    {2,2,1}
  };
  cout << sol.longestIncreasingPath(nums) << endl;
  return 0;
}
