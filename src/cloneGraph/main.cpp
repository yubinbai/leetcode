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

// Definition for a Node.
class Node {
public:
  int val;
  vector<Node*> neighbors;
  Node() {
    val = 0;
    neighbors = vector<Node*>();
  }
  Node(int _val) {
    val = _val;
    neighbors = vector<Node*>();
  }
  Node(int _val, vector<Node*> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
};

class Solution {
public:
  Node* cloneGraph(Node* start) {
    if (start == nullptr) {
      return nullptr;
    }
    unordered_map<Node*, Node*> node_map;
    unordered_set<Node*> visited;
    deque<Node*> q;
    q.push_back(start);
    while (q.size() > 0) {
      Node* e = q.front();
      q.pop_front();
      if (visited.count(e) > 0) {
        continue;
      }
      Node* e2;
      if (node_map.count(e) == 0) {
        node_map[e] = new Node(e->val);
      }
      e2 = node_map[e];
      for (auto x : e->neighbors) {
        if (node_map.count(x) == 0) {
          node_map[x] = new Node(x->val);
        }
        e2->neighbors.push_back(node_map[x]);
        q.push_back(x);
      }
      visited.insert(e);
    }
    return node_map[start];
  }

  Node* buildGraph(vector<vector<int> > adj_list) {
    int size = adj_list.size();
    vector<Node*> nodes;
    nodes.push_back(new Node(0));  // simplify indicies
    for (int i = 1; i <= size; i++) {
      nodes.push_back(new Node(i));
    }
    for (int i = 1; i <= size; i++) {
      for (int x : adj_list[i - 1]) {
        nodes[i]->neighbors.push_back(nodes[x]);
      }
    }
    return nodes[1];
  }

  string traverse(Node* start) {
    stringstream result;
    unordered_set<Node*> visited;
    deque<Node*> q;
    q.push_back(start);
    while (q.size() > 0) {
      Node* e = q.front();
      q.pop_front();
      if (visited.count(e) > 0) {
        continue;
      }
      result << e->val << ':';
      for (auto x : e->neighbors) {
        result << x->val << ",";
        q.push_back(x);
      }
      result << endl;
      visited.insert(e);
    }
    return result.str();
  }
};


int main() {
  Solution s;
  vector<vector<int> > adj_list = {{2,4},{1,3},{2,4},{1,3}};
  Node* g1 = s.buildGraph(adj_list);
  Node* g2 = s.cloneGraph(g1);

  cout << s.traverse(g1) << endl;
  cout << s.traverse(g2) << endl;

  return 0;
}
