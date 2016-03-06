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
  bool isPowerOfThree(int n) {
    if (n <= 0) {
      return false;
    }
    while (n != 1) {
      if ( n % 3 != 0) {
        break;
      }
      n /= 3;
    }
    return n == 1;
  }
};

int main() {
  Solution sol;
  cout << sol.isPowerOfThree(9) << endl;
  return 0;
}
