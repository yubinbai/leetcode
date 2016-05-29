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

class NestedIterator {
public:
  NestedIterator(vector<NestedInteger> &nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; --i) {
      s.push(nestedList[i]);
    }
  }

  int next() {
    NestedInteger t = s.top();
    s.pop();
    return t.getInteger();
  }

  bool hasNext() {
    while (!s.empty()) {
      NestedInteger t = s.top(); 
      if (t.isInteger()) {
        return true;
      }
      s.pop();
      for (int i = t.getList().size() - 1; i >= 0; --i) {
        s.push(t.getList()[i]);
      }
    }
    return false;
  }

private:
  stack<NestedInteger> s;
};

int main() {
  vector<NestedInteger> emptyVector = {};
  NestedInteger one(1, true, emptyVector);
  vector<NestedInteger> fragment = {one, one};
  vector<NestedInteger> nestedList;

  nestedList = {
    NestedInteger(0, false, emptyVector),
    NestedInteger(0, false, fragment),
  };
  NestedIterator ii(nestedList);
  while (ii.hasNext()) {
    cout << ii.next() << endl;
  }
 
  nestedList= {
    NestedInteger(0, false, fragment),
    NestedInteger(2, true, emptyVector),
    NestedInteger(0, false, fragment),
  };
  NestedIterator i(nestedList);
  while (i.hasNext()) {
    cout << i.next() << endl;
  }

  return 0;
}
