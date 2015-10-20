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
  string alienOrder(vector<string>& words) {
    if (words.size() == 1) {
      return words[0];
    }
    Graph g = makeGraph(words);
    return topoSort(g);
  }
private:
  typedef unordered_map<char, unordered_set<char>> Graph;
    
  Graph makeGraph(vector<string>& words) {
    Graph g;
    int n = words.size();
    for (int i = 1; i < n; i++) {
      bool found = false;
      string word1 = words[i - 1], word2 = words[i];
      int m = word1.length(), n = word2.length(), l = max(m, n);
      for (int j = 0; j < l; j++) {
        if (j < m && g.find(word1[j]) == g.end()) {
          g[word1[j]] = unordered_set<char>();
        }
        if (j < n && g.find(word2[j]) == g.end()) {
          g[word2[j]] = unordered_set<char>();
        }
        if (j < m && j < n && word1[j] != word2[j] && !found) {
          g[word1[j]].insert(word2[j]);
          found = true;
        }
      }
    }
    return g;
  }
    
  string topoSort(Graph& g) {
    vector<bool> on_path(256, false), visited(256, false);
    string result;
    for (auto adj : g) {
      if (!dfs(g, on_path, visited, result, adj.first)) {
        return "";
      }
    }
    reverse(result.begin(), result.end());
    return result;
  }
    
  bool dfs(Graph& g, vector<bool>& on_path, vector<bool>& visited, string& result, char node) {
    if (on_path[node]) {
      return false;
    }
    if (visited[node]) {
      return true;
    }
    on_path[node] = visited[node] = true;
    for (auto neighbor : g[node]) {
      if (!dfs(g, on_path, visited, result, neighbor)) {
        return false;
      }
    }
    on_path[node] = false;
    result += node;
    return true;
  }
};

int main() {
  Solution sol;
  vector<string> v = {"wrt", "wrf", "er", "ett", "rftt"};
  cout << sol.alienOrder(v) << endl;
  return 0;
}
