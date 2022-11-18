#include <cstdlib>
#include <iostream>
#include <list>
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
  bool validWordAbbreviation(string word, string abbr) {
    int i = 0, j = 0;
    int iter = 0;
    while (i < word.size() && j < abbr.size()) {
      if (abbr[j] >= '0' && abbr[j] <= '9') {
        if (abbr[j] == '0' && iter == 0) {
          return false;
        }
        while (j < abbr.size() && abbr[j] >= '0' && abbr[j] <= '9') {
          iter = 10 * iter + abbr[j] - '0';
          j++;
        }
        if (iter == 0) {
          return false;
        } else {
          i += iter;
          iter = 0;
        }
        if (iter != 0) {
          return false;
        }
      } else {
        if (word[i] == abbr[j]) {
          i++;
          j++;
        } else {
          return false;
        }
      }
    }
    return i == word.size() && j == abbr.size();
  }
};

int main(int argc, const char * argv[]) {
  Solution sol;
  string s, abbr;

  s = "internationalization", abbr = "i12iz4n";
  cout << sol.validWordAbbreviation(s, abbr) << endl;

  s = "apple", abbr = "a2e";
  cout << sol.validWordAbbreviation(s, abbr) << endl;

  s = "word", abbr = "4";
  cout << sol.validWordAbbreviation(s, abbr) << endl;

  s = "word", abbr = "45";
  cout << sol.validWordAbbreviation(s, abbr) << endl;

  s = "word", abbr = "wo0rd";
  cout << sol.validWordAbbreviation(s, abbr) << endl;

  s = "word", abbr = "wo0rd";
  cout << sol.validWordAbbreviation(s, abbr) << endl;

  s = "word", abbr = "wo01d";
  cout << sol.validWordAbbreviation(s, abbr) << endl;

  s = "word", abbr = "word";
  cout << sol.validWordAbbreviation(s, abbr) << endl;

  return 0;
}
