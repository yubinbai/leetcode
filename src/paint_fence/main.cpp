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
  int numWays(int n, int k) {
    if (n == 0 || k == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    int same_color_count = k;
    int diff_color_count = k * (k - 1);
    for (int i = 3; i <= n; i++) {
      int swap = diff_color_count;
      diff_color_count = diff_color_count * (k - 1) + same_color_count * (k - 1);
      same_color_count = swap;
    }
    return same_color_count + diff_color_count;
  }
};

int main() {
  Solution sol;
  for (int i = 0; i < 10; i++) {
    cout << sol.numWays(i, 3) << endl;
  }
  return 0;
}
