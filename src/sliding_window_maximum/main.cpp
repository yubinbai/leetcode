#include <iostream>
#include <vector>
#include <deque>

using namespace std;

class MaxQueue {
  private:
    deque<int> maxq, data;
  public:
    void push_back(int element) {
      data.push_back(element);
      while (!maxq.empty() && maxq.back() < element) {
        maxq.pop_back();
      }
      maxq.push_back(element);
    }
    int pop_front() {
      if (data.empty()) return -1;
      if (maxq.front() == data.front()) maxq.pop_front();
      int ret = data.front();
      data.pop_front();
      return ret;
    }
    int get_max() {
      if (maxq.empty()) {
        return -1;
      }
      return maxq.front();
    }
    int size() {
      return data.size();
    }
};

class Solution {
  public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
      vector<int> ret;
      MaxQueue q;
      for (auto& i : nums) {
        q.push_back(i);
        if (q.size() == k) {
          ret.push_back(q.get_max());
          q.pop_front();
        }
      }
      return ret;
    }
};
int main() {
  vector<int> list = {1,3,-1,-3,5,3,6,7};
  Solution s;
  for (auto& i : s.maxSlidingWindow(list, 3)) {
    cout << i << endl;
  }

  return 0;
}
