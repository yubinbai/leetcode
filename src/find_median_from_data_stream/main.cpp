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

struct cmpBigger {
  bool operator()(int a, int b) const {
    return a > b;
  }
};

class MedianFinder {
  priority_queue<int> bigger;
  priority_queue<int, vector<int>, cmpBigger> smaller;
public:
  // Adds a number into the data structure.
  void addNum(int num) {
    double median = findMedian();
    if (num > median) {
      smaller.push(num);
    } else {
      bigger.push(num);
    }

    if (smaller.size() < bigger.size()) {
      int t = bigger.top();
      bigger.pop();
      smaller.push(t);
    } else if (smaller.size() > bigger.size() + 1) {
      int t = smaller.top();
      smaller.pop();
      bigger.push(t);
    }
  }

  // Returns the median of current data stream
  double findMedian() {
    if (smaller.size() > bigger.size()) {
      return smaller.top();
    } else if (smaller.size() < bigger.size()) {
      return bigger.top();
    } else if (smaller.size() == 0) {
        return 0.0;
    } else {
      return (0.0 + smaller.top() + bigger.top()) / 2.0;
    }
  }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf;
// mf.addNum(1);
// mf.findMedian();

int main() {
  MedianFinder mf;
  mf.addNum(-1);
  mf.addNum(-2);
  mf.addNum(-3);
  cout << mf.findMedian() << endl;
  return 0;
}
