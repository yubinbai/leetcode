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
  int lengthOfLongestSubstringKDistinct(string s, int k) {
    unordered_map<char, int> chars;
    int start = 0;
    int max_len = 0;
    for (int i = 0; i < s.length(); ++i) {
      ++chars[s[i]];
      if (chars.size() <= k) {
        max_len = max(max_len, i - start + 1);
      } else {
        while (chars.size() > k) {
          --chars[s[start]];
          if (chars[s[start]] == 0) {
            chars.erase(s[start]);
          }
          ++start;
        }
      }
    }
    return max_len;
  }
};

int main() {
  Solution sol;
  cout << sol.lengthOfLongestSubstringKDistinct("eceba", 3);
  return 0;
}
