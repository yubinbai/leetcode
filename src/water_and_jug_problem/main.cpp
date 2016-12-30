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
  bool canMeasureWater(int x, int y, int z) {
    return z == 0 || (x + y >= z && z % gcd(x, y) == 0);
  }
  int gcd(int x, int y) {
    return y == 0 ? x : gcd(y, x % y);
  }
};

int main() {
  Solution sol;

  cout << sol.canMeasureWater(3, 5, 4) << endl;
  cout << sol.canMeasureWater(2, 6, 5) << endl;
  cout << sol.canMeasureWater(104579, 104563, 12444) << endl;
  cout << sol.canMeasureWater(104693, 104701, 324244) << endl;

  return 0;
}
