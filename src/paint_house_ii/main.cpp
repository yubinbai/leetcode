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
    int n = costs.size(), m = costs[0].size();
    vector<int> prev_house, curr_house;
    curr_house = costs[0];
    int prev_min = 0, prev_min2 = 0;
    int curr_min = 0, curr_min2 = 0;
    for (int i = 0; i < n; i++) {
      prev_house = curr_house;
      prev_min = curr_min;
      prev_min2 = curr_min2;
      curr_min = curr_min2 = INT_MAX;
      for (int j = 0; j < m; j++) {
        curr_house[j] = (prev_house[j] == prev_min)
          ? prev_min2 + costs[i][j]
          : prev_min + costs[i][j];
        if (curr_house[j] < curr_min) {
          curr_min2 = curr_min;
          curr_min = curr_house[j];
        } else if (curr_house[j] < curr_min2) {
          curr_min2 = curr_house[j];
        }
      }
    }
    return curr_min;
  } 
};

int main() {
  Solution sol;
  vector<vector<int>> costs = {{5,8,6},{19,14,13},{7,5,12},{14,15,17},{3,20,10}};
  cout << sol.minCost(costs) << endl;
  return 0;
}
