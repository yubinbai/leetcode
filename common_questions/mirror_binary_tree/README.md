Problem
===

Find mirror image of a binary tree
input:
8
/ \
6 10
/\ /\
5 7 9 11
output:
8
/ \
10 6
/\ /\
11 9 7 5

Solution
===
void swap(Node ** l, Node ** r) {
  Node *p = *l;
  *l = *r;
  *r = p;
}
void mirror(Node * root) {
  if (root == NULL) return;
  swap(&(root->left), &(root->right));
  mirror(root->left);
  mirror(root->right);
}
void mirrorIteratively(Node * root) {
  if (root == NULL) return;
  stack<Node*> buf;
  buf.push(root);
  while (!stack.empty()) {
    Node * n = stack.pop();
    swap(&(root->left), &(root->right));
    if (root->left != NULL) buf.push(root->left);
    if (root->right != NULL) buf.push(root->right);
  }
}
