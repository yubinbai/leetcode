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

class Solution {
public:
  vector<vector<int>> multiply(vector<vector<int>>& A, vector<vector<int>>& B) {
    int m = A.size(), n = B.size(), p = B[0].size();
    vector<vector<int>> ans(m, vector<int>(p, 0));
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (A[i][j] != 0) {
          for (int k = 0; k < p; k++) {
            ans[i][k] += A[i][j] * B[j][k];
          }
        }
      }
    }
    return ans;
  }
};

int main() {
  Solution sol;
  vector<vector<int>> A = {
    { 1, 0, 0},
    {-1, 0, 3}
  };

  vector<vector<int>> B = {
    { 7, 0, 0 },
    { 0, 0, 0 },
    { 0, 0, 1 }
  };
  for (auto row: sol.multiply(A, B)) {
    for (auto num: row) {
      cout << num << " ";
    }
    cout << endl;
  }
  return 0;
}
