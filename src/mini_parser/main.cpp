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

class NestedInteger {
private:
  int value;
  bool is_integer;
  vector<NestedInteger> children;

public:
  NestedInteger(int value, bool is_integer) {
    this->value = value;
    this->is_integer = is_integer;
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

  void add(const NestedInteger &ni) {
    children.push_back(ni);
  }
};

class Solution {
private:
  bool is_numeric(char c) {
    return c == '-' || (c >= '0' && c <= '9');
  }
public:
  NestedInteger deserialize(string s) {
    vector<NestedInteger> stack;
    NestedInteger last(0, false);

    for (int pos = 0; pos < s.size(); ) {
      if (is_numeric(s[pos])) {
        int begin = pos;
        while (is_numeric(s[pos])) {
          pos++;
        }
        string num = s.substr(begin, pos - begin);
        int n = std::stoi(num);
        NestedInteger current(n, true);
        if (stack.empty()) {
          stack.push_back(current);
        } else {
          stack.back().add(current);
        }
      }
      if (s[pos] == '[') {
        NestedInteger current(0, false);
        stack.push_back(current);
      }
      if (s[pos] == ']') {
        last = stack.back();
        stack.pop_back();
        if (!stack.empty()) {
          stack.back().add(last);
        }
      }
      // if comma, ignore and move to next
      pos++;
    }

    if (stack.empty()) {
      return last;
    } else {
      return stack.back();
    }
  }
};


int main() {
  Solution sol;
  string s;

  s = "123";
  sol.deserialize(s); // inspect with debugger

  s = "[123,[456,[789]]]";
  sol.deserialize(s); // inspect with debugger

  return 0;
}
