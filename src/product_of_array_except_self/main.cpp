#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> productExceptSelf(vector<int>& nums) {
    int len = nums.size();
    vector<int> ret(len, 0);
    ret[0] = 1;
    for (int i = 1; i < len; i++) {
      ret[i] = nums[i - 1] * ret[i - 1];
    }
    int right = 1;
    for (int i = len - 2; i >= 0; i--) {
      right *= nums[i + 1];
      ret[i] *= right;
    }
    return ret;
  }
};

int main() {
  Solution sol;
  vector<int> test {1, 2, 3, 4};
  vector<int> result = sol.productExceptSelf(test);
  for (auto& i : result) {
    cout << i << endl;
  }
  return 0;
}
