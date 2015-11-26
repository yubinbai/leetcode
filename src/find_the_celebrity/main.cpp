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

// Forward declaration of the knows API.
bool knows(int a, int b);

class Solution {
public:
  int findCelebrity(int n) {
    int candidate = 0;
    for (int i = 1; i < n; i++) {
      if (knows(candidate, i)) {
        candidate = i;
      }
    }
    for (int i = 0; i < n; i++) {
      if (i == candidate) {
        continue;
      }
      if (!knows(i, candidate) || knows(candidate, i)) {
        return -1;
      }
    }
    return candidate;
  }
};

int main() {
  return 0;
}
