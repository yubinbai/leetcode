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
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
  int longestConsecutive(TreeNode* root) {
    if (root == nullptr) {
      return 0;
    }
    ret = 1;
    _longestConsecutive(root, root->val, 1);
    return ret;
  }
private:
  int ret = 1;
  void _longestConsecutive(TreeNode* node, int parent_value, int len){
    if (node == nullptr) {
      return;
    }
    if (node->val == parent_value + 1){
      ret = max(ret, len + 1);
    } else {
      len = 0;            
    }
    _longestConsecutive(node->left, node->val, len + 1);
    _longestConsecutive(node->right, node->val, len + 1);        
  }
};

int main() {
  TreeNode* root = new TreeNode(1);
  root->left = new TreeNode(2);
  Solution sol;
  cout << sol.longestConsecutive(root);
  return 0;
}
