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
private:
  int counter[26] = {0};
  bool isValid(int k) {
    for (int i = 0; i < 26; i++) {
      if (counter[i] > 0 && counter[i] < k) {
        return false;
      }
    }
    return true;
  }
public:
  int longestSubstring(string s, int k) {
    int ret = 0;
    for (int start = 0; start < s.size(); start++) {
      memset(counter, 0, sizeof(counter));
      for (int end = start; end < s.size(); end++) {
        counter[s[end] - 'a']++;
        if (isValid(k)) {
          ret = max(ret, end - start + 1);
        }
      }
    }
    return ret;
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

  return 0;
}
