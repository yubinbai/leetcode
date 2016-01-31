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
private:
  int n_rows = 0, n_cols = 0;
  vector<vector<int>> sums;
public:
  NumMatrix(vector<vector<int>> &matrix) {
    if (matrix.size() == 0) {
      return;
    }
    n_rows = matrix.size();
    if (matrix[0].size() == 0) {
      return;
    }
    n_cols = matrix[0].size();

    vector<int> sum_row;
    sum_row.push_back(matrix[0][0]);
    for (int j = 1; j < n_cols; j++) {
      sum_row.push_back(matrix[0][j] + sum_row.back());
    }
    sums.push_back(sum_row);
    for (int i = 1; i < n_rows; i++) {
      sum_row.clear();
      sum_row.push_back(matrix[i][0]);
      for (int j = 1; j < n_cols; j++) {
        sum_row.push_back(matrix[i][j] + sum_row.back());
      }
      vector<int> last_row = sums.back();
      for (int j = 0; j < n_cols; j++) {
        sum_row[j] += last_row[j];
      }
      sums.push_back(sum_row);
    }
  }

  int sumRegion(int row1, int col1, int row2, int col2) {
    int ret = sums[row2][col2];
    if (row1 > 0) {
      ret -= sums[row1 - 1][col2];
    }
    if (col1 > 0) {
      ret -= sums[row2][col1 - 1];
    }
    if (row1 > 0 && col1 > 0) {
      ret += sums[row1 - 1][col1 - 1];
    }
    return ret;
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
  cout << numMatrix.sumRegion(1, 1, 2, 2) << endl;
  cout << numMatrix.sumRegion(1, 2, 2, 4) << endl;
  return 0;
}
