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
  bool canWinNim(int n) {
    return n % 4 != 0;
  }
  bool canWinNimDerivation(int n) {
    vector<int> memo = {false, true, true, true, false};
    for (int i = 5; i <= n; i++) {
      memo.push_back(false);
      for (int j = i - 1; j >= i - 3; j--) {
        if (memo[j] == false) {
          memo[i] = true;
        }
      }
    }
    return memo[n];
  }
};

int main() {
  Solution sol;
  for (int i = 4; i < 20; i++) {
    cout << i << ' ' << sol.canWinNim(i) << endl;
  }
  return 0;
}
