#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  int nthUglyNumber(int n) {
    queue<int> q2, q3, q5;
    q2.push(1);
    q3.push(1);
    q5.push(1);
    int curr = 1;
    for (int i = 1; i < n; i++) {
      while (!q2.empty() && q2.front() * 2 <= curr) {
        q2.pop();
      }
      while (!q3.empty() && q3.front() * 3 <= curr) {
        q3.pop();
      }
      while (!q5.empty() && q5.front() * 5 <= curr) {
        q5.pop();
      }
      curr = min(min(q2.front() * 2, q3.front() * 3), q5.front() * 5);
      q2.push(curr);
      q3.push(curr);
      q5.push(curr);
    }
    return curr;    
  }
};

int main() {
  Solution sol;
  for (int i = 1; i < 10; i++) {
    cout << sol.nthUglyNumber(i) << endl;
  }
  return 0;
}
