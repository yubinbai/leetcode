#include <cstdlib>
#include <iostream>
#include <map>
#include <sstream>
#include <string>
#include <vector>

using namespace std;
class Solution {
public:
  bool isUgly(int num) {
    if (num == 1) return true;
    if (num <= 0) return false;
    while (num % 2 == 0) num /= 2;
    while (num % 3 == 0) num /= 3;
    while (num % 5 == 0) num /= 5;
    return num == 1;
  }
};

int main() {
  Solution sol;
  cout << sol.isUgly(1) << endl;
  cout << sol.isUgly(3) << endl;
  cout << sol.isUgly(5) << endl;
  cout << sol.isUgly(57) << endl;

  return 0;
}
