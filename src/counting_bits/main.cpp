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
  vector<int> countBits(int num) {
    vector<int> result = {0};
    int pow2 = 1;
    for (int i = 1; i <= num; i++) {
      if (i >= pow2 << 1) {
        pow2 <<= 1;
      }
      result.push_back(result[i - pow2] + 1);
    }
    return result;
  }
};


int main() {
  Solution sol;
  for (int i: sol.countBits(10)) {
    cout << i << "\n";
  }

  return 0;
}
