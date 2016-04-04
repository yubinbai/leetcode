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
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
public:
  int largestBSTSubtree(TreeNode* e) {
    int sz = 0, mn = INT_MIN, mx = INT_MAX;
    isValidBST(e, mn, mx, sz);
    return sz;
  }

  bool isValidBST(TreeNode *e, int &mn, int &mx, int &sz) {
    if (e == nullptr) {
      return true;
    }
    int left_sz = 0, right_sz = 0, left_mn = INT_MIN;
    int right_mn = INT_MIN, left_mx = INT_MAX, right_mx = INT_MAX;
    bool left_is_valid = isValidBST(e->left, left_mn, left_mx, left_sz);
    bool right_is_valid = isValidBST(e->right, right_mn, right_mx, right_sz);
    if (left_is_valid && right_is_valid) {
      if ((!e->left || e->val >= left_mx) &&
          (!e->right || e->val <= right_mn)) {
        sz = left_sz + right_sz + 1;
        mn = e->left ? left_mn : e->val;
        mx = e->right ? right_mx : e->val;
        return true;
      }
    }
    sz = max(left_sz, right_sz);
    return false;
  }
};


int main() {
  Solution sol;

  TreeNode *root = new TreeNode(10);
  root->left = new TreeNode(5);
  root->left->left = new TreeNode(1);
  root->left->right = new TreeNode(8);
  root->right = new TreeNode(15);
  root->right->right = new TreeNode(7);

  cout << sol.largestBSTSubtree(root) << "\n";

  return 0;
}
