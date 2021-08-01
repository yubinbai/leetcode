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
  int longestSubstring(string s, int k) {
    int counter[26] = {0};
    for (char c: s) {
      counter[c - 'a']++;
    }

    int pos;
    for (pos = 0; pos < s.size(); pos++) {
      if (counter[s[pos] - 'a'] < k) {
        break;
      }
    }
    if (pos == s.size()) {
      return s.size();
    }

    int left = 0;
    if (pos > 1) {
      left = longestSubstring(s.substr(0, pos), k);
    }
    int right = 0;
    if (pos < s.size()) {
      right = longestSubstring(s.substr(pos + 1), k);
    }
    return max(left, right);
  }
};

int main() {

  Solution sol;
  string s;
  int k;

  s = "aaabb", k = 3;
  cout << sol.longestSubstring(s, k) << endl;

  s = "ababbc", k = 2;
  cout << sol.longestSubstring(s, k) << endl;

  s = "abacbbb", k = 2;
  cout << sol.longestSubstring(s, k) << endl;

  s = "ababbcc", k = 2;
  cout << sol.longestSubstring(s, k) << endl;

  s = "adcefccc", k = 3;
  cout << sol.longestSubstring(s, k) << endl;

  return 0;
}
