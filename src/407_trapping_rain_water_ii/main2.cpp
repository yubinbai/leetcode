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
  int trapRainWater(vector<vector<int>>& heightMap) {
    int n = heightMap.size();
    int m = heightMap[0].size();
    int maxHeight = 1000000;
    int dirs[] = {-1, 0, 1, 0, -1};

    vector<vector<int>> water(n, vector<int>(m, maxHeight));
    queue<pair<int,int>> updates;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
          if (water[i][j] > heightMap[i][j]) {
            water[i][j] = heightMap[i][j];
            updates.push(make_pair(i, j));
          }
        }
      }
    }
    while (!updates.empty()) {
      int x = updates.front().first, y = updates.front().second;
      updates.pop();
      for (int i = 0; i < 4; ++i) {
        int nx = x + dirs[i], ny = y + dirs[i + 1];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
          continue;
        }
        if (water[x][y] < water[nx][ny] && water[nx][ny] > heightMap[nx][ny]) {
          water[nx][ny] = max(water[x][y], heightMap[nx][ny]);
          updates.push(make_pair(nx, ny));
        }
      }
    }

    int res = 0;
    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        res += water[i][j] - heightMap[i][j];
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
