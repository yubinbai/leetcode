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
  vector<int> getModifiedArray(int length, vector<vector<int>> updates) {
    vector<int> results(length);
    for(auto update: updates) {
      results[update[0]] += update[2];
      if (update[1] + 1 < length) {
        results[update[1] + 1] -= update[2];
      }
    }
    int value = 0;
    for(int i = 0; i < length; i++) {
      value += results[i];
      results[i] = value;
    }
    return results;
  }
};

int main() {
  Solution sol;
  vector<vector<int>> updates = {
    {1,  3,  2},
    {2,  4,  3},
    {0,  2, -2}
  };
  for (auto i : sol.getModifiedArray(5, updates)) {
    cout << i << ' ';
  }
  return 0;
}
