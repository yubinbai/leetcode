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
  TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
    TreeNode* curr = NULL;
    if (p->val > q->val) {
      curr = p;
      p = q;
      q = curr;
    }
    curr = root;
    while (curr != NULL) {
      if (curr->val < p->val) {
	curr = curr->right;
      } else if (curr->val > q->val) {
	curr = curr->left;
      } else {
	break;
      }
    }
    return curr;
  }
};

int main() {
  return 0;
}
