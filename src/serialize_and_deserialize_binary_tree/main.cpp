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

class Codec {
public:
  // Encodes a tree to a single string.
  string serialize(TreeNode* root) {
    ostringstream out;
    _serialize(root, out);
    return out.str();
  }

  // Decodes your encoded data to tree.
  TreeNode* deserialize(string data) {
    istringstream in(data);
    return _deserialize(in);
  }

private:
  void _serialize(TreeNode* root, ostringstream& out) {
    if (root == nullptr) {
      out << "$ ";
      return;
    }
    out << root->val << " ";
    _serialize(root->left, out);
    _serialize(root->right, out);
  }

  TreeNode* _deserialize(istringstream& in) {
    string val;
    in >> val;
    if (val == "$" || val.empty() ) {
      return nullptr;
    }
    TreeNode* node = new TreeNode(stoi(val));
    node->left = _deserialize(in);
    node->right = _deserialize(in);
    return node;
  }
};


int main() {
  TreeNode* root = new TreeNode(1);
  root->left = new TreeNode(2);
  Codec codec;
  codec.deserialize(codec.serialize(root));
  return 0;
}
