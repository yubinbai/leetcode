#include <cstdlib> 
#include <iostream>
#include <map>
#include <set> 
#include <string> 
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
public:
  vector<vector<string>> groupStrings(vector<string>& strings) {
    unordered_map<string, multiset<string>> groups;
    for (const auto& str : strings) {
      groups[hashStr(str)].insert(str);
    }
        
    vector<vector<string>> result;
    for (const auto& kvp : groups) {
      vector<string> group;
      for (auto& str : kvp.second) {
        group.emplace_back(move(str));
      }
      result.emplace_back(move(group));
    }
        
    return result;
  }
    
  string hashStr(string str) {
    const char base = str[0];
    for (auto& c : str) {
      c = 'a' + ((c - base) >= 0 ? c - base : c - base + 26);
    }
    return str;
  }
};

int main() {
  Solution sol;
  vector<string> strs = {
    "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"
  };

  vector<vector<string>> result = sol.groupStrings(strs);
  for (auto vs : result) {
    cout << "[ ";
    for (auto s : vs) {
      cout << s << " ";
    }
    cout << "]" << endl;
  }
  return 0;
}
