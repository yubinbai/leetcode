#include <cstdlib>
#include <iostream>
#include <map>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  int threeSumSmaller(vector<int>& nums, int target) {
    sort(nums.begin(), nums.end());
    int n = nums.size(), ans = 0;
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1, k = n - 1;
      int curr = target - nums[i];
      while (j < k) {
        if (nums[j] + nums[k] >= curr) {
          k--;
        } else {
          ans += (k - j);
          j++;
        }
      }
    }
    return ans;
  }
};

int main() {
  Solution sol;
  vector<int> v = {-2, 0, 1, 3};
  cout << sol.threeSumSmaller(v, 2) << endl;
  return 0;
}
