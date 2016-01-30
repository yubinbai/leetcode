#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
private:
  unordered_set<string> res;
  string str;
  int max_len = 0;
  void _dfs(int start, int balance, vector<char> curr) {
    if (start == str.size()) {
      if(balance == 0) {
        string result(curr.begin(), curr.end());
        if (result.size() > max_len) {
          max_len = result.size();
          res.clear();
          res.insert(result);
        } else if (result.size() == max_len) {
          res.insert(result);
        }
      }
      return;
    }
    if (str.size() - start + curr.size() < max_len) {
      return;
    }

    char c = str[start];
    switch(c) {
    case '(':
      curr.push_back(c);
      _dfs(start + 1, balance + 1, curr);
      curr.pop_back();
      _dfs(start + 1, balance, curr);
      break;
    case ')':
      if (balance <= 0) {
        _dfs(start + 1, balance, curr);
      } else {
        curr.push_back(c);
        _dfs(start + 1, balance - 1, curr);
        curr.pop_back();
        _dfs(start + 1, balance, curr);
      }
      break;
    default:
      curr.push_back(c);
      _dfs(start + 1, balance, curr);
    }
  }
public:
  vector<string> removeInvalidParentheses(string s) {
    res.clear();
    str = s;
    vector<char> curr;
    _dfs(0, 0, curr);
    vector<string> ret(res.begin(), res.end());
    return ret;
  }
};

int main() {
  Solution sol;
  for (string s: sol.removeInvalidParentheses("()())()")) {
    cout << s << endl;
  }
  for (string s: sol.removeInvalidParentheses("(a)())()")) {
    cout << s << endl;
  }
  for (string s: sol.removeInvalidParentheses(")(")) {
    cout << s << endl;
  }
  return 0;
}
