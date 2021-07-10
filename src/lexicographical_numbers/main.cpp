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
  vector<int> lexicalOrder(int n) {
    vector<int> a;
    int curr = 1;
    int end;
    if (n < 10) {
      end = n;
    } else {
      for (end = 9; end < n; ) {
        end *= 10;
        end += 9;
      }
      end /= 10;
    }
    while (curr != end) {
      a.push_back(curr);
      if (curr * 10 < n) {
        curr *= 10;
        continue;
      }
      curr++;
      if (curr == n) {
        a.push_back(n);
        curr = curr / 10;
        if (curr == 0) {
          break;
        }
        curr++;
      }
      while (curr % 10 == 0) {
        curr /= 10;
      }
    }
    if (end < n) {
      a.push_back(end);
    }
    return a;

  }
};


int main() {
  Solution sol;
  vector<int> v;

  v = sol.lexicalOrder(13);
  for (auto i: v) {
    cout << i << ' ';
  }
  cout << endl;

  v = sol.lexicalOrder(23);
  for (auto i: v) {
    cout << i << ' ';
  }
  cout << endl;
    
  v = sol.lexicalOrder(3);
  for (auto i: v) {
    cout << i << ' ';
  }
  cout << endl;

  v = sol.lexicalOrder(113);
  for (auto i: v) {
    cout << i << ' ';
  }
  cout << endl;

  v = sol.lexicalOrder(123);
  for (auto i: v) {
    cout << i << ' ';
  }
  cout << endl;
    
  return 0;
}
