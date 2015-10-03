#include <iostream>
#include <map>
#include <vector>
#include <string>
#include <cstdlib>

using namespace std;

class Solution {
public:
  vector<vector<int>> getFactors(int n) {
    vector<vector<int>> result;
    vector<int> factors;
    getResult(n, &result, &factors);
    return result;
  }

  void getResult(int n, vector<vector<int>> *result, vector<int> *factors) {
    for (int i = factors->empty() ? 2 : factors->back(); i <= n / i; ++i) {
      if (n % i == 0) {
        factors->push_back(i);
        factors->push_back(n / i);
        result->push_back(*factors);
        factors->pop_back();
        getResult(n / i, result, factors);
        factors->pop_back();
      }
    }
  }
};

int main() {
  Solution sol;
  for (auto v : sol.getFactors(100)) {
    for (auto n : v) {
      cout << n << ' ';
    }
    cout << endl;
  }
  return 0;
}
