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

class Interval {
public:
  Interval() : start(0), end(0) {}
  Interval(int s, int e) : start(s), end(e) {}
  string toString() {
    ostringstream s;
    s << "[" << this->start << "," << this->end << "] ";
    return s.str();
  }
  int start;
  int end;
};

class SummaryRanges {
public:
  /** Initialize your data structure here. */
  SummaryRanges() {}
    
  void addNum(int val) {
    Interval cur(val, val);
    vector<Interval> res;
    int pos = 0;
    for (auto a : v) {
      if (cur.end + 1 < a.start) {
        res.push_back(a);
      } else if (cur.start > a.end + 1) {
        res.push_back(a);
        ++pos;
      } else if (cur.start - 1 == a.end) {
        cur.start = a.start;
      } else if (cur.end + 1 == a.start) {
        cur.end = a.end;
      } else {
        cur.start = min(cur.start, a.start);
        cur.end = max(cur.end, a.end);
      }
    }
    res.insert(res.begin() + pos, cur);
    v = res;
  }
    
  vector<Interval> getIntervals() {
    return v;    
  }
    
private:
  vector<Interval> v;
};


int main() {
  SummaryRanges obj;

  vector<int> stream;
  vector<Interval> intervals;

  stream = {1, 3, 7, 2, 6};
  for (int i: stream) {
    cout << "add: " << i << endl;
    obj.addNum(i);
    intervals = obj.getIntervals();
    for (Interval interval: intervals) {
      cout << interval.toString() << endl;
    }
  }

  return 0;
}
