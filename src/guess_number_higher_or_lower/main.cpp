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

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
  int pick = 1;

  int guessNumber(int n) {
    long low = 1, high = n, mid = (1 + n) >> 1;
    long result = guess(mid);
    while (low < high) {
      if (result == 1) {
        low = mid + 1;
      } else {
        high = mid;
      }
      mid = (low + high) >> 1;
      result = guess(mid);
    }
    return low;
  }

  int guess(int c) {
    if (c == pick) {
      return 0;
    }
    return pick > c ? 1 : -1;
  }
};


int main() {
  Solution sol;

  sol.pick = 6;
  cout << sol.guessNumber(10) << endl;

  sol.pick = 1;
  cout << sol.guessNumber(1) << endl;

  sol.pick = 2;
  cout << sol.guessNumber(1) << endl;

  sol.pick = 2;
  cout << sol.guessNumber(2) << endl;

  long large = (1L << 31) - 1;
  cout << (int)large << endl;
  sol.pick = (int)large;
  cout << sol.guessNumber((int)large) << endl;

  sol.pick = (int)large;
  cout << sol.guessNumber(large >> 1) << endl;

  cout << endl;

  return 0;
}
