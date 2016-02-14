#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class NumMatrix {
  vector<vector<int>> tree;
  vector<vector<int>> matrix;
  int rows, cols;
public:
  NumMatrix(vector<vector<int>> &matrix) {
    int n = matrix.size();
    int m = n == 0 ? 0 : matrix[0].size();
    if (n == 0 || m == 0) {
      return;
    }
    this->tree = vector<vector<int>>(n + 1, vector<int>(m + 1, 0));
    this->matrix = vector<vector<int>>(n, vector<int>(m, 0));
    this->rows = n;
    this->cols = m;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        update(i, j, matrix[i][j]);
      }
    }
  }
 
  void update(int row, int col, int val) {
    int delta = val - matrix[row][col];
    matrix[row][col] = val;
    for (int i = row + 1; i <= rows; i += i & (-i)) {
      for (int j = col + 1; j <= cols; j += j & (-j)) {
        tree[i][j] += delta;
      }
    }
  }

  int sumRegion(int row1, int col1, int row2, int col2) {
    return
      sum(row2, col2) +
      sum(row1 - 1, col1 - 1) -
      sum(row2, col1 - 1) -
      sum(row1 - 1, col2);
  }

  int sum(int row, int col) {
    int ans = 0;
    for (int i = row + 1; i > 0; i -= i & (-i)) {
      for (int j = col + 1; j > 0; j -= j & (-j)) {
        ans += tree[i][j];
      }
    }
    return ans;
  }
};

int main() {
  vector<vector<int>> matrix = {
    {3, 0, 1, 4, 2},
    {5, 6, 3, 2, 1},
    {1, 2, 0, 1, 5},
    {4, 1, 0, 1, 7},
    {1, 0, 3, 0, 5}
  };
  NumMatrix numMatrix(matrix);
  cout << numMatrix.sumRegion(2, 1, 4, 3) << endl;
  numMatrix.update(3, 2, 2);
  cout << numMatrix.sumRegion(2, 1, 4, 3) << endl;
  return 0;
}
