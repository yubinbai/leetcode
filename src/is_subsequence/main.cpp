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
  bool isSubsequence(string s, string t) {
    int i = 0, j = 0;
    while (i < s.size() && j < t.size()) {
      if (s[i] == t[j]) {
        i++;
      }
      j++;
    }
    return i == s.size();
  }
};

int main() {

  Solution sol;
  string s, t;

  s = "abc", t = "ahbgdc";
  cout << sol.isSubsequence(s, t) << endl;

  s = "axc", t = "ahbgdc";
  cout << sol.isSubsequence(s, t) << endl;

  return 0;
}
