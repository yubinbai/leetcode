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
private:
  void swap(vector<int> &nums, int i, int j) {
    int t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }
public:
  void wiggleSort(vector<int> &nums) {
    if (nums.size() <= 1) {
      return;
    }
    for (int i = 0; i < nums.size() - 1; i++) {
      if (i % 2 == 0) {
        if (nums[i] > nums[i + 1]) {
          swap(nums, i, i + 1);
        }
      } else {
        if (nums[i] < nums[i + 1]) {
          swap(nums, i, i + 1);
        }
      }
    }
  }
};

int main() {
  Solution sol;
  vector<int> arr = {3, 5, 2, 1, 6, 4};
  sol.wiggleSort(arr);
  for (int a : arr) {
    cout << a << ' ';
  }
  return 0;
}
