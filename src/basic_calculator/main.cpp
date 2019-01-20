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
  int calculate(string exp) {
    vector<long> signs;
    long total = 0, curr_sign = 1, prev_sign = 1;
    exp = "+" + exp;
    string s = "";
    for (char c : exp) {
      if (c >= '0' && c <= '9') {
        s.push_back(c);
        continue;
      }
      if (s.size() > 0) {
        long t = stol(s);
        total += curr_sign * prev_sign * t;
        s = "";
      }
      switch (c) {
      case '+':
        prev_sign = 1;
        break;
      case '-':
        prev_sign = -1;
        break;
      case '(':
        signs.push_back(prev_sign);
        curr_sign *= prev_sign;
        prev_sign = 1;
        break;
      case ')':
        curr_sign *= signs.back();
        signs.pop_back();
        break;
      case ' ':
        continue;
      }
    }
    if (s.size() > 0) {
      long t = stol(s);
      total += curr_sign * prev_sign * t;
    }
    return (int) total;
  }
};
 
int main() {
  Solution sol;

  cout << sol.calculate("1-1") << endl;
  cout << sol.calculate(" 2-(1 + 2) ") << endl;
  cout << sol.calculate("(1+(4+5+2)-3)+(6+8)") << endl;
  cout << sol.calculate("1 + 1") << endl;
  cout << sol.calculate(" 2-1 + 2 ") << endl;

  return 0;
}
