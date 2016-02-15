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
    vector<bool> seen(30, false);
    for (char c: s) {
      count[c - 'a']++;
    }

    string ans = "";
    for (char c: s) {
      int index = c - 'a';
      count[index]--;
      if (seen[index]) {
        continue;
      }
      while (!ans.empty() && ans.back() > c && count[ans.back() - 'a'] > 0) {
        seen[ans.back() - 'a'] = false;
        ans.pop_back();
      }
      ans.push_back(c);
      seen[index] = true;
    }
    return ans;
  }
};

int main() {
  Solution sol;
  cout << sol.removeDuplicateLetters("bcabc") << endl;
  cout << sol.removeDuplicateLetters("cbacdcbc") << endl;
  return 0;
}

