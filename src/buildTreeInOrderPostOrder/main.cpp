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

// * Definition for a binary tree node.
struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
private:
  vector<int> inorder;
  vector<int> postorder;
  
public:
  TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
    this->inorder = inorder;
    this->postorder = postorder;
    int size = inorder.size();
    return buildTreeInRange(0, size - 1, 0, size - 1);
  }
  TreeNode* buildTreeInRange(int x1, int y1, int x2, int y2) {
    if (x1 > y1) {
      return nullptr;
    }
    if (x2 > y2) {
      return nullptr;
    }
    TreeNode* e = new TreeNode();
    e->val = postorder[y2];
    int pos;
    for (pos = x1; pos <= y1; pos++) {
      if (inorder[pos] == postorder[y2]) {
        break;
      }
    }
    int left_size = pos - x1;
    e->left = buildTreeInRange(x1, pos - 1, x2, x2 + left_size - 1);
    e->right = buildTreeInRange(pos + 1, y1, x2 + left_size, y2 - 1);
    return e;
  }
  void printInOrder(TreeNode* e) {
    if (e == nullptr) {
      return;
    }
    printInOrder(e->left);
    printf("%d\t", e->val);
    printInOrder(e->right);
  }
  void printPostOrder(TreeNode* e) {
    if (e == nullptr) return;
    printPostOrder(e->left);
    printPostOrder(e->right);
    printf("%d\t", e->val);
  }
};

int main() {
  Solution s;
  vector<int> inorder = {9,3,15,20,7};
  vector<int> postorder = {9,15,7,20,3};
  TreeNode* t = s.buildTree(inorder, postorder);
  s.printInOrder(t);
  s.printPostOrder(t);

  return 0;
}
