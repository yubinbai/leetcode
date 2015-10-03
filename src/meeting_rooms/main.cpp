#include <iostream>
#include <map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

struct Interval {
  int start;
  int end;
  Interval() : start(0), end(0) {}
  Interval(int s, int e) : start(s), end(e) {}
};

class Solution {
public:
  bool canAttendMeetings(vector<Interval>& intervals) {
    sort(
      intervals.begin(),
      intervals.end(),
      [](const Interval& x, const Interval& y) { return x.start < y.start; }
    );
    for (int i = 1; i < intervals.size(); ++i) {
      if (intervals[i].start < intervals[i - 1].end) {
        return false;
      }
    }
    return true;
  }
};

int main() {
  vector<Interval> vec = {Interval(0, 30), Interval(5, 10), Interval(15, 20)};
  Solution sol;
    
  cout << sol.canAttendMeetings(vec) << endl;
  return 0;
}
