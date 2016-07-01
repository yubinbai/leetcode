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
  int countNumbersWithUniqueDigits(int n) {
    if (n < 0) {
      return 0;
    }
    if (n == 0) {
      return 1;
    }
    int s = 10;
    for (int i = 2; i <= n; i++) {
      int f = 9;
      int ii = i - 1;
      for (int j = 9; j > 0 && ii > 0; j--, ii--) {
        f *= j;
      }
      s += f;
    }
    return s;
  }
};

int main() {
  Solution sol;

  for (int i = 0; i < 12; i++) {
    cout << sol.countNumbersWithUniqueDigits(i) << endl;
  }
  return 0;
}
