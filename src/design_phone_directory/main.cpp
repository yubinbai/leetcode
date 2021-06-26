#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <set>
#include <sstream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

using namespace std;

class PhoneDirectory {
public:
  /** Initialize your data structure here
      @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
  PhoneDirectory(int maxNumbers) {
    for(int i=0; i < maxNumbers; i++) {
      q.insert(i);
    }
  }
    
  /** Provide a number which is not assigned to anyone.
      @return - Return an available number. Return -1 if none is available. */
  int get() {
    if(q.empty()) {
      return -1;
    }
    int x = *q.begin();
    q.erase(x);
    return x;
  }
    
  /** Check if a number is available or not. */
  bool check(int number) {
    return q.count(number) == 0;
  }
    
  /** Recycle or release a number. */
  void release(int number) {
    q.erase(number);
  }
    
private:
  set<int> q;
};

int main() {
  PhoneDirectory directory(3);

  // It can return any available phone number. Here we assume it returns 0.
  cout << directory.get() << endl;
  // Assume it returns 1.
  directory.get();
  // The number 2 is available, so return true.
  directory.check(2);
  // It returns 2, the only number that is left.
  directory.get();
  // The number 2 is no longer available, so return false.
  directory.check(2);
  // Release number 2 back to the pool.
  directory.release(2);
  // Number 2 is available again, return true.
  cout << directory.check(2) << endl;

  return 0;
}
