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

// Below is the interface for Iterator, which is already defined for you.
// **DO NOT** modify the interface for Iterator.
class Iterator {
  struct Data;
  Data* data;
public:
  Iterator(const vector<int>& nums);
  Iterator(const Iterator& iter);
  virtual ~Iterator();
  // Returns the next element in the iteration.
  int next();
  // Returns true if the iteration has more elements.
  bool hasNext() const;
};

class PeekingIterator : public Iterator {
  int peekedElement = 0;
  bool hasPeeked = false;
public:
  PeekingIterator(const vector<int>& nums) : Iterator(nums) {
  }

  // Returns the next element in the iteration without advancing the iterator.
  int peek() {
    if (!hasPeeked) {
      peekedElement = Iterator::next();
      hasPeeked = true;
    }
    return peekedElement;
  }

  // hasNext() and next() should behave the same as in the Iterator interface.
  // Override them if needed.
  int next() {
    if (hasPeeked) {
      hasPeeked = false;
      return peekedElement;
    } else {
      return Iterator::next();
    }
  }

  bool hasNext() const {
    return hasPeeked || Iterator::hasNext();
  }
};

int main() {
  return 0;
}
