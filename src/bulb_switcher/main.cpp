#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
  int bulbSwitch(int n) {
    int len = 3, state = 0;
    int curr = 0;
    while (n > curr) {
      curr += len;
      len += 2;
      state++;
    }
    return state;
  }

  int bulbSwitchBruteForce(int n) {
    vector<bool> state(n + 1, false);
    for (int i = 1; i <= n; i++) {
      for (int j = i; j <= n; j += i) {
        state[j] = !state[j];
      }
    }
    int ans = 0;
    for (int i = 1; i <=n; i++) {
      if (state[i]) {
        ans++;
      }
    }
    return ans;
  }
};

int main() {
  Solution sol;
  for (int i = 1; i < 30; i++) {
    cout << i << " " << sol.bulbSwitch(i) << endl;
    cout << i << " " << sol.bulbSwitchBruteForce(i) << endl;
  }
  return 0;
}

