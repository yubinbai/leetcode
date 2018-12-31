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
  int atoi(string str) {
    if (str.empty()) {
      return 0;
    }

    // trim white spaces
    string s;
    for (auto c : str) {
      switch(c) {
      case ' ':
      case '\n':
      case '\r':
      case '\t':
        continue;
      default:
        s.push_back(c);
      }
    }

    char flag = '+';

    // check negative or positive
    int i = 0;
    if (s[0] == '-') {
      flag = '-';
      i++;
    } else if (s[0] == '+') {
      i++;
    }
    // use double to store result
    double result = 0;

    // calculate value
    while (s.length() > i && s[i] >= '0' && s[i] <= '9') {
      result = result * 10 + (s[i] - '0');
      i++;
    }

    if (flag == '-')
      result = -result;

    // handle max and min
    if (result > INT_MAX) {
      return INT_MAX;
    }

    if (result < INT_MIN) {
      return INT_MIN;
    }

    return (int) result;
  }
};

int main() {
  Solution sol;

  cout << sol.atoi("  ") << endl;
  cout << sol.atoi("100") << endl;
  cout << sol.atoi("  100") << endl;
  cout << sol.atoi("abc100") << endl;
  cout << sol.atoi("122def") << endl;

  return 0;
}
