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
  int m, n;
  string str, pat;
  unordered_set<string> st;
  unordered_map<char, string> mp;

  bool match(int i, int j) {
    if (i == m && j == n) {
      return true;
    }
    if (i == m || j == n) {
      return false;
    }

    char c = pat[j];
    if (mp.find(c) != mp.end()) {
      string s = mp[c];
      int word_size = s.length();
      if (s != str.substr(i, word_size)) {
        return false;
      }
      return match(i + word_size, j + 1);
    } 

    for (int k = i; k < m; k++) {
      string s = str.substr(i, k - i + 1);
      if (st.find(s) != st.end()) {
        continue;
      }
      st.insert(s);
      mp[c] = s;
      if (match(k + 1, j + 1)) {
        return true;
      }
      st.erase(s);
      mp.erase(c);
    }
    return false;
  }

public:
  bool wordPatternMatch(string pattern, string str) {
    m = str.length();
    n = pattern.length();
    this->str = str;
    this->pat = pattern;
    return match(0, 0);
  }
};

int main() {
  string pattern = "abab";
  string str = "redblueredblue";
  Solution sol;
  cout << sol.wordPatternMatch(pattern, str) << endl;
  return 0;
}
