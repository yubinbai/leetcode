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
  int wiggleMaxLength(vector<int>& nums) {
    int small[1001] = {};
    int large[1001] = {};
    int n = nums.size();
    small[0] = 1;
    large[0] = 0;
    for (int i = 1; i < n; i++) {
      small[i] = 1;
      large[i] = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] < nums[j]) {
          small[i] = max(small[i], large[j] + 1);
        } else if (nums[i] > nums[j]) {
          large[i] = max(large[i], small[j] + 1);
        } else {
          // (nums[i] == nums[j]) 
          small[i] = max(small[i], large[j]);
          large[i] = max(large[i], small[j]);
        }
      }
    }

    int m = 0;
    for (int i = 0; i < n; i++) {
      m = max(m, small[i]);
      m = max(m, large[i]);
    }
    return m;
  }
};

int main() {
  Solution sol;

  vector<int> nums = {1, 2};
  cout << sol.wiggleMaxLength(nums) << endl;

  nums = {1,7,4,9,2,5};
  cout << sol.wiggleMaxLength(nums) << endl;

  nums = {};
  cout << sol.wiggleMaxLength(nums) << endl;

  nums = {1};
  cout << sol.wiggleMaxLength(nums) << endl;

  nums = {1,2,3,4,5,6,7,8,9};
  cout << sol.wiggleMaxLength(nums) << endl;

  nums = {1, 7, 4, 5, 5};
  cout << sol.wiggleMaxLength(nums) << endl;

  nums = {1,17,5,10,13,15,10,5,16,8};
  cout << sol.wiggleMaxLength(nums) << endl;

  cout << endl;

  return 0;
}
