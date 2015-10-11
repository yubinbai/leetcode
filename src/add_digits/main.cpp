#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <cstdlib>
#include <sstream>

using namespace std;

class Solution {
public:
  int addDigits(int num) {
    if (num == 0) {
      return 0;
    }
    int m = num % 9;
    return m == 0 ? 9 : m;
  }
};

int main() {
  Solution sol;
  cout << sol.addDigits(0) << endl;
  cout << sol.addDigits(121) << endl;
  return 0;
}
