#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
  vector<int> findMinHeightTrees(int n, vector<pair<int, int>>& edges) {
    if (n == 1) {
      return vector<int> {0};
    }
    vector<unordered_set<int>> adj(n, unordered_set<int>(0));
    for (auto edge: edges) {
      adj[edge.first].insert(edge.second);
      adj[edge.second].insert(edge.first);
    }

    vector<int> leaves;
    for (int node = 0; node < n; node++) {
      if (adj[node].size() == 1) {
        leaves.push_back(node);
      }
    }

    int remains = n;
    while (remains > 2) {
      remains -= leaves.size();
      vector<int> new_leaves;
      for (auto leaf: leaves) {
        int parent = *adj[leaf].begin();
        adj[parent].erase(leaf);
        if (adj[parent].size() == 1) {
          new_leaves.push_back(parent);
        }
      }
      leaves = new_leaves;
    }
    return leaves;
  }
};

int main() {
  Solution sol;
  vector<pair<int, int>> edges = {{1, 0}, {1, 2}, {1, 3}};
  for (auto i: sol.findMinHeightTrees(4, edges)) {
    cout << i << endl;
  }

  vector<pair<int, int>> edges2 = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
  for (auto i: sol.findMinHeightTrees(6, edges2)) {
    cout << i << endl;
  }
  return 0;
}
