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
  vector<string> anagrams(vector<string> strs) {
    vector<string> result;
    if (strs.size() == 0) {
      return result;
    }
    unordered_map<string, vector<string>> hm;
    for (auto s : strs) {
      string ss = s;
      sort(ss.begin(), ss.end());
      if (hm.count(ss)) {
        hm[ss].push_back(s);
      } else {
        vector<string> newList;
        newList.push_back(s);
        hm[ss] = newList;
      }
    }
    for (auto it : hm) {
      if (it.second.size() > 1) {
        for (auto str : it.second) {
          result.push_back(str);
        }
      }
    }
    return result;
  }
};

int main() {
  Solution sol;
  vector<string> strs = {"bac", "bb", "bb", "abc", "ss"};
  for (auto s : sol.anagrams(strs)) {
    cout << s << endl;
  }
  return 0;
}
