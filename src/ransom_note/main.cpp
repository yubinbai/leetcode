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
  bool canConstruct(string ransomNote, string magazine) {
    int count1[30] = {0};
    int count2[30] = {0};
    for (auto c: ransomNote) {
      count1[c - 'a']++;
    }
    for (auto c: magazine) {
      count2[c - 'a']++;
    }
    for (int i = 0; i < 26; i++) {
      if (count1[i] > count2[i]) {
        return false;
      }
    }
    return true;
  }
};

int main() {
  Solution sol;

  cout << sol.canConstruct("a", "b") << endl;
  cout << sol.canConstruct("aa", "ab") << endl;
  cout << sol.canConstruct("aa", "aab") << endl;

  return 0;
}
