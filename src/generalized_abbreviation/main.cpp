#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
private:
  vector<string> ans;
  vector<char> stack;
  int n;
  string word;

  void _generate(int p) {
    if (p == n) {
      ans.push_back(string(stack.begin(), stack.end()));
      return;
    }

    stack.push_back(word[p]);
    _generate(p + 1);
    stack.pop_back();

    if (stack.empty() ||
        (stack.back() >= 'a' && stack.back() <= 'z')) {
      for (int len = 1; len <= n - p; len++) {
        stack.push_back((char)(len + '0'));
        _generate(p + len);
        stack.pop_back();
      }
    }
  }

public:
  vector<string> generalizedAbbr(string word) {
    n = word.size();
    this->word = word;
    ans.clear();
    stack.clear();
    _generate(0);
    return ans;    
  }
};

int main() {
  Solution sol;
  for (string s: sol.generalizedAbbr("word")) {
    cout << s << endl;
  }
  return 0;
}

