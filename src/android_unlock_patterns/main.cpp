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
public:
  int numberOfPatterns(int m, int n) {
    return count(m, n, 0, 1, 1);
  }
  int count(int m, int n, int mask, int i1, int j1) {
    if (n == 0) {
      return 1;
    }
    int result = 0;
    for (int i = 0; i < 3; ++i) {
      for (int j = 0; j < 3; ++j) {
        int ii = i1 + i, jj = j1 + j, mask2 = mask | (1 << (i * 3 + j));
        if (mask2 > mask &&
            (ii % 2 || jj % 2 || mask2 & (1 << (ii / 2 * 3 + jj / 2)))) {
          result += count(m - 1, n - 1, mask2, i, j);
        }
      }
    }
    return result;
  }
};

int main() {
  Solution sol;

  cout << sol.numberOfPatterns(1, 1) << endl;

  cout << sol.numberOfPatterns(1, 2) << endl;

  return 0;
}
