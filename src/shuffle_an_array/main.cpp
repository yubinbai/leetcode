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
  vector<int> nums;
public:
  Solution(vector<int>& nums) {
    this->nums = nums; 
  }
    
  /** Resets the array to its original configuration and return it. */
  vector<int> reset() {
    sort(nums.begin(), nums.end());     
    return nums;
  }
    
  /** Returns a random shuffling of the array. */
  vector<int> shuffle() {
    int size = nums.size();
    for (int i = 0; i < size - 1; i++) {
      int rand = std::rand() % (size - i - 1);
      int pos = rand + i + 1;
      int temp = nums[pos];
      nums[pos] = nums[i];
      nums[i] = temp;
    }
    return nums;
  }
};


int main() {

  vector<int> nums = {1, 2, 3};
  Solution* sol = new Solution(nums);
  vector<int> param_1 = sol->reset();
  for (int i: param_1) {
    cout << i << ' ';
  }
  cout << endl;

  for (int ii = 0; ii < 20; ii++) {
    vector<int> param_2 = sol->shuffle();
    for (int i: param_2) {
      cout << i << ' ';
    }
    cout << endl;
  }

  return 0;
}
