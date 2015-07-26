#include <iostream>
#include <vector>
using namespace std;

class Solution {
  
public:
  bool searchMatrix(vector<vector<int>>& mat, int target) {
    int n = 0, m = 0, t = target;
    t = target;
    n = mat.size();
    if (n <= 0) {
      return false;
    }
    m = mat[0].size();
    if (t < mat[0][0] || t > mat[n-1][m-1]) {
      return false;
    }
    int row = 0;
    int col = m-1;
    while (row <= n-1 && col >= 0) {
      if (mat[row][col] < t)
	row++;
      else if (mat[row][col] > t)
	col--;
      else
	return true;
    }
    return false;
  }
};

int main() {
  vector<vector<int>> matrix {
    {1, 4, 7, 11, 15},
      {2, 5, 8, 12, 19},
	{3, 6, 9, 16, 22},
	  {10, 13, 14, 17, 24},
	    {18, 21, 23, 26, 30}
  };
  Solution s;
  cout << s.searchMatrix(matrix, 5) << endl;
  cout << s.searchMatrix(matrix, 50) << endl;
  return 0;
}
