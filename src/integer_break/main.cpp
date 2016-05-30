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
  int integerBreak(int n) {
    switch (n) {
    case 2: 
      return 1;
    case 3: 
      return 2;
    case 4: 
      return 4;
    }
    int ret = 1;
    while (n >= 5) {
      n -= 3;
      ret *= 3;
    }
    ret *= n;
    return ret;
  }
};

int main() {
  Solution sol;

  for (int i = 2; i < 11; i++) {
    cout << i << " " << sol.integerBreak(i) << endl;
  }

  return 0;
}
