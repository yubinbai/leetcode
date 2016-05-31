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

class MovingAverage {
private:
  queue<int> q;
  int size;
  double sum;
public:
  MovingAverage(int size) {
    this->size = size;
    sum = 0;
  }
  double next(int val) {
    if (q.size() >= size) {
      sum -= q.front(); q.pop();
    }
    q.push(val);
    sum += val;
    return sum / q.size();
  }
};

int main() {
  MovingAverage m(3);

  cout << m.next(1) << endl;

  cout << m.next(10) << endl;

  cout << m.next(3) << endl;

  cout << m.next(5) << endl;

  return 0;
}
