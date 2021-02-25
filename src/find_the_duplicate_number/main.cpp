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
  int findDuplicate(vector<int> nums) {
    int n = nums.size() - 1;
    int low = 1, high = n;
    int mid = 0;
    while (low < high) {
      mid = low + (high - low) / 2;
      int c = count(nums, mid); //count #numbers less than mid.
      if (c <= mid) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }
private:
  int count(vector<int> nums, int mid) {
    int c =0;
    for(int i : nums) {
      if(i <= mid) {
        c++;
      }
    }
    return c;
  }
};

int main() {
  Solution sol;
  vector<int> nums = {1, 2, 3, 4, 5, 5, 6}; 
  cout << sol.findDuplicate(nums) << endl;

  nums = {1, 1, 2}; 
  cout << sol.findDuplicate(nums) << endl;

  return 0;
}
