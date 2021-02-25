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
  void setZeroes(vector<vector<int>> &matrix) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
    assert(matrix.size() > 0);
    int row = matrix.size(), col = matrix[0].size();
    bool zerorow = false, zerocol = false;
    for (int j = 0; j < col; j++) {
      if (matrix[0][j] == 0) {
        zerorow = 1;
      }
    }
    for (int i = 0; i < row; i++) {
      if (matrix[i][0] == 0) {
        zerocol = 1;
      }
    }
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (matrix[i][j] == 0) {
          matrix[0][j] = 0;
          matrix[i][0] = 0;
        }
      }
    }
    for (int i = 1; i < row; i++) {
      for (int j = 1; j < col; j++) {
        if (matrix[i][0] == 0 || matrix[0][j] == 0) {
          matrix[i][j] = 0;
        }
      }
    }
    if (zerorow == 1) {
      for (int i = 0; i < col; i++) {
        matrix[0][i] = 0;
      }
    }
    if (zerocol == 1) {
      for (int i = 0; i < row; i++) {
        matrix[i][0] = 0;
      }
    }
  }
};

int main() {
  Solution sol;
  vector<vector<int>> matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
  sol.setZeroes(matrix);

  return 0;
}
