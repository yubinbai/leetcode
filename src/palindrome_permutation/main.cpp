#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  bool canPermutePalindrome(string s) {
    int odd = 0, counts[256] = {0};
    for (char c : s) {
      odd += ++counts[c] & 1 ? 1 : -1;
    }
    return odd <= 1;
  }
};

int main() {
  Solution sol;
  cout << sol.canPermutePalindrome("code") << endl;
  cout << sol.canPermutePalindrome("aab") << endl;
  cout << sol.canPermutePalindrome("carerac") << endl;
  return 0;
}
