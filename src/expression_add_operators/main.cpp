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
  vector<string> ret;
  string num;
  long long target;
public:
  vector<string> addOperators(string num, int target) {
    this->num = num;
    this->target = target;
    backtrack(0, 0, 0, "");
    return ret;
  }
  void backtrack(int p, long long val, long long prev, string cur) {
    int n = num.size();
    if (p == n) {
      if(val == target) {
        ret.push_back(cur);
      }
      return;
    }
    // iterate over a possible next term
    for (int i = p; i < n; ++i) {
      string n1 = num.substr(p, i - p + 1);
      if (n1.size() > 1 && n1[0] == '0') {
        // this digit is 0, move to next digit
        continue;
      }
      if (p == 0) {
        backtrack(i + 1, stoll(n1), stoll(n1), n1);
      } else {
        backtrack(i + 1, val + stoll(n1), stoll(n1), cur + "+" + n1);
        backtrack(i + 1, val - stoll(n1), -stoll(n1), cur + "-" + n1);
        backtrack(i + 1, (val - prev) + prev * stoll(n1),
                  prev * stoll(n1), (cur.empty() ? cur : cur + "*") + n1);
      }
    }
  }
};

int main() {
  Solution sol;
  vector<string> results = sol.addOperators("123", 6);
  for (string s : results) {
    cout << s << endl;
  }
  return 0;
}
