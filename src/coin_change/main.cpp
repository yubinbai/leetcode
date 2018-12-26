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
  int coinChange(vector<int>& coins, int amount) {
    vector<int> dp(amount + 1, amount + 1);
    dp[0] = 0;
    for (int c : coins) {
      for (int i = c; i <= amount; i++) {
        dp[i] = min(dp[i], dp[i - c] + 1);
      }
    }
    return dp[amount] == amount + 1 ? -1 : dp[amount];
  }
};

int main() {
  Solution sol;
  vector<int> coins = {1, 2, 5};
  cout << sol.coinChange(coins, 11) << endl;

  vector<int> coins2 = {10};
  cout << sol.coinChange(coins2, 4) << endl;
  return 0;
}
