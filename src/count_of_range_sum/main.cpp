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

class Solution {
public:
  int countRangeSum(vector<int>& nums, int lower, int upper) {
    int n = nums.size();
    vector<long> sums(n + 1, 0);
    for (int i = 0; i < n; ++i) {
      sums[i + 1] = sums[i] + nums[i];
    }
    return countWhileMergeSort(sums, 0, n + 1, lower, upper);
  }

  int countWhileMergeSort(vector<long> &sums, int start, int end, int lower, int upper) {
    if (end - start <= 1) {
      // The size of range [start, end) less than 2 is always with count 0.
      return 0;
    }
    int mid = start + (end - start) / 2;
    int count =
      countWhileMergeSort(sums, start, mid, lower, upper) +
      countWhileMergeSort(sums, mid, end, lower, upper);

    int j = mid, k = mid, r = mid;
    vector<long> cache;
    for (int i = start; i < mid; ++i) {
      while (k < end && sums[k] - sums[i] < lower) {
        k++;
      }
      while (j < end && sums[j] - sums[i] <= upper) {
        j++;
      }
      // get number of ranges that start in left half and end in right half
      count += j - k;

      while (r < end && sums[r] < sums[i]) {
        cache.push_back(sums[r]);
        r++;
      }
      cache.push_back(sums[i]);
    }

    for (int i = start; i < start + cache.size(); i++) {
      sums[i] = cache[i - start];
    }
    return count;
  }
};

int main() {
  Solution sol;
  vector<int> nums = {-2, 5, -1};
  cout << sol.countRangeSum(nums, -2, 2) << endl;

  nums = {0,0};
  cout << sol.countRangeSum(nums, 0, 0) << endl;
  return 0;
}
