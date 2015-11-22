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
public:
  int hIndex(vector<int>& citations) {
    sort(citations.begin(), citations.end());
    int result = 0, n = citations.size();
    for (int i = 0; i < n; i++) {
      if (citations[i] >= n - i) {
        result = max(result, n - i);
      }
    }
    return result;
  }
};

int main() {
  Solution sol;
  vector<int> citations = {3, 0, 6, 1, 5};
  cout << sol.hIndex(citations);
  return 0;
}
