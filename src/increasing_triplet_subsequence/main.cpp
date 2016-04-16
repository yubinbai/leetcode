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
  bool increasingTriplet(vector<int>& nums) {
    if (nums.empty()) {
      return false;
    }
    int m1 = nums[0], m2 = INT_MAX;
    for (int i = 1; i < nums.size(); i++) {
      if (nums[i] > m2) {
        return true;
      }
      if (nums[i] > m1 && nums[i] < m2) {
        m2 = nums[i];
      } else if (nums[i] < m1) {
        m1 = nums[i];
      }
    }
    return false;
  }
};

int main() {
  Solution sol;

  vector<int> nums = {1, 2, 3, 4, 5};
  cout << sol.increasingTriplet(nums) << "\n";

  nums = {5, 4, 3, 2, 1};
  cout << sol.increasingTriplet(nums) << "\n";

  return 0;
}
