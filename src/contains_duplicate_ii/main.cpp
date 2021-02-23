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
  bool containsNearbyDuplicate(vector<int> nums, int k) {
    unordered_set<int> nearby;
    deque<int> q;
    for (int i : nums) {
      if (nearby.count(i) > 0) {
        return true;
      }
      q.push_back(i);
      nearby.insert(i);
      if (q.size() > k) {
        int f = q.front();
        q.pop_front();
        nearby.erase(f);
      }
    }
    return false;
  }
};


int main() {
  Solution s;
  vector<int> nums;
  int k;

  nums = {1, 2, 3, 1};
  k = 2;
  cout << s.containsNearbyDuplicate(nums, k) << endl;

  nums = {1, 2, 3, 1, 4, 5};
  k = 3;
  cout << s.containsNearbyDuplicate(nums, k) << endl;

  nums = {1, 2, 3, 1, 4, 5};
  k = 0;
  cout << s.containsNearbyDuplicate(nums, k) << endl;

  return 0;
}
