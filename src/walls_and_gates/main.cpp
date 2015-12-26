#include <cstdlib>
#include <iostream>
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
  void wallsAndGates(vector<vector<int>>& rooms) {
    int m = rooms.size();
    if (m == 0) {
      return;
    }
    int n = rooms[0].size();
    if (n == 0) {
      return;
    }
    queue<pair<int, int>> q;
    for (int i = 0; i < m; ++i) { 
      for(int j = 0; j < n; ++j) {
        if (rooms[i][j] == 0) {
          q.push(make_pair(i, j));
        }
      }
    }
    while (q.size() > 0) {
      int x = q.front().first;
      int y = q.front().second;
      q.pop();
      if (x - 1 >= 0 && rooms[x - 1][y] > rooms[x][y] + 1) {
        rooms[x - 1][y] = rooms[x][y] + 1;
        q.push(make_pair(x - 1,y));
      }
      if (x + 1 < m  && rooms[x + 1][y] > rooms[x][y] + 1) {
        rooms[x+1][y] = rooms[x][y]+1;
        q.push(make_pair(x + 1,y));
      }
      if (y - 1 >= 0 && rooms[x][y - 1] > rooms[x][y] + 1) {
        rooms[x][y - 1] = rooms[x][y] + 1;
        q.push(make_pair(x,y - 1));
      }
      if (y + 1 < n && rooms[x][y + 1] > rooms[x][y] + 1) {
        rooms[x][y + 1] = rooms[x][y] + 1;
        q.push(make_pair(x,y + 1));
      }
    }
  }
};

int main() {
  Solution sol;
  int INF = INT_MAX;

  vector<vector<int>> rooms = {
    {INF,  -1,  0,  INF},
    {INF, INF, INF,  -1},
    {INF,  -1, INF,  -1},
    {0,  -1, INF, INF},
  }; 
  sol.wallsAndGates(rooms);
  for (auto v: rooms) {
    for (auto i: v) {
      cout << i << ' ';
    }
    cout << endl;
  }
  return 0;
}
