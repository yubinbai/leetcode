#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <cstdlib>

using namespace std;

class Solution {
public:
  bool verifyPreorder(vector<int> preorder) {
    if (preorder.size() <= 1) {
      return true;
    }
    vector<int> stack;
    int curr_max = INT_MIN;
    for (int n : preorder) {
      if (n < curr_max) {
        return false;
      }
      while (stack.size() && n > stack.back()) {
        curr_max = stack.back();
        stack.pop_back();
      }
      stack.push_back(n);
    }
    return true;
  }

  bool verifyPreorderContantSpace(vector<int> preorder) {
    if (preorder.size() <= 1) {
      return true;
    }
    int stack_top = -1;
    int curr_max = INT_MIN;
    for (int n : preorder) {
      if (n < curr_max) {
        return false;
      }
      while (stack_top >= 0 && n > preorder[stack_top]) {
        curr_max = preorder[stack_top];
        stack_top--;
      }
      stack_top++;
      preorder[stack_top] = n;
    }
    return true;
  }
};

int main() {
  Solution sol;
  vector<int> test1 = {3,2,1,5,4,6};
  cout << sol.verifyPreorder(test1) << endl;
  cout << sol.verifyPreorderContantSpace(test1) << endl;
  return 0;
}
