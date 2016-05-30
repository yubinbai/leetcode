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
  string reverseVowels(string s) {
    int i = 0, j = s.size() - 1;
    set<char> vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
    char t;
    do {
      while (!vowels.count(s[i]) && i < j) {
        i++;
      }
      while (!vowels.count(s[j]) && i < j) {
        j--;
      }
      t = s[i];
      s[i] = s[j];
      s[j] = t;
      i++;
      j--;
    } while (i < j);
    return s;   
  }
};

int main() {
  Solution sol;

  cout << sol.reverseVowels("hello") << endl;

  cout << sol.reverseVowels("leetcode") << endl;

  return 0;
}
