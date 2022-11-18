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

typedef pair<int,int> pii;

class Solution {
public:
  int trapRainWater(vector<vector<int>>& heightMap) {
    if (heightMap.size() <= 2 || heightMap[0].size() <= 2) {
      return 0;
    }
    int m = heightMap.size();
    int n = heightMap[0].size();
    priority_queue<pii, vector<pii>, greater<pii>> pq;
    vector<vector<bool>> visit(m, vector<bool>(n, false));
    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
          pq.push({heightMap[i][j], i * n + j});
          visit[i][j] = true;
        }
      }
    }

    int res = 0;
    int dirs[] = {-1, 0, 1, 0, -1};
    while (!pq.empty()) {
      pii curr = pq.top();
      pq.pop();
      for (int k = 0; k < 4; ++k) {
        int nx = curr.second / n + dirs[k];
        int ny = curr.second % n + dirs[k + 1];
        if( nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
          if (heightMap[nx][ny] < curr.first) {
            res += curr.first - heightMap[nx][ny];
          }
          visit[nx][ny] = true;
          pq.push({max(heightMap[nx][ny], curr.first), nx * n + ny});
        }
      }
    }

    return res;
  }
};

int main(int argc, const char * argv[]) {
  Solution sol;
  vector<vector<int>> heightMap;

  heightMap = {{3,3,3},{3,1,3},{3,3,3}};
  cout << sol.trapRainWater(heightMap) << endl;

  heightMap = {{3,3,3,3,3},
               {3,2,2,2,3},
               {3,2,1,2,3},
               {3,2,2,2,3},
               {3,3,3,3,3}};
  cout << sol.trapRainWater(heightMap) << endl;

  heightMap = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
  cout << sol.trapRainWater(heightMap) << endl;

  heightMap = {{12,13,1,12},
               {13,4,13,12},
               {13,8,10,12},
               {12,13,12,12},
               {13,13,13,13}};
  cout << sol.trapRainWater(heightMap) << endl;

  return 0;
}
