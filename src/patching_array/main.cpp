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
  int minPatches(vector<int>& nums, int n) {
    long curr = 0;
    int count = 0;
    int i = 0;
    while (curr < n) {
      if (nums.size() == 0 ||
          i == nums.size() ||
          (i < nums.size() && nums[i] > curr + 1)) {
        count++;
        curr = curr * 2 + 1;
      } else {
        curr += nums[i];
        i++;
      }
    }
    return count;
  }
};

int main() {
  Solution sol;
  vector<int> nums = {1, 3};
  cout << sol.minPatches(nums, 6) << endl;

  nums = {1, 2, 2};
  cout << sol.minPatches(nums, 5) << endl;

  nums = {};
  cout << sol.minPatches(nums, 7) << endl;

  nums = {1, 2, 31, 33};
  cout << sol.minPatches(nums, 2147483647) << endl;
  return 0;
}
