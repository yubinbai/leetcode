#include <cstdlib>
#include <iostream>
#include <map>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> singleNumber(vector<int> nums) {
    vector<int> res = {0, 0};
    int xy = 0;
    for (auto i : nums) {
      xy ^= i;
    }
    int filter = xy & (~(xy - 1));
    for (auto i : nums) {
      if ((i & filter) != 0) {
        res[0] = res[0] ^ i;
      } else {
        res[1] = res[1] ^ i;
      }
    }
    return res;
  }
};

int main() {
  Solution sol;
  vector<int> v = {1, 2, 2, 3, 4, 4, 5, 3};
  for (auto i : sol.singleNumber(v)) {
    cout << i << endl;
  }
  return 0;
}
