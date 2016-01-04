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
};

int main() {
  Solution sol;
  string start = "++++";
  for (string s : sol.generatePossibleNextMoves(start)) {
    cout << s << endl;
  }
  return 0;
}
