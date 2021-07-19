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
  int lastRemaining(int n) {
    if (n == 1) {
      return 1;
    }
    int first = 1, last = n;
    int count = n;
    bool odd = true;
    for(int step = 1; first != last; step <<= 1) {
      if(odd) {
        first += step;
        if (count % 2 == 1) {
          last -= step;
        }
        odd = false;
      } else {
        last -= step;
        if (count % 2 == 1) {
          first += step;
        }
        odd = true;
      }
      count /= 2;
    }
    return first;
  }

  int lastRemaining2(int n) {
    bool left2right = true;
    int res = 1, step = 1, remain = n;
    while (remain > 1) {
      if (left2right || remain % 2 == 1) {
        res += step;
      }
      remain /= 2;
      step *= 2;
      left2right = !left2right;
    }
    return res;
  }
};


int main() {

  Solution sol;

  for (int i = 1; i < 100; i++) {
    cout << i << '\t' << sol.lastRemaining(i) << '\t' << sol.lastRemaining2(i) << endl;
  }

  return 0;
}
