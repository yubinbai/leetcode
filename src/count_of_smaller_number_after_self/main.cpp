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

class BinaryIndexedTree {
private:
  vector<int> bit;
  int n;
public:
  BinaryIndexedTree(int n) {
    this->n = n;
    this->bit = vector<int>(n + 1, 0);
  }

  void add(int i, int x) {
    while (i <= n) {
      bit[i] += x;
      i += i & -i;
    }
  }

  int sum(int i) {
    int s = 0;
    while (i > 0) {
      s += bit[i];
      i -= i & -i;
    }
    return s;
  }
};


class Solution {
private:
  vector<int> normalize(vector<int>& nums) {
    vector<int> swap = nums;
    int n = swap.size();
    vector<int> ans(n, 0);
    sort(swap.begin(), swap.end());
    for(int i = 0; i < n; ++i) {
      int rank = int(lower_bound(swap.begin(), swap.end(), nums[i]) - swap.begin());
      ans[i] = rank + 1;
    }
    return ans;
  }

public:
  vector<int> countSmaller(vector<int>& nums) {
    vector<int> normal = normalize(nums);
    int n = nums.size();
    vector<int> result(n, 0);
    BinaryIndexedTree bit(n);
    for (int i = n - 1; i >=0; i--) {
      result[i] = bit.sum(normal[i] - 1);
      bit.add(normal[i], 1);
    }
    return result;
  }
};

int main() {
  Solution sol;
  vector<int> nums = {5, 2, 6, 1};
  for (auto i: sol.countSmaller(nums)) {
    cout << i << " " << endl;
  }

  vector<int> nums2 = {-1, -1};
  for (auto i: sol.countSmaller(nums2)) {
    cout << i << " " << endl;
  }
  return 0;
}
