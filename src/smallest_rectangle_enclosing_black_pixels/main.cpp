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
  int minArea(vector<vector<char>>& image, int x, int y) {
    int m = image.size();
    int n = image[0].size();
    this->image = image;

    int left = search(0, x, 0, n,  true,  true);
    int right = search(x + 1, m, 0, n, false,  true);
    int top = search(0, y, left, right,  true, false);
    int bottom = search(y + 1, n, left, right, false, false);
    return (right - left) * (bottom - top);
  }
private:
  vector<vector<char>> image;

  bool is_white(int mid, int k, int is_row) {
    return (is_row ? image[mid][k] : image[k][mid]) == '0'; 
  }

  int search(int b, int e, int min_i, int max_i, bool is_smaller_half, bool is_row) {
    while (b != e) {
      int mid = (b + e) / 2;
      int k = min_i;
      while (k < max_i && is_white(mid, k, is_row)) {
        k++;
      }
      if (k < max_i == is_smaller_half) {
        e = mid;
      } else {
        b = mid + 1;
      }
    }
    return b;
  }
};

int main() {
  Solution sol;
  vector<vector<char>> mat = {
    {'0', '0', '1', '0'},
    {'0', '1', '1', '0'},
    {'0', '1', '0', '0'},
  };
  cout << sol.minArea(mat, 0, 2) << endl;
  return 0;
}
