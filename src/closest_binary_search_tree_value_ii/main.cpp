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

class TreeNode {
public:
  int val;
  TreeNode* left;
  TreeNode* right;
  TreeNode(int x) { val = x; left = nullptr; right = nullptr; }
};

class Solution {
public:
  vector<int> closestKValues(TreeNode* root, double target, int k) {
    vector<int> result;
    if (root == nullptr) {
      return result;
    }
         
    vector<int> precedessor, successor;
    getPredecessor(root, target, precedessor);
    getSuccessor(root, target, successor);
         
    for (int i = 0; i < k; i++) {
      if (precedessor.empty()) {
        result.push_back(successor.back());
        successor.pop_back();
      } else if (successor.empty()) {
        result.push_back(precedessor.back());
        precedessor.pop_back();
      } else if (abs((double)precedessor.back() - target) <
                 abs((double)successor.back() - target)) {
        result.push_back(precedessor.back());
        precedessor.pop_back();
      } else {
        result.push_back(successor.back());
        successor.pop_back();
      }
    }
    return result;
  }
     
private:
  void getPredecessor(TreeNode* root, double target, vector<int> &precedessor) {
    if (root == nullptr) {
      return;
    }
    getPredecessor(root->left, target, precedessor);
    if (root->val > target) {
      return;
    }
    precedessor.push_back(root->val);
    getPredecessor(root->right, target, precedessor);
  }
     
  void getSuccessor(TreeNode* root, double target, vector<int> &successor) {
    if (root == nullptr) {
      return;
    }
    getSuccessor(root->right, target, successor);
    if (root->val <= target) {
      return;
    }
    successor.push_back(root->val);
    getSuccessor(root->left, target, successor);
  }
};

int main() {
  Solution sol;
  TreeNode e(2);
  e.left = new TreeNode(1);
  e.right = new TreeNode(4);
  for (auto v : sol.closestKValues(&e, 1.7, 2)) {
    cout << v << endl;
  }
  return 0;
}
