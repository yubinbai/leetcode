#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
private:
  map<int, vector<int>> columns;
  void _color(TreeNode* node, int col) {
    if (node) {
      if (columns.count(col) == 0) {
        columns[col] = vector<int>();
      }
      columns[col].push_back(node->val);
      _color(node->left, col - 1);
      _color(node->right, col + 1);
    }
  }

public:
  vector<vector<int>> verticalOrder(TreeNode* root) {
    vector<vector<int>> res; 
    _color(root, 0);
    for (auto col: columns) {
      res.push_back(col.second);
    }
    return res;
  }
};

int main() {
  Solution sol;
  TreeNode root(3);
  root.left = new TreeNode(9);
  root.right = new TreeNode(20);
  root.right->left = new TreeNode(15);
  root.right->right = new TreeNode(7);
  for (auto v: sol.verticalOrder(&root)) {
    for (auto i: v) {
      cout << i << " ";
    }
    cout << endl;
  }
  return 0;
}
