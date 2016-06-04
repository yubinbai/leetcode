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

class TicTacToe {
public:
  TicTacToe(int n): rows(n), cols(n), N(n), diag(0), rev_diag(0) {}

  int move(int row, int col, int player) {
    int delta = player == 1 ? 1 : -1;
    rows[row] += delta;
    cols[col] += delta;
    diag += (row == col ? delta : 0);
    rev_diag += (row == N - col - 1 ? delta : 0);
    return
      (abs(rows[row]) == N ||
       abs(cols[col]) == N ||
       abs(diag) == N ||
       abs(rev_diag) == N)
      ? player
      : 0;
  }

private:
  vector<int> rows, cols;
  int diag, rev_diag, N;
};


int main() {
  TicTacToe toe(3);

  cout << toe.move(0, 0, 1) << endl;
  cout << toe.move(0, 2, 2) << endl;
  cout << toe.move(2, 2, 1) << endl;
  cout << toe.move(1, 1, 2) << endl;
  cout << toe.move(2, 0, 1) << endl;
  cout << toe.move(1, 0, 2) << endl;
  cout << toe.move(2, 1, 1) << endl;

  return 0;
}
