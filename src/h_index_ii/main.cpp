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
    int n = citations.size();
    int low = 0, high = n - 1;
    while (low < high - 2) {
      int m1 = low + (high - low) / 3;
      int fm1 = min(citations[m1], n - m1);
      int m2 = high - (high - low) / 3;
      int fm2 = min(citations[m2], n - m2);
      if (fm1 > fm2) {
        high = m2;
      } else {
        low = m1;
      }
    }
    int result = 0;
    if (n > 0) {
      result = max(result, min(citations[low], n - low));
    }
    if (n > 1) {
      result = max(result, min(citations[low + 1], n - low - 1));
    }
    if (n > 2) {
      result = max(result, min(citations[low + 2], n - low - 2));
    }
    return result;
  }
};

int main() {
  Solution sol;
  vector<int> citations = {0, 1, 3, 5, 6};
  cout << sol.hIndex(citations) << endl;

  vector<int> citations1 = {1};
  cout << sol.hIndex(citations1) << endl;

  vector<int> citations2 = {};
  cout << sol.hIndex(citations2) << endl;

  vector<int> citations3 = {1, 2, 2, 2};
  cout << sol.hIndex(citations3) << endl;
  return 0;
}
