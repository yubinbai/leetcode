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
  void moveZeroes(vector<int>& nums) {
    int i = 0, j = 0;
    while (j < nums.size()) {
      while (nums[i] != 0) {
        i++;
      }
      if (i < j && nums[j] != 0) {
        nums[i] = nums[j];
        nums[j] = 0;
      }
      j++;
    }
  }
};

int main() {
  Solution sol;
  vector<int> v = {0, 1, 0, 3, 12};
  sol.moveZeroes(v);
  for (int s : v) {
    cout << s << endl;
  }
  return 0;
}
