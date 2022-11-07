#include <cstdlib>
#include <iostream>
#include <list>
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
  string toHex(int num) {
    char c[8] = {0};
    for (int i = 7; i >= 0; i--) {
      int digit = num & 0x0F;
      if (digit < 10) {
        c[i] = digit + '0';
      } else {
        c[i] = digit - 10 + 'a';
      }
      num = num >> 4;
    }
    bool first_digit = false;
    string ret;
    for (int i = 0; i < 8; i++) {
      if (c[i] != '0') {
        first_digit = true;
      }
      if (first_digit) {
        ret.push_back(c[i]);
      }
    }
    if (ret.size() > 0) {
      return ret;
    } else {
      return "0";
    }
  }
};

int main(int argc, const char * argv[]) {
  Solution sol;
  int num;

  num = 26;
  cout << sol.toHex(num) << endl;

  num = -1;
  cout << sol.toHex(num) << endl;

  num = 0;
  cout << sol.toHex(num) << endl;

  return 0;
}
