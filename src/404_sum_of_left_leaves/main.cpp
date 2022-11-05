#include <cstdlib>
#include <iostream>
#include <list>
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
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {

public:
  int sumOfLeftLeaves(TreeNode* root) {
    int result = 0;
    dfs(root, &result);
    return result;
  }

  void dfs(TreeNode* e, int* sum) {
    if (e->left) {
      TreeNode* eLeft = e->left;
      if (!eLeft->left && !eLeft->right) {
        *sum += eLeft->val;
      } else {
        dfs(eLeft, sum);
      }
    }
    if (e->right) {
      dfs(e->right, sum);
    }
  }
};

int main(int argc, const char * argv[]) {
  Solution sol;
  cout << "Hello World" << endl;
  return 0;
}
