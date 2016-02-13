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

class UnionFind {
public:
  UnionFind(int m, int n) {
    for (int i = 0; i < m * n; i++) parent.push_back(-1);
    for (int i = 0; i < m * n; i++) sizes.push_back(1);
    this->m = m;
    this->n = n;
    this->cnt = 0;
  }

  int index(int x, int y) {
    return x * this->n + y;
  }

  int size(void) {
    return cnt;
  }

  int id(int x, int y) {
    if (x >= 0 && x < this->m && y >= 0 && y < this->n) {
      return parent[index(x, y)];
    }
    return -1;
  }

  int add(int x, int y) {
    int idx = index(x, y);
    parent[idx] = idx;
    sizes[idx] = 1;
    cnt++;
    return idx;
  }

  int root(int i) {
    while (i != parent[i]) {
      parent[i] = parent[parent[i]];
      i = parent[i];
    }
    return i;
  }

  void join(int p, int q) {
    int i = root(p), j = root(q);
    if (sizes[i] > sizes[j]) {
      swap(i, j);
    }
    parent[i] = j;
    sizes[j] += sizes[i];
    cnt--;
  }

private:
  vector<int> parent, sizes;
  int m, n, cnt;
};

class Solution {
public:
  vector<int> numIslands2(int m, int n, vector<pair<int, int>>& positions) {
    UnionFind islands(m, n);
    vector<pair<int, int>> directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
    vector<int> ans;
    for (auto& pos : positions) {
      int x = pos.first, y = pos.second;
      int p = islands.add(x, y);
      for (auto& direction : directions) {
        int q = islands.id(x + direction.first, y + direction.second);
        if (q >= 0 && islands.root(p) != islands.root(q)) {
          islands.join(p, q);
        }
      }
      ans.push_back(islands.size());
    }
    return ans;
  }
};

int main() {
  int m = 3, n = 3;
  vector<pair<int, int>> positions = {{0,0}, {0,1}, {1,2}, {2,1}};
  Solution sol;
  for (auto i: sol.numIslands2(m, n, positions)) {
    cout << i << endl;
  }
  return 0;
}
