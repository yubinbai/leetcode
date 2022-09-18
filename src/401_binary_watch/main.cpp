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

class Solution {
private:
  vector<vector<string>> lookup;
public:
  vector<string> readBinaryWatch(int turnedOn) {
    if (lookup.size() > 0) {
      return lookup[turnedOn];
    }
    for (int i = 0; i <= 10; i++) {
      vector<string> v;
      lookup.push_back(v);
    }
    for (int i = 0; i <= 0b1111111111; i++) {
      int hour = 0;
      int minute = 0;
      int digits = 0;
      if (i & (1 << 9)) {
        hour += 8;
        digits++;
      }
      if (i & (1 << 8)) {
        hour += 4;
        digits++;
      }
      if (i & (1 << 7)) {
        hour += 2;
        digits++;
      }
      if (i & (1 << 6)) {
        hour += 1;
        digits++;
      }
      if (hour >= 12) {
        continue;
      }
      if (i & (1 << 5)) {
        minute += 32;
        digits++;
      }
      if (i & (1 << 4)) {
        minute += 16;
        digits++;
      }
      if (i & (1 << 3)) {
        minute += 8;
        digits++;
      }
      if (i & (1 << 2)) {
        minute += 4;
        digits++;
      }
      if (i & (1 << 1)) {
        minute += 2;
        digits++;
      }
      if (i & 1) {
        minute += 1;
        digits++;
      }
      if (minute >= 60) {
        continue;
      }
      stringstream ss;
      ss << hour << ':';
      if (minute < 10) {
        ss << "0";
      }
      ss << minute;
      lookup[digits].push_back(ss.str());
      // cout << ss.str() << " ";
    }
    vector<string> r = lookup[turnedOn];
    return r;
  }
};

int main() {

  Solution sol;

  sol.readBinaryWatch(1);

  return 0;
}
