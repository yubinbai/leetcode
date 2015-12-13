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
class ZigzagIterator {
  int current_it;
  int it1;
  int it2;
  vector<int> vec1;
  vector<int> vec2;
public:
  ZigzagIterator(vector<int>& v1, vector<int>& v2) {
    current_it = 1;
    it1 = 0;
    it2 = 0;
    vec1 = v1;
    vec2 = v2;
  }
 
  int next() {
    if (current_it == 1) {
      current_it = 2;
      if (it1 < vec1.size()) {
        it1++;
        return vec1[it1 - 1];
      } 
    }
    // else
    current_it = 1;
    it2++;
    return vec2[it2 - 1];
  }
 
  bool hasNext() {
    return it1 < vec1.size() || it2 < vec2.size();
  }
};
 
int main() {
  vector<int> v1 = {1, 2};
  vector<int> v2 = {3, 4, 5, 6};
  ZigzagIterator i(v1, v2);
  while (i.hasNext()) {
    cout << i.next();
  } 
  return 0;
}
