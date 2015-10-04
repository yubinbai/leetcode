#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <cstdlib>

using namespace std;

class Solution {
public:
  int minCost(vector<vector<int>>& costs) {
    if (costs.empty()) {
      return 0;
    }
    int r = 0, g = 0, b = 0;
    for (int i = 0; i < costs.size(); i++) {
      int rr = r, bb = b, gg = g; 
      r = costs[i][0] + min(bb, gg);
      b = costs[i][1] + min(rr, gg);
      g = costs[i][2] + min(rr, bb);
    }
    return min(r, min(b, g));
  } 
};

int main() {
  Solution sol;
  vector<vector<int>> costs = {{5,8,6},{19,14,13},{7,5,12},{14,15,17},{3,20,10}};
  cout << sol.minCost(costs) << endl;
  return 0;
}
