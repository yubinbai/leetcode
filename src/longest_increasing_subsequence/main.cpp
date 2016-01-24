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
  int lengthOfLIS(vector<int>& nums) {
    int n = nums.size();
    if (n == 0) {
      return 0;
    }
    // memo[j] — stores the position k of the smallest value X[k]
    // such that there is an increasing subsequence of length j
    // ending at X[k] on the range k ≤ i
    vector<int> memo = {0};
    // prev[k]  — stores the position of the predecessor of X[k] in the longest increasing
    // subsequence ending at X[k].
    vector<int> prev(n, -1);

    for (int i = 1; i < n; i++) {
      if (nums[memo.back()] < nums[i]) {
        prev[i] = memo.back();
        memo.push_back(i);
      } else {
        // binary search to update memo
        int low = 0, high = memo.size() - 1;
        while (low < high) {
          int mid = low + (high - low) / 2;
          if (nums[memo[mid]] < nums[i]) {
            low = mid + 1;
          } else {
            high = mid;
          }
        }
        if (nums[i] < nums[memo[low]]) {
          if (low > 0) {
            prev[i] = memo[low - 1];
          }
          memo[low] = i;
        }
      }
    }
    return memo.size();
  }
};

int main() {
  Solution sol;
  vector<int> a = {1, 3, 2, 5, 10};
  cout << sol.lengthOfLIS(a) << endl;
  vector<int> b = {1, 2, 3, 4, 5};
  cout << sol.lengthOfLIS(b) << endl;
  return 0;
}
