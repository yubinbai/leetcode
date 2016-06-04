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

class Solution {
public:
  vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
    unordered_set<int> s1;
    unordered_set<int> result_set;
    for (int i: nums1) {
      s1.insert(i);
    }
    for (int i: nums2) {
      if (s1.count(i)) {
        result_set.insert(i);
      }
    }
    return vector<int>(result_set.begin(), result_set.end());
  }
};

int main() {
  Solution sol;
  vector<int> nums1 = {1, 2, 2, 1};
  vector<int> nums2 = {2, 2};

  for (auto i: sol.intersection(nums1, nums2)) {
    cout << i << endl;
  }

  return 0;
}
