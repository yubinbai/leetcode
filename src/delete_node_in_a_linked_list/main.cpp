struct ListNode {
  int val;
  ListNode *next;
  ListNode(int x) : val(x), next(nullptr) {}
};

class Solution {
public:
  void deleteNode(ListNode* node) {
    if (node->next == nullptr) {
      return;
    }
    node->val = node->next->val;
    node->next = node->next->next;
  }
};

int main() {
  return 0;
}
