#include <iostream>
#include <map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  int countUnivalSubtrees(TreeNode* root) {
    int count = 0;
    isUnivalSubtrees(root, &count);
    return count;
  }
    
  bool isUnivalSubtrees(TreeNode* root, int *count) {
    if (root == nullptr) {
      return true;
    }
    bool left = isUnivalSubtrees(root->left, count);
    bool right = isUnivalSubtrees(root->right, count);
    if (left &&
        isSameValue(root, root->left) &&
        right &&
        isSameValue(root, root->right)) {
      ++(*count);
      return true;
    }
    return false;
  }
    
  bool isSameValue(TreeNode* root, TreeNode* child) {
    return child == nullptr || root->val == child->val;
  }
};

int main() {
  Solution sol;
  TreeNode* root = new TreeNode(5);
  root->left = new TreeNode(1);
  root->left->left = new TreeNode(5);
  root->left->right = new TreeNode(5);
  root->right = new TreeNode(5);
  root->right->right = new TreeNode(5);

  cout << sol.countUnivalSubtrees(root) << endl;
  return 0;
}
