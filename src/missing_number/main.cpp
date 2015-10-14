#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  int missingNumber(vector<int>& nums) {
    int n = nums.size();
    int result = 0;
    for (int i = 0; i < n; i++) {
      result ^= i;
      result ^= nums[i];
    }
    result ^= n;
    return result;
  }
};

int main() {
  Solution sol;
  vector<int> nums = {0, 1, 3};
  cout << sol.missingNumber(nums) << endl;
  return 0;
}
