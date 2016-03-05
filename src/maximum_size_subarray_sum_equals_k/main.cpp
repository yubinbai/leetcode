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
  int maxSubArrayLen(vector<int> &nums, int k) {
    if (nums.size() == 0) {
      return 0;
    }
    map<int, int> length_map;
    length_map[0] = -1;

    int sum = 0;
    int max_len = INT_MIN;
    for (int i = 0; i < nums.size(); i++) {
      sum += nums[i];
      if (!length_map.count(sum)) {
        length_map[sum] = i;
      }
      if (length_map.count(sum-k) > 0) {
        max_len = max(max_len, i-length_map[sum - k]);
      }
    }
    return max_len == INT_MIN ? 0 : max_len;
  }
};

int main() {
  Solution sol;
  vector<int> arr = {1, -1, 5, -2, 3};
  cout << sol.maxSubArrayLen(arr, 3) << endl;

  arr = {-2, -1, 2, 1};
  cout << sol.maxSubArrayLen(arr, 1) << endl;
  return 0;
}
