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

class RandomizedCollection {
private:
  unordered_map<int, unordered_set<int>> s;
  vector<int> v;
public:
  /** Initialize your data structure here. */
  RandomizedCollection() {
  }
    
  /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
  bool insert(int val) {
    if (s.count(val)) {
      v.push_back(val);
      s[val].insert(v.size() - 1);
      return false;
    }
    v.push_back(val);
    unordered_set<int> pos = {(int)v.size() - 1};
    s[val] = pos;
    return true;
  }
    
  /** Removes a value from the collection. Returns true if the collection contained the specified element. */
  bool remove(int val) {
    if (!s.count(val)) {
      return false;
    }
    int last_val = v.back();
    int last_val_pos = v.size() - 1;
    if (val == last_val) {
      s[val].erase(last_val_pos);
    } else {
      int val_pos = *s[val].begin();
      s[val].erase(val_pos);
      s[last_val].erase(last_val_pos);
      s[last_val].insert(val_pos);
      v[val_pos] = last_val;
    }
    if (s[val].empty()) {
      s.erase(val);
    }
    v.pop_back();
    return true;
  }
    
  /** Get a random element from the collection. */
  int getRandom() {
    std::srand(std::time(nullptr)); // use current time as seed for random generator
    int pos = (int)(std::rand() * RAND_MAX) % v.size();
    return v[pos];
  }
};


int main() {
  RandomizedCollection randomizedCollection;
  randomizedCollection.insert(1);   // return True. Inserts 1 to the collection. Returns true as the collection did not contain 1.
  randomizedCollection.insert(1);   // return False. Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
  randomizedCollection.insert(2);   // return True. Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
  randomizedCollection.getRandom(); // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
  randomizedCollection.remove(1);   // return True. Removes 1 from the collection, returns true. Collection now contains [1,2].
  cout << randomizedCollection.getRandom() << endl; // getRandom should return 1 and 2 both equally likely.
  for (int i = 0; i < 1000; i++) {
    randomizedCollection.insert(2);   // return True. Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
    randomizedCollection.remove(2);   // return True. Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
  }
  cout << randomizedCollection.getRandom() << endl; // getRandom should return 1 and 2 both equally likely.

  return 0;
}
