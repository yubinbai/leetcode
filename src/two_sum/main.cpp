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
  static bool pairCompare(const pair<int, int>& firstElem,
                   const pair<int, int>& secondElem) {
    return firstElem.first < secondElem.first;
  }
public:
  vector<int> twoSum(vector<int>& nums, int target) {
    vector<pair<int, int>> comp;
    for (int i = 0; i < nums.size(); i++) {
      comp.push_back(make_pair(nums[i], i + 1));
    }
    sort(comp.begin(), comp.end(), pairCompare);

    int left = 0, right = nums.size() - 1;
    while (left < right) {
      int s = comp[left].first + comp[right].first;
      if (s > target) {
        right--;
      } else if (s < target) {
        left++;
      } else {
        break;
      }
    }

    vector<int> ret = {comp[left].second, comp[right].second};
    sort(ret.begin(), ret.end());
    return ret;
  }
};

int main() {
  vector<int> v = {2, 7, 11, 15};
  int target = 9;
  Solution sol;
  for (int a : sol.twoSum(v, target)) {
    cout << a << endl;
  }
  return 0;
}
