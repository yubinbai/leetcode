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
  vector<int> nums, bit;
  int n;
  int sum(int i) {
    int s = 0;
    while (i > 0) {
      s += bit[i];
      i -= i & -i;
    }
    return s;
  }
    
  void add(int i, int x) {
    while (i <= n) {
      bit[i] += x;
      i += i & -i;
    }
  }
    
public:
  NumArray(vector<int> &nums) {
    this->nums = nums;
    this->n = nums.size();
    for (int i = 0; i <= n; i++) {
      bit.push_back(0);
    }
    for (int i = 0; i < n; i++) {
      add(i + 1, nums[i]);
    }
  }
    
  void update(int i, int val) {
    add(i + 1, val - nums[i]);
    nums[i] = val;
  }
    
  int sumRange(int i, int j) {
    return sum(j + 1) - sum(i);
  }
};


int main() {
  vector<int> nums = {1, 3, 5};
  NumArray numArray(nums);
  cout << numArray.sumRange(0, 2) << endl;
  numArray.update(1, 2);
  cout << numArray.sumRange(0, 2) << endl;
  return 0;
}
