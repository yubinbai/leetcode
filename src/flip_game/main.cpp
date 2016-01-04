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
};

int main() {
  Solution sol;
  string start = "++++";
  for (string s : sol.generatePossibleNextMoves(start)) {
    cout << s << endl;
  }
  return 0;
}
