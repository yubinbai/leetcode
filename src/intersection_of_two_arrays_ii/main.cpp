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
  vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    sort(nums1.begin(), nums1.end());
    sort(nums2.begin(), nums2.end());
    int i1 = 0, n1 = nums1.size();
    int i2 = 0, n2 = nums2.size();
    vector<int> result;
    while (i1 < n1 && i2 < n2) {
      if (nums1[i1] > nums2[i2]) {
        i2++;
      } else if (nums1[i1] < nums2[i2]) {
        i1++;
      } else {
        result.push_back(nums1[i1]);
        i1++;
        i2++;
      }
    }
    return result;
  }
};

int main() {
  Solution sol;
  vector<int> nums1 = {1, 2, 2, 1};
  vector<int> nums2 = {2, 2};

  for (auto i: sol.intersect(nums1, nums2)) {
    cout << i << endl;
  }

  return 0;
}
