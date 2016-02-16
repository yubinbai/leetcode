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
public:
  int maxProduct(vector<string>& words) {
    int n = words.size();
    vector<int> alphabet(n, 0);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < words[i].length(); j++) {
        alphabet[i] |= 1 << (words[i][j] - 'a');
      }
    }
    unsigned long ans = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if ((alphabet[i] & alphabet[j]) == 0) {
          ans = max(ans, words[i].size() * words[j].size());
        }
      }
    }
    return (int)ans;
  }
};

int main() {
  Solution sol;
  vector<string> words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
  cout << sol.maxProduct(words) << endl;
  return 0;
}

