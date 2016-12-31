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
  bool isPerfectSquare(int num) {
    long i = 1;
    while (i * i < num) {
      i++;
    }
    return i * i == num;
  }
};

int main() {
  Solution sol;

  cout << sol.isPerfectSquare(16) << endl;
  cout << sol.isPerfectSquare(14) << endl;

  return 0;
}
