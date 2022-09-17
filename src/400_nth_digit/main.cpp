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
  int findNthDigit(int n) {
    long remain = n;
    long start = 1;
    int d = 1;
    while (remain > start * d * 9) {
      remain -= start * d * 9;
      start *= 10;
      d++;
    }
    int curr = start  + (remain - 1) / d ;
    int remove_digit = (d - remain % d) %d ;
    // cout << curr << "\t" << remove_digit << endl;
    while (remove_digit != 0) {
      curr = curr / 10;
      remove_digit--;
    }
    return curr % 10;
  }
};

int main() {

  Solution sol;
  int n;
  int result;

  n = 3;
  result = sol.findNthDigit(n);
  cout << "n=" << n << "\t" << result << endl;

  n = 10;
  result = sol.findNthDigit(n);
  cout << "n=" << n << "\t" << result << endl;

  n = 11;
  result = sol.findNthDigit(n);
  cout << "n=" << n << "\t" << result << endl;

  n = 12;
  result = sol.findNthDigit(n);
  cout << "n=" << n << "\t" << result << endl;

  n = 13;
  result = sol.findNthDigit(n);
  cout << "n=" << n << "\t" << result << endl;

  n = 14;
  result = sol.findNthDigit(n);
  cout << "n=" << n << "\t" << result << endl;

  n = 15;
  result = sol.findNthDigit(n);
  cout << "n=" << n << "\t" << result << endl;

  n = 16;
  result = sol.findNthDigit(n);
  cout << "n=" << n << "\t" << result << endl;

  return 0;
}
