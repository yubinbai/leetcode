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
  int minMeetingRooms(vector<Interval>& intervals) {
    vector<int> starts, ends;
    for (const auto& i : intervals) {
      starts.push_back(i.start);
      ends.push_back(i.end);
    }
    sort(starts.begin(), starts.end());
    sort(ends.begin(), ends.end());

    int result = 0, cnt_rooms = 0;
    int s = 0, e = 0;
    while (s < starts.size()) {
      if (starts[s] < ends[e]) {
        ++cnt_rooms;
        result = max(result, cnt_rooms);
        ++s;
      } else {
        --cnt_rooms;
        ++e;
      }
    }
    return result;
  }
};

int main() {
  vector<Interval> vec = {Interval(0, 30), Interval(5, 10), Interval(15, 20)};
  Solution sol;
    
  cout << sol.minMeetingRooms(vec) << endl;
  return 0;
}
