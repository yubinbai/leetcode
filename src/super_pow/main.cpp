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
private:
  int mod = 1337;
public:
  int superPow(int a, vector<int>& b) {
    int n = b.size();
    int result = 1;
    for (int i = n - 1; i >= 0; i--) {
      result = result * mod_pow(a, b[i]) % mod;
      a = mod_pow(a, 10);
    }
    return result;
  }
  inline int mod_pow(int a, int b) {
    int ans = 1;
    a %= mod;
    while (b > 0) {
      if (b & 1) {
        ans = ans * a % mod;
      }
      a = a * a % mod;
      b >>= 1;
    }
    return ans;
  }
};

int main() {
  Solution sol;
  int a;
  vector<int> b;

  a = 2;
  b = {3};
  cout << sol.superPow(a, b) << endl;

  a = 2;
  b = {1, 0};
  cout << sol.superPow(a, b) << endl;

  a = 647;
  b = {2, 0, 0};
  cout << sol.superPow(a, b) << endl;

  a = 2147483647;
  b = {2, 0, 0};
  cout << sol.superPow(a, b) << endl;

  return 0;
}
