#include <cstdlib>
#include <iostream>
#include <map>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  bool validTree(int n, vector<pair<int, int>>& edges) {
    vector<vector<int>> adj(n);
    for (auto e : edges) {
      adj[e.first].push_back(e.second);
      adj[e.second].push_back(e.first);
    }
    vector<bool> on_path(n, false), visited(n, false);
    if (hasCycle(adj, 0, -1, on_path, visited)) {
      return false;
    }
    for (bool v : visited) {
      if (!v) {
        return false; 
      }
    }
    return true;
  }

private:
  bool hasCycle(vector<vector<int>>& adj, int k, int parent,
                vector<bool>& on_path, vector<bool>& visited) {
    if (on_path[k]) {
      return true;
    }
    on_path[k] = visited[k] = true;
    for (auto v : adj[k]) {
      if (v != parent && hasCycle(adj, v, k, on_path, visited)) {
        return true;
      }
    }
    return on_path[k] = false;
  }
};

int main() {
  Solution sol;
  vector<pair<int, int>> v1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
  cout << sol.validTree(5, v1) << endl;

  vector<pair<int, int>> v2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
  cout << sol.validTree(5, v2) << endl;
  return 0;
}
