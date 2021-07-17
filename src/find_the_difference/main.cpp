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
  char findTheDifference(string s, string t) {
    int counter[30] = {0};
    for (char c: t) {
      counter[c - 'a']++;
    }
    for (char c: s) {
      counter[c - 'a']--;
    }
    for (int i = 0; i < 26; i++) {
      if (counter[i] == 1) {
        return (char)(i + 'a');
      }
    }
    throw;
  }
};


int main() {

  Solution sol;
  string s;
  string t;

  s = "abcd", t = "abcde";
  cout << sol.findTheDifference(s, t) << endl;

  s = "", t = "y";
  cout << sol.findTheDifference(s, t) << endl;

  s = "a", t = "aa";
  cout << sol.findTheDifference(s, t) << endl;

  s = "ae", t = "aea";
  cout << sol.findTheDifference(s, t) << endl;

  return 0;
}
