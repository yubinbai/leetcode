#include <algorithm>
#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <stack>
#include <string>
#include <tuple>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
private:
  int _compareSeq(const vector<int> &a, int pa, const vector<int> &b, int pb) {
    int na = a.size();
    int nb = b.size();
    while (pa < na && pb < nb) {
      if (a[pa] > b[pb]) {
        return 1;
      } else if (a[pa] < b[pb]) {
        return -1;
      }
      pa++;
      pb++;
    }
    return pa == na ? -1 : 1;
  }

  vector<int> _maxSubSequence(const vector<int> &a, int k) {
    int n = a.size();
    vector<int> ans;
    for (int i = 0; i < n; i++) {
      while (!ans.empty() && ans.back() < a[i] && n - i + ans.size() > k) {
        ans.pop_back();
      }
      if (ans.size() < k) {
        ans.push_back(a[i]);
      }
    }
    return ans;
  }

public:
  vector<int> maxNumber(vector<int>& nums1, vector<int>& nums2, int k) {
    int len1 = nums1.size();
    int len2 = nums2.size();
    vector<int> ans(k, 0);
    for (int i = max(0, k - len2); i <= min(k, len1); i++) {
      vector<int> res1 = _maxSubSequence(nums1, i);
      vector<int> res2 = _maxSubSequence(nums2, k - i);
      vector<int> res;
      int p1 = 0, p2 = 0;
      while(p1 < i || p2 < k - i) {
        if (_compareSeq(res1, p1, res2, p2) > 0) {
          res.push_back(res1[p1++]);
        } else {
          res.push_back(res2[p2++]);
        }
      }
      if (_compareSeq(ans, 0, res, 0) < 0) {
        ans = res;
      }
    }
    return ans;    
  }
};

int main() {
  Solution sol;
  vector<int> nums1 = {3, 4, 6, 5};
  vector<int> nums2 = {9, 1, 2, 5, 8, 3};
  vector<int> number = sol.maxNumber(nums1, nums2, 5);
  for (int i: number) {
    cout << i << endl;
  }
  return 0;
}

