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

class Parabola {
public:
  Parabola(int a, int b, int c) {
    this->a = a;
    this->b = b;
    this->c = c;
  }
  
  int value(int x) {
    return x * (a * x + b) + c;
  }
private:
  int a, b, c;
};

class Solution {
public:
  vector<int> sortTransformedArray(vector<int>& nums, int a, int b, int c) {
    Parabola p(a, b, c);
    int n = nums.size(), left = 0, right = n - 1;
    vector<int> res(n);
    if (a >= 0) {
      int idx = n - 1;
      while (left <= right) {
        res[idx--] = p.value(nums[left]) >= p.value(nums[right])
          ? p.value(nums[left++])
          : p.value(nums[right--]);
      }
    } else {
      int idx = 0;
      while (left <= right) {
        res[idx++] = p.value(nums[left]) >= p.value(nums[right])
          ? p.value(nums[right--])
          : p.value(nums[left++]);
      }
    }
    return res;
  }
};

int main() {
  int a, b, c;
  vector<int> nums;
  Solution sol;

  nums = {-4, -2, 2, 4}, a = 1, b = 3, c = 5;
  for (int i : sol.sortTransformedArray(nums, a, b,  c)) {
    cout << i << ' ';
  }
  cout << endl;
  
  nums = {-4, -2, 2, 4}, a = -1, b = 3, c = 5;
  for (int i : sol.sortTransformedArray(nums, a, b,  c)) {
    cout << i << ' ';
  }
  cout << endl;
}
