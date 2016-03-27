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
  vector<string> stack, result;
  map<string, map<string, int>> edges_of;
  int expect_trip_len;
  void _dfs(string curr) {
    if (!result.empty()) {
      return;
    }
    stack.push_back(curr);
    if (stack.size() == expect_trip_len) {
      result = vector<string>(stack);
      return;
    }
    for (auto &e: edges_of[curr]) {
      if (e.second) {
        e.second--;
        _dfs(e.first);
        e.second++;
      }
    }
    stack.pop_back();
  }
public:
  vector<string> findItinerary(vector<pair<string, string>> tickets) {
    stack = vector<string>();
    result = vector<string>();
    edges_of = map<string, map<string, int>>();
    expect_trip_len = tickets.size() + 1;

    for (auto &t: tickets) {
      if (!edges_of.count(t.first)) {
        edges_of[t.first] = map<string, int>();
      }
      edges_of[t.first][t.second]++;
    }
    _dfs("JFK");
    return result;
  }
};

int main() {
  Solution sol;
  vector<pair<string, string>> itin =
    {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
  for (string s: sol.findItinerary(itin)) {
    cout << s << "\t";
  }
  cout << "\n";

  itin = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
  for (string s: sol.findItinerary(itin)) {
    cout << s << "\t";
  }
  cout << "\n";

  itin = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
  for (string s: sol.findItinerary(itin)) {
    cout << s << "\t";
  }
  cout << "\n";

  return 0;
}
