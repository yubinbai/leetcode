#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
  int countComponents(int n, vector<pair<int, int>>& edges) {
    UnionFind uf(n);
    for (const auto& e : edges) {
      uf.union_set(e.first, e.second);
    }
    return uf.length();
  }

private:
  class UnionFind {
  private:
    vector<int> parent;
    int count;

  public:
    UnionFind(const int n) {
      parent = vector<int>(n, 0);
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
      count = n;
    }

    int find_set(const int x) {
      if (parent[x] != x) {
        parent[x] = find_set(parent[x]);  // Path compression.
      }
      return parent[x];
    }

    void union_set(const int x, const int y) {
      int x_root = find_set(x), y_root = find_set(y);
      if (x_root != y_root) {
        parent[min(x_root, y_root)] = max(x_root, y_root);
        --count;
      }
    }

    int length() const {
      return count;
    }
  };
};

int main() {
  Solution sol;
  vector<pair<int,int>> edges = {{0, 1}, {1, 2}, {3, 4}};
  cout << sol.countComponents(5, edges) << endl;
  return 0;
}

