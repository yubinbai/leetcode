#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <cstdlib>
#include <sstream>

using namespace std;

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
class Solution {
private:
  vector<string> results;
  vector<int> path;
  void buildPaths(TreeNode* e) {
    if (e == nullptr) {
      return;
    }
    if (e && e->left == nullptr && e->right == nullptr) {
      stringstream str;
      for (int i = 0; i < path.size(); i++) {
        str << path[i] << "->";
      }
      str << e->val;
      results.push_back(str.str());
      return;
    }
    path.push_back(e->val);
    buildPaths(e->left);
    buildPaths(e->right);
    path.pop_back();
  }
public:
  vector<string> binaryTreePaths(TreeNode* root) {
    results.clear();
    buildPaths(root);
    return this->results;
  }
};

int main() {
  Solution sol;
  TreeNode* root = new TreeNode(1);
  root->left = new TreeNode(2);
  root->left->right = new TreeNode(5);
  root->right = new TreeNode(3);
  
  for (auto s : sol.binaryTreePaths(root)) {
    cout << s << endl;
  }
  return 0;
}
