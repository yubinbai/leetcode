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
  int mem[201][201];
  int max_cost = 40000;

public:
  int getMoneyAmount(int n) {
    memset(mem, -1, sizeof(mem[0][0]) * 201 * 201);
    return getCost(1, n);
  }

  int getCost(int low, int high) {
    if (mem[low][high] != -1) {
      return mem[low][high];
    }
    if (low == high) {
      return mem[low][high] = 0;
    }
    if (low == high - 1) {
      return mem[low][high] = low;
    }
    if (low == high - 2) {
      return mem[low][high] = low + 1;
    }
    int min = max_cost;
    for (int mid = low + 1; mid < high; mid++) {
      int left = getCost(low, mid - 1); 
      int right = getCost(mid + 1, high);
      int part = left > right ? left : right;
      int whole = part + mid;
      min = min < whole ? min : whole;
    }
    return mem[low][high] = min;
  }
};

int main() {
  Solution sol;

  cout << sol.getMoneyAmount(1) << endl;

  cout << sol.getMoneyAmount(2) << endl;

  cout << sol.getMoneyAmount(10) << endl;

  cout << sol.getMoneyAmount(200) << endl;

  cout << endl;

  return 0;
}
