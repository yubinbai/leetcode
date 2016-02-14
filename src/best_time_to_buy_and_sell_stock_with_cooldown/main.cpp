#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
  int maxProfit(vector<int>& prices) {
    int n = prices.size();
    if (n == 0 || n == 1) {
      return 0;        
    }

    vector<int> profitNoStock(n, 0);
    // profitNoStock[i] the maximum profit when no stock after day i.
    vector<int> profitWithStock(n, 0); 
    // profitWithStock[i] the maximum profit when have stock after day i

    //day 0
    profitNoStock[0] = 0;
    profitWithStock[0] = -prices[0];

    //day 1
    profitNoStock[1] = max(profitNoStock[0], profitWithStock[0] + prices[1]);
    profitWithStock[1] = max(profitWithStock[0], profitNoStock[0] - prices[1]);

    for (int i = 2; i < n; ++i) {
      profitNoStock[i] = max(profitNoStock[i - 1], profitWithStock[i - 1] + prices[i]);
      profitWithStock[i] = max(profitWithStock[i - 1], profitNoStock[i - 2] - prices[i]);
    }

    return profitNoStock[n-1];
  }
};

int main() {
  Solution sol;
  vector<int> prices = {1, 2, 3, 0, 2};
  cout << sol.maxProfit(prices) << endl;
  return 0;
}
