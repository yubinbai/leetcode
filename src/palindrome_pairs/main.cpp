#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<int>> palindromePairs(vector<string>& words) {
    vector<vector<int>> result;
    unordered_map<string, int> reversed;
    for (int i = 0; i < words.size(); ++i) {
      string t = words[i];
      reverse(t.begin(), t.end());
      reversed[t] = i;
    }

    for (int i = 0; i < words.size(); ++i) {
      string w = words[i];
      int len = w.size();

      if (reversed.count(w) && reversed[w] != i) {
        result.push_back({i, reversed[w]});
      }

      for (int d = 0; d < len; d++) {
        string right_half = w.substr(len - d);
        if (isPalindrome(w, 0, len - d - 1) && reversed.count(right_half)) {
          result.push_back({reversed[right_half], i});
        }
        string left_half = w.substr(0, d);
        if (isPalindrome(w, d, len - 1) && reversed.count(left_half)) {
          result.push_back({i, reversed[left_half]});
        }
      }
    }
    return result;
  }

  bool isPalindrome(string t, int left, int right) {
    while (left < right) {
      if (t[left++] != t[right--]) {
        return false;
      }
    }
    return true;
  }
};

int main() {
  Solution sol;
  vector<string> words;

  words = {"bat", "tab", "cat"};
  for (auto &v: sol.palindromePairs(words)) {
    cout << v[0] << "," << v[1] << endl;
  }

  words = {"abcd", "dcba", "lls", "s", "sssll"};
  for (auto &v: sol.palindromePairs(words)) {
    cout << v[0] << "," << v[1] << endl;
  }

  return 0;
}
