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
  unordered_map<string, bool> memo;
public:
  vector<string> generatePossibleNextMoves(string s) {
    vector<string> ret;
    for (int i = 0; i < s.size() - 1; i++) {
      if (s[i] == '+' && s[i + 1] == '+'){
        string ss = s;
        ss[i] = '-';
        ss[i + 1] = '-';
        ret.push_back(ss);
      }
    }
    return ret;
  }

  bool canWinNim(string s) {
    if (memo.count(s) > 0) {
      return memo[s];
    }
    for (string s2 : generatePossibleNextMoves(s)) {
      if (!canWinNim(s2)) {
        return true;
      }
    }
    return memo[s] = false;
  }
};

int main() {
  Solution sol;
  string start = "++++";
  cout << sol.canWinNim(start) << endl;
  return 0;
}
