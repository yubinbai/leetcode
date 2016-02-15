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
  string removeDuplicateLetters(string s) {
    vector<int> count(30, 0);
    vector<char> vs(s.begin(), s.end());
    for (char c: vs) {
      count[c - '0']++;
    }

    vector<bool> seen(30, false);
    vector<char> ans;
    for (char c: vs) {
      int index = c - '0';
      count[index]--;
      if (seen[index]) {
        continue;
      }
      while (!ans.empty() && ans.back() > c && count[ans.back() - '0'] > 0) {
        seen[ans.back() - '0'] = false;
        ans.pop_back();
      }
      ans.push_back(c);
      seen[index] = true;
    }

    return string(ans.begin(), ans.end());
  }
};

int main() {
  Solution sol;
  cout << sol.removeDuplicateLetters("bcabc") << endl;
  cout << sol.removeDuplicateLetters("cbacdcbc") << endl;
  return 0;
}

