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

class RandomizedSet {
private:
  unordered_map<int, int> s;
  vector<int> v;
public:
  /** Initialize your data structure here. */
  RandomizedSet() {

  }

  /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
  bool insert(int val) {
    if (s.count(val)) {
      return false;
    }
    v.push_back(val);
    s.insert({val, v.size() - 1});
    return true;
  }

  /** Removes a value from the set. Returns true if the set contained the specified element. */
  bool remove(int val) {
    if (!s.count(val)) {
      return false;
    }
    int pos = s[val];
    int last_val = v.back();
    v[pos] = last_val;
    v.pop_back();
    s[last_val] = pos;
    s.erase(val);
    return true;
  }

  /** Get a random element from the set. */
  int getRandom() {
    std::srand(std::time(nullptr)); // use current time as seed for random generator
    int pos = (int)(std::rand() * RAND_MAX) % v.size();
    return v[pos];
  }
};


int main() {
  RandomizedSet randomizedSet;
  cout << randomizedSet.insert(1) << endl; // Inserts 1 to the set. Returns true as 1 was inserted successfully.
  cout << randomizedSet.remove(2) << endl; // Returns false as 2 does not exist in the set.
  cout << randomizedSet.insert(2) << endl; // Inserts 2 to the set, returns true. Set now contains [1,2].
  cout << randomizedSet.getRandom() << endl; // getRandom() should return either 1 or 2 randomly.
  cout << randomizedSet.remove(1) << endl; // Removes 1 from the set, returns true. Set now contains [2].
  cout << randomizedSet.insert(2) << endl; // 2 was already in the set, so return false.
  cout << randomizedSet.getRandom() << endl; // Since 2 is the only number in the set, getRandom() will always return 2.

  return 0;
}
