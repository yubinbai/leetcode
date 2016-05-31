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
  vector<int> topKFrequent(vector<int>& nums, int k) {
    unordered_map<int, int> m;
    for (auto i: nums) {
      if (m.count(i)) {
        m[i]++;
      } else {
        m[i] = 1;
      }
    }
    vector<pair<int, int>> v;
    for(auto it = m.begin(); it != m.end(); ++it ) {
      v.push_back(*it);
    }
    sort(
      v.begin(),
      v.end(),
      [](pair<int, int> p1, pair<int, int> p2) -> bool{return p1.second > p2.second;}
    );
    vector<int> ret;
    for (int i = 0; i < v.size() && i < k; i++) {
      ret.push_back(v[i].first);
    }
    return ret;
  }
};

int main() {
  vector<int> list = {1,1,1,2,2,3};
  Solution sol;

  for (auto i: sol.topKFrequent(list, 2)) {
    cout << i << endl;
  }

  return 0;
}
