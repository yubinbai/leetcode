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
  int kthSmallest(vector<vector<int>>& matrix, int k) {
    int n = matrix.size();
    long low = matrix[0][0];
    long high = matrix[n - 1][n - 1] + 1;
    while (low < high) {
      long mid = low + (high - low) / 2;      
      int total = 0;
      for (const auto& row : matrix) {
        auto pos = upper_bound(row.begin(), row.end(), mid);
        total += distance(row.begin(), pos);
      }
      if (total >= k) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }
};

int main() {
  Solution sol;
  vector<vector<int>> vii = {{1,5,9},{10,11,13},{12,13,15}};
  cout << sol.kthSmallest(vii, 8) << endl;

  vii = {{1,5,9},{10,11,13},{12,13,15}};
  cout << sol.kthSmallest(vii, 9) << endl;

  vii = {{1,5,9},{10,11,13},{12,13,15}};
  cout << sol.kthSmallest(vii, 4) << endl;

  vii = {{1,5,9},{10,11,13},{12,13,15}};
  cout << sol.kthSmallest(vii, 2) << endl;

  vii = {{1,5,9},{10,11,13},{12,13,15}};
  cout << sol.kthSmallest(vii, 1) << endl;

  vii = {{-5}};
  cout << sol.kthSmallest(vii, 1) << endl;
  return 0;
}
