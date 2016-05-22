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

class NestedInteger {
private:
  int value;
  bool is_integer;
  vector<NestedInteger> children;

public:
  NestedInteger(int value, bool is_integer, vector<NestedInteger> children) {
    this->value = value;
    this->is_integer = is_integer;
    this->children = children;
  }

  bool isInteger() const {
    return is_integer;
  }
 
  int getInteger() const {
    return value;
  }

  vector<NestedInteger> &getList() {
    return children;
  }
};

class Solution {
public:
  int depthSum(vector<NestedInteger>& nestedList) {
    return depthSumHelper(nestedList, 1);
  }

private:
  int depthSumHelper(vector<NestedInteger>& nestedList, int depth) {
    int ret = 0;
    for (auto& list : nestedList) {
      if (list.isInteger()) {
        ret += list.getInteger() * depth;
      } else {
        ret += depthSumHelper(list.getList(), depth + 1);
      }
    }
    return ret;
  }
};


int main() {
  Solution sol;
  vector<NestedInteger> empty_vector = {};
  NestedInteger one(1, true, empty_vector);
  vector<NestedInteger> fragment = {one, one};
  vector<NestedInteger> list = {
    NestedInteger(0, false, fragment),
    NestedInteger(2, true, empty_vector),
    NestedInteger(0, false, fragment),
  };

  cout << sol.depthSum(list);

  return 0;
}
