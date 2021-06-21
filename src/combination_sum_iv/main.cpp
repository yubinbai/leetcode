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
  int combinationSum4(vector<int>& nums, int target) {
    int32_t dp[1001] = {0};
    dp[0] = 1;
    for (int i = 1; i <= target; i++) {
      for (int j: nums) {
        if (i - j >= 0) {
          dp[i] += dp[i - j];
        }
      }
    }
    return dp[target];
  }
};

int main() {
  Solution sol;
  vector<int> vi = {1,2,3};
  int target = 4;
  cout << sol.combinationSum4(vi, target) << endl;

  vi = {9};
  target = 3;
  cout << sol.combinationSum4(vi, target) << endl;
  return 0;
}
