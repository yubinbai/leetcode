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

bool isWhiteSpace(char c) {
  switch(c) {
  case ' ':
  case '\n':
  case '\r':
  case '\t':
    return true;
  default:
    return false;
  }
}

class Solution {
public:
  int atoi(string str) {
    if (str.empty()) {
      return 0;
    }

    // trim white spaces
    str.erase(
      std::remove_if(str.begin(), str.end(), &isWhiteSpace),
      str.end()
    );

    char flag = '+';

    // check negative or positive
    int i = 0;
    if (str[0] == '-') {
      flag = '-';
      i++;
    } else if (str[0] == '+') {
      i++;
    }
    // use double to store result
    double result = 0;

    // calculate value
    while (str.length() > i && str[i] >= '0' && str[i] <= '9') {
      result = result * 10 + (str[i] - '0');
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

  cout << INT_MAX << endl;
  cout << INT_MIN << endl;

  return 0;
}
