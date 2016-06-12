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

bool compare(pair<int,int>& x, pair<int, int>& y) {
  return x.first != y.first ? x.first < y.first : x.second > y.second;
}

class Solution {
public:
  int maxEnvelopes(vector<pair<int, int>>& envelopes) {
    int n = envelopes.size();
    if (n == 0) {
      return 0;
    }
    // sort by height, leaving to solve LIS for width
    sort(envelopes.begin(), envelopes.end(), compare);

    int ans = 0;
    vector<int> g(n+1, INT_MAX); // smallest width given position
    for (int i = 0; i < n; i++) {
      // binary search, only for the second
      int k =
        lower_bound(++g.begin(), g.end(), envelopes[i].second) -
        g.begin();
      ans = max(ans, k);
      g[k] = envelopes[i].second;
    }
    return ans;
  }
};

int main() {
  Solution s;
  vector<pair<int, int>> e = {{5,4},{6,4},{6,7},{2,3}};
  cout << s.maxEnvelopes(e) << endl;
  return 0;
}
