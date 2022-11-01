#include <cstdlib>
#include <iostream>
#include <list>
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
  bool canCross(vector<int>& stones) {
    map<int, unordered_set<int>> memo;
    for (int s: stones) {
      memo[s] = {};
    }
    memo[0].insert(0);
    for (int s: stones) {
      auto prev = memo[s];
      for (int p: prev) {
        int step = p - 1;
        int q = s + step;
        if (memo.count(q)) {
          memo[q].insert(step);
        }
        step = p;
        q = s + step;
        if (memo.count(q)) {
          memo[q].insert(step);
        }
        step = p + 1;
        q = s + step;
        if (memo.count(q)) {
          memo[q].insert(step);
        }
      }
    }
    auto last = stones.back();
    return memo[last].size() > 0;
  }

};

int main(int argc, const char * argv[]) {
  Solution sol;
  vector<int> stones;

  stones = {0,1,3,5,6,8,12,17};
  cout << sol.canCross(stones) << endl;

  stones = {0,1,2,3,4,8,9,11};
  cout << sol.canCross(stones) << endl;

  return 0;
}
