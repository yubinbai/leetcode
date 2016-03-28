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
  unordered_map<TreeNode*, int> memo[2];
  int _rob(TreeNode* root, bool can_use_root) {
    if (root == nullptr) {
      return 0;
    }

    if (memo[can_use_root].count(root)) {
      return memo[can_use_root][root];
    }

    int r1 = 0, r2 = 0;
    if (can_use_root) {
      r1 = root->val +
        _rob(root->left, false) +
        _rob(root->right, false);
    }
    r2 = _rob(root->left, true) + _rob(root->right, true);
    return memo[can_use_root][root] = max(r1, r2);
  }
public:
  int rob(TreeNode* root) {
    return _rob(root, true);
  }
};

int main() {
  Solution sol;
  TreeNode* t = new TreeNode(3);
  t->left = new TreeNode(2);
  t->left->right = new TreeNode(3);
  t->right = new TreeNode(3);
  t->right->right = new TreeNode(1);
  cout << sol.rob(t) << endl;

  return 0;
}
