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

class Solution {
public:
  bool isValidSerialization(string preorder) {
    vector<bool> tokens;
    istringstream iss(preorder);
    for (string token; getline(iss, token, ','); ) {
      tokens.push_back(token != "#");
    }

    while (tokens.size() >= 3) {
      vector<bool> next_tokens;
      int k = 0;
      for (int i = 0; i < tokens.size(); i++) {
        if (i < tokens.size() - 2 &&
            tokens[i] &&
            !tokens[i + 1] &&
            !tokens[i + 2]) {
          next_tokens.push_back(false);
          i += 2;
        } else {
          next_tokens.push_back(tokens[i]);
        }
      }
      if (tokens.size() == next_tokens.size()) {
        return false;
      }
      tokens = next_tokens;
    }
    return tokens.size() == 1 && !tokens.front();
  }
};

int main() {
  Solution sol;
  cout << sol.isValidSerialization("1,#,#") << endl;

  cout << sol.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#") << endl;

  cout << sol.isValidSerialization("1,#") << endl;

  cout << sol.isValidSerialization("9,#,#,1") << endl;

  cout << sol.isValidSerialization("1,#,#,#,#") << endl;

  return 0;
}
