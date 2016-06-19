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
  int lengthOfLongestSubstring(string s) {
    vector<bool> used(256, false);
    int result = 0;
    int start = 0, end = 0;
    for (; end < s.length(); end++) {
      if (used[s[end]]) {
        result = max(result, end - start);
        while (used[s[end]]) {
          used[s[start]] = false;
          start++;
        }
      }
      used[s[end]] = true;
    }
    result = max(result, (int)s.length() - start);
    return result;
  }
};


int main() {
  Solution sol;
  cout << sol.lengthOfLongestSubstring("abcabcbb") << endl;
  cout << sol.lengthOfLongestSubstring("bcbcbabc") << endl;
  return 0;
}
