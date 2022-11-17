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

bool compareByHeightAndRank(vector<int> p1, vector<int> p2) {
  if (p1[0] > p2[0]) {
    return true;
  } else if (p1[0] < p2[0]) {
    return false;
  } else {
    return p1[1] < p2[1];
  }
}

class Solution {
public:
  vector<vector<int>> reconstructQueue(vector<vector<int>>& people) {
    sort(people.begin(), people.end(), compareByHeightAndRank);

    list<vector<int>> s;
    for (auto p: people) {
      auto it = s.begin();
      advance(it, p[1]);
      s.insert(it, p);
    }

    vector<vector<int>> ret;
    for (auto p: s) {
      ret.push_back(p);
    }
    return ret;
  }
};

int main(int argc, const char * argv[]) {
  Solution sol;
  vector<vector<int>> people;

  people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
  sol.reconstructQueue(people);

  people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};
  sol.reconstructQueue(people);
  return 0;
}
