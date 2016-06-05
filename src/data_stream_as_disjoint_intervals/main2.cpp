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
    if (m.empty()) {
      m[val] = val;
      isDirty = true;
    }
    auto bound = m.lower_bound(val);
    if (bound == m.end()) {
      bound--;
      if (bound->second < val) {
        m[val] = val;
        isDirty = true;
      }
    } else if (bound->first != val) {
      m[val] = val;
      isDirty = true;
    } // else no op
  }
    
  vector<Interval> getIntervals() {
    if (isDirty) {
      v.clear();
      auto iter = m.begin();
      Interval cur(iter->first, iter->second);
      while (iter != m.end()) {
        if (iter->first > cur.end + 1) {
          v.push_back(Interval(cur.start, cur.end));
          cur.start = iter->first; 
          cur.end = iter->second;
        } else {
          cur.end = iter->second;
        }
        iter++;
      }
      v.push_back(cur);
      m.clear();
      for (auto iterV: v) {
        m[iterV.start] = iterV.end;
      }
      isDirty = false;
    }
    return v;
  }
    
private:
  vector<Interval> v;
  bool isDirty = false;
  map<int, int> m;
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
