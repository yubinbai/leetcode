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
  int threeSumClosest(vector<int> num, int target) {
    sort(num.begin(), num.end());
    int result = INT_MAX;
    int minDist = INT_MAX;

    for (int i = 0; i < num.size() - 2; i++) {
      int low = i + 1;
      int high = num.size() - 1;
      while (low < high) {
        int curr = num[i] + num[low] + num[high];
        int dist = abs(curr - target);
        if (dist < minDist) {
          minDist = dist;
          result = curr;
        }
        if (curr > target) {
          high--;
        } else {
          low++;
        }
      }
    }
    return result;
  }
};

int main() {
  Solution sol;
  vector<int> arr = {-1, 2, 1, -4};
  int target = 1;
  cout << sol.threeSumClosest(arr, 1);
  return 0;
}
