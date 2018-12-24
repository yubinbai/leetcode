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
  vector<vector<int>> threeSum(vector<int> num) {
    sort(num.begin(), num.end());
    vector<vector<int>> ret = {};
    int n = num.size();

    for (int i = 0; i < n - 2; i++) {
      if (i > 0 && num[i] == num[i - 1]) {
        continue;
      }
      int low = i + 1;
      int high = n - 1;
      while (low < high) {
        int sum = num[i] + num[low] + num[high];
        if (sum > 0) {
          while (high > 0 && num[high] == num[high - 1]) high--;
          high--;
        } else if (sum < 0) {
          while (low < n - 1 && num[low] == num[low + 1]) low++;
          low++;
        } else {
          ret.push_back({num[i], num[low], num[high]});
          while (high > 0 && num[high] == num[high - 1]) high--;
          high--;
          while (low < n - 1 && num[low] == num[low + 1]) low++;
          low++;
        }
      }
    }
    return ret;
  }
};

int main() {
  Solution sol;

  cout << "#1" << endl;
  vector<int> arr = { -1, 0, 1, 2, -1, -4};
  for (auto a : sol.threeSum(arr)) {
    for (auto e : a) {
      cout << e << ' ';
    }
    cout << endl;
  }

  cout << "#2" << endl;
  arr = { 0, 0, 1, 2, -1, -2, 1, 2};
  for (auto a : sol.threeSum(arr)) {
    for (auto e : a) {
      cout << e << ' ';
    }
    cout << endl;
  }
  return 0;
}
