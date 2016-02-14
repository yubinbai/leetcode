#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
  bool isAdditiveNumber(string num) {
    int n = num.size();
    for (int i = 1; i <= n / 2; i++) {
      for (int j = 1; j <= (n - i) / 2; j++) {
        if (_isAdditive(num.substr(0, i), num.substr(i, j), num.substr(i + j))) {
          return true;
        }
      }
    }
    return false;
  }

private:
  bool _isAdditive(string a, string b, string c) {
    string s = addString(a, b);
    if (s.compare(c) == 0) {
      return true;
    }
    if (c.size() <= s.size() || s.compare(c.substr(0, s.size()))) {
      return false;
    }
    return _isAdditive(b, s, c.substr(s.size()));
  }

  string addString(string& a, string& b) {
    string s;
    int i = a.size() - 1, j = b.size() - 1, c = 0;
    while (i >= 0 || j >= 0) {
      int d = (i >= 0 ? (a[i--] - '0') : 0) + (j >= 0 ? (b[j--] - '0') : 0) + c;
      s += (d % 10 + '0');
      c = d / 10;
    }
    if (c) s += ('0' + c);
    reverse(s.begin(), s.end());
    return s;
  }
};

int main() {
  Solution sol;
  cout << sol.isAdditiveNumber("111") << endl;
  cout << sol.isAdditiveNumber("112358") << endl;
  cout << sol.isAdditiveNumber("199100199") << endl;
  cout << sol.isAdditiveNumber("101123581321345589144") << endl;
  return 0;
}

