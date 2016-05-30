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
  string reverseString(string s) {
    int i = 0, j = s.size() - 1;
    char t;
    while (i < j) {
      t = s[i];
      s[i] = s[j];
      s[j] = t;
      i++;
      j--;
    }
    return s;   
  }
};

int main() {
  Solution sol;

  cout << sol.reverseString("hello");

  return 0;
}
