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

class NumArray {
private:
  vector<int> sums;
public:
  NumArray(vector<int> &nums) {
    if (nums.size() == 0) {
      return;
    }
    sums.push_back(nums[0]);
    for (int i = 1; i < nums.size(); i++) {
      sums.push_back(nums[i] + sums.back());
    }
  }

  int sumRange(int i, int j) {
    int n = sums.size();
    if (i < 0 || i >= n || j < 0 || j >= n || i > j) {
      return -1;
    }
    if (i == 0) {
      return sums[j];
    } else {
      return sums[j] - sums[i - 1];
    }
  }
};

int main() {
  vector<int> nums = {-2, 0, 3, -5, 2, -1};
  NumArray numArray(nums);
  cout << numArray.sumRange(0, 1) << endl;
  cout << numArray.sumRange(1, 2) << endl;
  return 0;
}
