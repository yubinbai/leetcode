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
  bool isSelfCrossing(vector<int>& x) {
    int n = x.size();
    if (n < 4) {
      return false;
    }
    int t1 = 0,t2 = x[0],t3 = x[1],t4 = x[2],t5;
    bool increase = t4 > t2;
    for (int i = 3; i < n; i++) {
      t5 = x[i];
      if (increase && t3 >= t5) {
        if (t5 + t1 < t3 || (i + 1 < n && x[i+1] + t2 < t4)) {
          increase = false;
        } else if (i + 1 < n) {
          return true;
        }
      } else if(!increase && t3 <= t5) {
        return true;
      }
      t1 = t2;
      t2 = t3;
      t3 = t4;
      t4 = t5;
    }
    return false;
  }
};

int main() {
  Solution sol;
  vector<int> x;

  x = {1,2,3,4};
  cout << sol.isSelfCrossing(x) << "\n";

  x = {1,1,1,1};
  cout << sol.isSelfCrossing(x) << "\n";

  x = {4,3,2,1};
  cout << sol.isSelfCrossing(x) << "\n";

  return 0;
}
