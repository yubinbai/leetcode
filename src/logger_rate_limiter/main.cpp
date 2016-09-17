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

class Logger {
public:
  Logger() {}
    
  bool shouldPrintMessage(int timestamp, string message) {
    if (m[message] > timestamp) {
      return false;
    }
    m[message] = timestamp + 10;
    return true;
  }

private:
  unordered_map<string, int> m;
};

int main() {
  Logger logger;

  // logging string "foo" at timestamp 1
  cout << logger.shouldPrintMessage(1, "foo") << endl;

  // logging string "bar" at timestamp 2
  cout << logger.shouldPrintMessage(2,"bar") << endl;

  // logging string "foo" at timestamp 3
  cout << logger.shouldPrintMessage(3,"foo") << endl;

  // logging string "bar" at timestamp 8
  cout << logger.shouldPrintMessage(8,"bar") << endl;

  // logging string "foo" at timestamp 10
  cout << logger.shouldPrintMessage(10,"foo") << endl;

  // logging string "foo" at timestamp 11
  cout << logger.shouldPrintMessage(11,"foo") << endl;

  return 0;
}
