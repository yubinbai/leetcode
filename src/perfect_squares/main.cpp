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

class Solution {
private:
  vector<int> memo;
  int _numSquares(int n) {
    if (memo[n] != -1) {
      return memo[n];
    }
    int result = INT_MAX;
    for (int i = 1; i * i <= n; i++) {
      result = min(result, 1 + _numSquares(n - i * i));
    }
    return memo[n] = result;
  }
public:
  int numSquares(int n) {
    if (n > 0) {
      memo.resize(n + 1, -1);
      memo[0] = 0;
      return _numSquares(n);
    } else {
      return -1;
    }
  }
};

int main() {
  Solution sol;
  cout << sol.numSquares(6) << endl;
  cout << sol.numSquares(12) << endl;
  cout << sol.numSquares(13) << endl;
  cout << sol.numSquares(9732) << endl;
  return 0;
}
