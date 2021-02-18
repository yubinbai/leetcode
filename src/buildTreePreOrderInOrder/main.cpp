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
  vector<int> preorder;
  vector<int> inorder;
  
public:
  TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
    this->preorder = preorder;
    this->inorder = inorder;
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
    e->val = preorder[x1];
    int pos;
    for (pos = x2; pos <= y2; pos++) {
      if (inorder[pos] == preorder[x1]) {
        break;
      }
    }
    int left_size = pos - x2;
    e->left = buildTreeInRange(x1 + 1, x1 + left_size, x2, pos - 1);
    e->right = buildTreeInRange(x1 + left_size + 1, y1, pos + 1, y2);
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
  void printPreOrder(TreeNode* e) {
    if (e == nullptr) return;
    printf("%d\t", e->val);
    printPreOrder(e->left);
    printPreOrder(e->right);
  }
};

int main() {
  Solution s;
  vector<int> preorder = {1, 2};
  vector<int> inorder = {1, 2};
  TreeNode* t = s.buildTree(preorder, inorder);
  s.printPreOrder(t);
  cout << endl;
  s.printInOrder(t);
  cout << endl;

  preorder = {3,9,20,15,7};
  inorder = {9,3,15,20,7};
  t = s.buildTree(preorder, inorder);
  s.printPreOrder(t);
  cout << endl;
  s.printInOrder(t);
  cout << endl;

  return 0;
}
