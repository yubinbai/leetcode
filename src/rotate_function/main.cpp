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
  int maxRotateFunction(vector<int>& nums) {
    vector<int> sum;
    int s = 0;
    for (int i: nums) {
      s += i;
      sum.push_back(s);
    }

    int n = nums.size();
    int ret = 0;
    for (int i = 0; i < n; i++) {
      ret += i * nums[i];
    }

    int curr = ret;
    for (int k = 1; k < n; k++) {
      curr = curr + sum[n - k - 1] - (n - 1) * nums[n - k] + (sum[n - 1] - sum[n - k]);
      ret = max(ret, curr);
    }
    return ret;
  }
};

int main() {
  Solution sol;
  vector<int> nums;

  nums = {4,3,2,6};
  cout << sol.maxRotateFunction(nums) << endl;

  nums = {100};
  cout << sol.maxRotateFunction(nums) << endl;

  return 0;
}
