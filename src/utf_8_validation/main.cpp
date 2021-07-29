#include <cstdlib>
#include <iostream>
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
  bool validUtf8(vector<int>& data) {
    int carry = 0;
    for (int d : data) {
      if (carry == 0) {
        if ((d >> 3) == 0b11110) {
          carry = 3;
        } else if ((d >> 4) == 0b1110) {
          carry = 2;
        } else if ((d >> 5) == 0b110) {
          carry = 1;
        } else if ((d >> 7) == 0b0) {
          carry = 0;
        } else {
          return false;
        }
      } else {
        if ((d >> 6) != 0b10) {
          return false;
        }
        carry--;
      }
    }
    return carry == 0;
  }
};

int main() {

  Solution sol;
  vector<int> data;

  data = {197,130,1};
  cout << sol.validUtf8(data) << endl;

  data = {235,140,4};
  cout << sol.validUtf8(data) << endl;

  data = {235,140,130,4};
  cout << sol.validUtf8(data) << endl;

  data = {140,130,4};
  cout << sol.validUtf8(data) << endl;

  return 0;
}
