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

bool comp_pairs (pair<int, int> p, pair<int, int> q) {
  return (p.first + p.second < q.first + q.second);
}

class Solution {
public:
  vector<pair<int, int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2, int k) {
    vector<pair<int, int>> result;
    for (int i = 0; i < k && i < nums1.size(); i++) {
      for (int j = 0; j < k - i && j < nums2.size(); j++) {
        result.push_back(make_pair(nums1[i], nums2[j]));
      }
    } 
    sort(result.begin(), result.end(), comp_pairs);
    if (result.size() < k) {
      return result;
    }
    vector<pair<int, int>> ret(result.begin(), result.begin() + k);
    return ret;
  }
};

int main() {
  Solution sol;
  vector<int> a, b;
  int k;

  a = {1, 7, 11};
  b = {2, 4, 6};
  k = 3;
  for (auto p: sol.kSmallestPairs(a, b, k)) {
    cout << p.first << ", " << p.second << endl;
  }
  cout << endl;

  a = {1, 1, 2};
  b = {1, 2, 3};
  k = 2;
  for (auto p: sol.kSmallestPairs(a, b, k)) {
    cout << p.first << ", " << p.second << endl;
  }
  cout << endl;

  a = {1, 2};
  b = {3};
  k = 2;
  for (auto p: sol.kSmallestPairs(a, b, k)) {
    cout << p.first << ", " << p.second << endl;
  }
  cout << endl;

  a = {};
  b = {};
  k = 5;
  for (auto p: sol.kSmallestPairs(a, b, k)) {
    cout << p.first << ", " << p.second << endl;
  }
  cout << endl;

  return 0;
}
