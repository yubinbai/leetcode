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
  string rearrangeString(string str, int k) {
    if (k == 0) {
      return str;
    }

    unordered_map<char, int> counter;
    for (auto c : str) {
      ++counter[c];
    }
    priority_queue<pair<int, char>> q;
    for (auto it = counter.begin(); it != counter.end(); ++it) {
      q.push({it->second, it->first});
    }

    int len = (int)str.size();
    string res;
    vector<pair<int, char>> v;
    while (!q.empty()) {
      v.clear();
      int len_to_construct = min(k, len);
      for (int i = 0; i < len_to_construct; ++i) {
        if (q.empty()) {
          return "";
        }
        auto t = q.top();
        q.pop();
        res.push_back(t.second);
        if (--t.first > 0) {
          v.push_back(t);
        }
        --len;
      }
      for (auto a : v) {
        q.push(a);
      }
    }
    return res;
  }
};

int main() {
  Solution sol;

  cout << sol.rearrangeString("aabbcc", 3) << endl;
  cout << sol.rearrangeString("aaabc", 3) << endl;
  cout << sol.rearrangeString("aaadbbcc", 2) << endl;

  return 0;
}
