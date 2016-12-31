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

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  vector<vector<int>> findLeaves(TreeNode* root) {
    vector<vector<int>> res;
    assembleLeavesAndGetDepth(root, res);
    return res;
  }
  int assembleLeavesAndGetDepth(TreeNode *root, vector<vector<int>> &res) {
    if (!root) {
      return -1;
    }
    int depth =
      1 +
      max(
        assembleLeavesAndGetDepth(root->left, res),
        assembleLeavesAndGetDepth(root->right, res)
      );
    if (depth >= res.size()) {
      res.push_back(vector<int>());
    }
    res[depth].push_back(root->val);
    return depth;
  }
};

int main() {
  Solution sol;

  TreeNode* root = new TreeNode(1);
  root->left = new TreeNode(2);
  root->right = new TreeNode(3);
  root->left->left = new TreeNode(4);
  root->left->right = new TreeNode(5);

  for (vector<int> v: sol.findLeaves(root)) {
    for (int i: v) {
      cout << i << " ";
    }
    cout << endl;
  }

  return 0;
}
