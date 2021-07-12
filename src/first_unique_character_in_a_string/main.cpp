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
  int firstUniqChar(string s) {
    int count[30] = {0};
    int pos[30];
    for (int i = 0; i < 30; i++) {
      pos[i] = s.size();
    }

    for (int i = 0; i < s.size(); i++) {
      char c = s[i];
      count[c - 'a']++;
      pos[c - 'a'] = i;
    }
    int ret = s.size();
    for (int i = 0; i < 26; i++) {
      if (count[i] == 1) {
        ret = min(ret, pos[i]);
      }
    }
    if (ret == s.size()) {
      return -1;
    } else {
      return ret;
    }
  }
};

int main() {
  Solution sol;
  cout << sol.firstUniqChar("leetcode") << endl;

  cout << sol.firstUniqChar("loveleetcode") << endl;

  cout << sol.firstUniqChar("aabb") << endl;
  return 0;
}
