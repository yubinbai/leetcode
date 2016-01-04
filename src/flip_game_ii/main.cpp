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
    int n = s.size(), i = 0;
    vector<string> ret;
 
    while ( i < n - 1) {
      if(s[i]=='+' && s[i + 1] == '+'){
        string ss = s;
        ss[i]='-';
        ss[i + 1]='-';
        ret.push_back(ss);
      }
      i++;
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
