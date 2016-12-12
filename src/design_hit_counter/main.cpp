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

class HitCounter {
public:
  /** Initialize your data structure here. */
  HitCounter() {}

  /** Record a hit.
      @param timestamp - The current timestamp (in seconds granularity). */
  void hit(int timestamp) {
    q.push(timestamp);
  }

  /** Return the number of hits in the past 5 minutes.
      @param timestamp - The current timestamp (in seconds granularity). */
  int getHits(int timestamp) {
    while (!q.empty() && timestamp - q.front() >= 300) {
      q.pop();
    }
    return q.size();
  }

private:
  queue<int> q;
};

int main() {
  HitCounter counter;
  counter.hit(1);
  counter.hit(2);
  counter.hit(3);
  cout << counter.getHits(4) << endl;

  counter.hit(300);
  cout << counter.getHits(300) << endl;
  cout << counter.getHits(301) << endl;

  return 0;
}
