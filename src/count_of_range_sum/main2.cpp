#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class BinaryIndexedTree {
  vector<int> bit;
  int n;
  inline int lowbit(int x) {
    return x & -x;
  }

public:
  BinaryIndexedTree(int n) {
    this->n = n;
    this->bit = vector<int>(n + 1, 0);
  }

  void add(int i, int x) {
    while (i <= n) {
      bit[i] += x;
      i += lowbit(i);
    }
  }

  int sum(int i) {
    int s = 0;
    while (i > 0) {
      s += bit[i];
      i -= lowbit(i);
    }
    return s;
  }
};

class Solution {
public:
  int countRangeSum(vector<int>& nums, int lower, int upper) {
    if (nums.size() == 0) {
      return 0;
    }

    // all candidate used for bisect
    vector<long> sum_array (nums.size() * 3, 0);
    long sum = 0;
    for (int i = 0; i < nums.size(); i++) {
      sum += nums[i];
      sum_array[i * 3] = sum;
      sum_array[i * 3 + 1] = sum + lower - 1;
      sum_array[i * 3 + 2] = sum + upper;
    }
    sum_array.push_back(upper);
    sum_array.push_back(lower - 1);
    sort(sum_array.begin(), sum_array.end());

    // discrete
    unordered_map<long, int> index;
    auto end = unique(sum_array.begin(), sum_array.end());
    auto it = sum_array.begin();
    for (int i = 1; it != end;i++,it++) {
      index[*it] = i;
    }

    BinaryIndexedTree tree(index.size());
    int ans = 0;
    for (int i = nums.size() - 1; i >= 0; i--) {
      tree.add(index[sum],1);
      sum -= nums[i];
      ans += tree.sum(index[sum + upper]) - tree.sum(index[sum + lower - 1]);
    }
    return ans;
  }
};

int main() {
  Solution sol;
  vector<int> nums = {-2, 5, -1};
  cout << sol.countRangeSum(nums, -2, 2) << endl;

  nums = {0,0};
  cout << sol.countRangeSum(nums, 0, 0) << endl;

  nums = {2147483647,2147483647,0,-2147483647};
  cout << sol.countRangeSum(nums, 4232, 7660) << endl;
  return 0;
}
