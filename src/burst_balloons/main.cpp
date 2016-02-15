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
  int maxCoins(vector<int>& nums) {
    int n = nums.size();
    nums.insert(nums.begin(), 1);
    nums.push_back(1);
    vector<vector<int>> memo(n + 2, vector<int>(n + 2 , 0));

    for (int len = 1; len <= n; ++len) {
      for (int left = 1; left <= n - len + 1; ++left) {
        int right = left + len - 1;
        for (int last_balloon = left; last_balloon <= right; ++last_balloon) {
          int curr_ans =
            nums[left - 1] * nums[last_balloon] * nums[right + 1] +
            memo[left][last_balloon - 1] +
            memo[last_balloon + 1][right];
          memo[left][right] = max(memo[left][right], curr_ans);
        }
      }
    }
    return memo[1][n];
  }
};

int main() {
  Solution sol;
  vector<int> nums = {3, 1, 5, 8};
  cout << sol.maxCoins(nums) << endl;
  return 0;
}
