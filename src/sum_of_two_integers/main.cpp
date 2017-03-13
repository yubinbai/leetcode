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
  int getSum(int a, int b) {
    while (b != 0) {
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }
    return a;
  }
};

int main() {
  Solution sol;

  cout << sol.getSum(1, 2) << endl;

  cout << sol.getSum(2, 2) << endl;

  cout << sol.getSum(3, 5) << endl;

  return 0;
}
