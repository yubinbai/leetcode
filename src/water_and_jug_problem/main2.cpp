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
    this->x = x;
    this->y = y;
    this->z = z;
    this->isFound = false;
    this->seen.clear();
    search(0, 0);
    return this->isFound;
  }
private:
  unordered_set<long> seen = {0};
  int x = 0, y = 0, z = 0;
  bool isFound = false;

  void search(int a, int b) {
    if (this->isFound || seen.count(serialize(a, b))) {
      return;
    }
    if (a == z || b == z || a + b == z) {
      this->isFound = true;
      return;
    }
    seen.insert(serialize(a, b));
    search(x, b);
    search(a, y);
    search(0, b);
    search(a, 0);
    search(min(x, a + b), max(0, b - a));
    search(max(0, a - b), min(y, a + b));
  }

  long serialize(int a, int b) {
    return ((long)a << 32) + b;
  }
};


int main() {
  Solution sol;

  cout << sol.canMeasureWater(3, 5, 4) << endl;
  cout << sol.canMeasureWater(2, 6, 5) << endl;
  cout << sol.canMeasureWater(104579, 104563, 12444) << endl;

  return 0;
}
