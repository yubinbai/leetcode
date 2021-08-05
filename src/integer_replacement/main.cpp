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
private:
  int integerReplacement(long n) {
    if (n <= 2) {
      return 1;
    }
    if (n % 2 == 0) {
      return 1 + integerReplacement(n / 2);
    } else {
      return 1 + min(integerReplacement(n - 1), integerReplacement(n + 1));
    }
  }
public:
  int integerReplacement(int n) {
    return integerReplacement((long) n);
  }
};

int main() {
  Solution sol;

  cout << sol.integerReplacement(8) << endl;

  cout << sol.integerReplacement(7) << endl;

  cout << sol.integerReplacement(4) << endl;

  cout << sol.integerReplacement(2147483647) << endl;

  return 0;
}
