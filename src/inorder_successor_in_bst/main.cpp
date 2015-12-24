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

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

class Solution {
  TreeNode* ret = nullptr;
  bool found = false;
public:
  TreeNode* inorderSuccessor(TreeNode* root, TreeNode* p) {
    if (p == nullptr || root == nullptr) {
      return nullptr;
    }

    TreeNode* curr = root;
    TreeNode* successor = nullptr;
    while (curr != nullptr && curr->val != p->val) {
      if (curr->val > p->val) {
        // last left turn
        successor = curr;
        curr = curr->left;
      } else {
        curr = curr->right;
      }
    }
    if (curr == nullptr) {
      // not found
      return nullptr;
    }

    if (curr->right != nullptr) {
      // successor inside right children
      successor = curr->right;
      while (successor->left != nullptr) {
        successor = successor->left;
      }
    }
    return successor;
  }
};

int main() {
  TreeNode root(2);
  root.left = new TreeNode(1);
  root.right = new TreeNode(3);
  Solution sol;
  TreeNode* ret = sol.inorderSuccessor(&root, &root);
  cout << ret->val << endl;
  return 0;
}
