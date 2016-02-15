#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <stack>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
  int nthSuperUglyNumber(int n, vector<int>& primes) {
    int k = primes.size();
    vector<int> result = {1};
    vector<int> p(k, 0);
    for (int i = 1; i < n; i++) {
      int prev = result.back();
      int curr = INT_MAX;
      for (int j = 0; j < k; j++) {
        // bisect_right, return next pos of last x (insert point)
        int low = p[j];
        int high = result.size() - 1;
        while (low < high) {
          int mid = low + (high - low) / 2;
          if (1L * result[mid] * primes[j] > prev) {
            high = mid;
          } else {
            low = mid + 1;
          }
        }
        p[j] = low;
        curr = min(curr, result[p[j]] * primes[j]);
      }
      result.push_back(curr);
    }
    return result[n - 1];
  }
};

int main() {
  Solution sol;
  vector<int> primes = {2, 7, 13, 19};
  for (int i = 1; i < 10; i++) {
    cout << sol.nthSuperUglyNumber(i, primes) << endl;
  }

  vector<int> primes2 = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};
  cout << sol.nthSuperUglyNumber(100000, primes2) << endl;
  return 0;
}
