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
  bool isPowerOfFour(int num) {
    // 0b01010101010101010101010101010101
    int filter = 1431655765;
    return num > 0 &&
      (num & (num - 1)) == 0 &&
      (num & filter) == num;
  }
};

int main() {
  Solution sol;

  cout << sol.isPowerOfFour(16) << endl;

  cout << sol.isPowerOfFour(5) << endl;

  cout << sol.isPowerOfFour(0) << endl;

  cout << sol.isPowerOfFour(1) << endl;

  return 0;
}
