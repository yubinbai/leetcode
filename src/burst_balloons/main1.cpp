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
private:
  vector<int> nums;
  unordered_map<int, int> memo;
  int n;
  int _maxCoins(int start, int end) {
    int hash_key = start | (end << 16);
    if (memo.count(hash_key) > 0) {
      return memo[hash_key];
    }

    int ans = 0;
    // decision: last balloon
    for (int last_balloon = start; last_balloon <= end; last_balloon++) {
      int curr_ans =
        _maxCoins(start, last_balloon - 1) +
        _maxCoins(last_balloon + 1, end) +
        nums[last_balloon] * nums[start - 1] * nums[end + 1];
      ans = max(ans, curr_ans);
    }
    return memo[hash_key] = ans;
  }
public:
  int maxCoins(vector<int>& nums) {
    n = nums.size();
    nums.insert(nums.begin(), 1);
    nums.push_back(1);
    this->nums = nums;
    return _maxCoins(1, n);
  }
};

int main() {
  Solution sol;
  vector<int> nums = {3, 1, 5, 8};
  cout << sol.maxCoins(nums) << endl;
  return 0;
}
