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
  string addBinary(string a, string b) {
    if (a.size() == 0) {
      return b;
    }
    if (b.size() == 0) {
      return a;
    }
    string result;

    int lastA = a.size() - 1;
    int lastB = b.size() - 1;
    int carry = 0;

    while (lastA >= 0 || lastB >= 0 || carry > 0) {
      int num1 = lastA >= 0 ? a[lastA--] - '0' : 0;
      int num2 = lastB >= 0 ? b[lastB--] - '0' : 0;
      int current = (num1 + num2 + carry) % 2;
      carry = (num1 + num2 + carry) / 2;
      result += current ? '1' : '0';
    }
    reverse(result.begin(), result.end());
    return result;
  }
};

int main() {
  Solution sol;
  string a = "11", b = "1";
  cout << a << " " << b << " " << sol.addBinary(a, b) << endl;

  a = "101";
  b = "111";
  cout << a << " " << b << " " << sol.addBinary(a, b) << endl;
  return 0;
}
