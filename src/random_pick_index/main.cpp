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
private:
  vector<int> nums;
public:
  Solution(vector<int>& nums) {
    this->nums = nums;
  }

  int pick(int target) {
    int pos = -1;
    int count = 0;
    for (int i = 0; i < nums.size(); i++) {
      if (nums[i] == target) {
        if (count > 0) {
          count++;
          int rand = (int)(std::rand() * RAND_MAX) % count;
          if (rand == 1) {
            pos = i;
          }
        } else {
          pos = i;
          count = 1;
        }
      }
    }
    return pos;
  }
};


int main() {

  vector<int> nums = {1, 2, 3, 3, 3};
  Solution sol(nums);

  cout << sol.pick(3)<< endl;
  cout << sol.pick(1)<< endl;
  cout << sol.pick(3)<< endl;
  cout << sol.pick(3)<< endl;
  cout << sol.pick(3)<< endl;
  cout << sol.pick(2)<< endl;
  cout << sol.pick(3)<< endl;

  return 0;
}
