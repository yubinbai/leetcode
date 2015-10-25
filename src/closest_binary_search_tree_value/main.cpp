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
  TreeNode(int x) { val = x; left = nullptr; right = nullptr;}
};

class Solution {
public:
  int closestValue(TreeNode* root, double target) {
    int ret = root->val; 
    while(root != nullptr){ 
      //update ret if the current value is closer to target
      ret = abs(target - root->val) < abs(target - ret)
        ? root->val
        : ret;

      //binary search
      root = root->val > target
        ? root->left
        : root->right;
    }
    return ret;
  }
};

int main() {
  Solution sol;
  TreeNode e(2);
  e.left = new TreeNode(1);
  e.right = new TreeNode(4);
  cout << sol.closestValue(&e, 1.7) << endl;
  return 0;
}
