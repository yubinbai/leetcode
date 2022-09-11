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
public:
  vector<double> calcEquation(vector<vector<string>>& equations, vector<double>& values, vector<vector<string>>& queries) {
    unordered_map<string, int> ss;
    int n = 0;
    for (vector<string> pair : equations) {
      for (string s: pair) {
        if (!ss[s]) {
          ss[s] = n;
          n++;
        }
      }
    }

    vector<vector<double>> dist;
    for (int i = 0; i < n; i++) {
      vector<double> row(n, 0);
      dist.push_back(row);
    }
    for (int i = 0; i < equations.size(); i++) {
      vector<string> pair = equations[i];
      int a = ss[pair[0]];
      int b = ss[pair[1]];
      dist[a][b] = values[i];
      dist[b][a] = 1.0 / values[i];
      dist[a][a] = 1.0;
      dist[b][b] = 1.0;
    }
    for (int k = 0; k < n; k++) {
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (dist[i][j] == 0) {
            dist[i][j] = dist[i][k] * dist[k][j];
          }
        }
      }
    }

    vector<double> result;
    for (vector<string> pair: queries) {
      if (ss.count(pair[0]) == 0 || ss.count(pair[1]) == 0) {
        result.push_back(-1.0);
      } else {
        int a = ss[pair[0]];
        int b = ss[pair[1]];
        if (dist[a][b] == 0) {
          result.push_back(-1.0);
        } else {
          result.push_back(dist[a][b]);
        }
      }
    }
    return result;
  }
};


int main() {

  vector<vector<string>> equations;
  vector<double> values;
  vector<vector<string>> queries;
  vector<double> ret;
  Solution sol;

  equations = {{"a","b"},{"b","c"}};
  values = {2.0,3.0};
  queries = {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
  ret = sol.calcEquation(equations, values, queries);
  for (double d: ret) {
    cout << d << " ";
  }
  cout << endl;

  equations = {{"a","b"},{"b","c"},{"bc","cd"}};
  values = {1.5,2.5,5.0};
  queries = {{"a","c"},{"c","b"},{"bc","cd"},{"cd","bc"}};
  ret = sol.calcEquation(equations, values, queries);
  for (double d: ret) {
    cout << d << " ";
  }
  cout << endl;

  equations = {{"a","b"}};
  values = {0.5};
  queries = {{"a","b"},{"b","a"},{"a","c"},{"x","y"}};
  ret = sol.calcEquation(equations, values, queries);
  for (double d: ret) {
    cout << d << " ";
  }
  cout << endl;

  equations = {{"a","b"},{"c","d"}};
  values = {1.0,1.0};
  queries = {{"a","c"},{"b","d"},{"b","a"},{"d","c"}};
  ret = sol.calcEquation(equations, values, queries);
  for (double d: ret) {
    cout << d << " ";
  }
  cout << endl;

  equations = {{"x1","x2"},{"x2","x3"},{"x3","x4"},{"x4","x5"}};
  values ={3.0,4.0,5.0,6.0};
  queries = {{"x1","x5"},{"x5","x2"},{"x2","x4"},{"x2","x2"},{"x2","x9"},{"x9","x9"}};
  ret = sol.calcEquation(equations, values, queries);
  for (double d: ret) {
    cout << d << " ";
  }
  cout << endl;

  equations = {{"a","c"},{"b","e"},{"c","d"},{"e","d"}};
  values = {2.0,3.0,0.5,5.0};
  queries = {{"a","b"}};
  ret = sol.calcEquation(equations, values, queries);
  for (double d: ret) {
    cout << d << " ";
  }
  cout << endl;

  return 0;
}
