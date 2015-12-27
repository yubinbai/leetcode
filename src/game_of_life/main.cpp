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
  int neighbor(vector<vector<int>> & board, int i, int j) {
    int counter = 0, m = board.size(), n = board[0].size();

    counter += i - 1 >= 0 && j - 1 >= 0 ? board[i - 1][j - 1] % 2 : 0;
    counter += i - 1 >= 0 ? board[i - 1][j] % 2 : 0;
    counter += i - 1 >= 0 && j + 1 < n ? board[i - 1][j + 1] % 2 : 0;

    counter += j - 1 >= 0 ? board[i][j - 1] % 2 : 0;
    counter += j + 1 < n ? board[i][j + 1] % 2 : 0;

    counter += i + 1 < m && j - 1 >= 0 ? board[i + 1][j - 1] % 2 : 0;
    counter += i + 1 < m ? board[i + 1][j] % 2 : 0;
    counter += i + 1 < m && j + 1 < n ? board[i + 1][j + 1] % 2 : 0;

    return counter;
  }

  void gameOfLife(vector<vector<int>>& board) {
    if (board.empty()) {
      return;
    }
    int m = board.size(), n = board[0].size();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int counter = neighbor(board, i, j);
        if (board[i][j]) {
          if (counter == 2 || counter == 3) board[i][j] += 2;
        } else {
          if (counter == 3) board[i][j] += 2;
        }
      }
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] /= 2;
      }
    }
    return;
  }
};

int main() {
  return 0;
}
