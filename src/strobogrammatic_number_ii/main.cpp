#include <iostream>
#include <map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

class Solution {
public:
  vector<string> zero = {""}, one = {"0", "1", "8"};

  vector<string> findStrobogrammatic(int n) {
    vector<string> prev, curr;
    prev = (n % 2 == 0) ? zero : one;
    for (int i = n % 2; i <= n - 2; i += 2) {
      for (auto num : prev) {
        for (const auto& kvp : digit_map) {
          if (i != n - 2 || kvp.first != "0") {
            curr.push_back(kvp.first + num + kvp.second);
          }
        }
      }
      prev = curr;
      curr.clear();
    }
    return prev;
  }

private:
  const map<string, string> digit_map {{"0", "0"}, {"1", "1"}, {"6", "9"}, {"8", "8"}, {"9", "6"}};
};

int main() {
  Solution sol;
  vector<string> result;

  for (int i = 2; i < 4; i++) {
    result = sol.findStrobogrammatic(i);
    for (auto s : result) {
      cout << s << endl;
    }
  }

  for (int i = 1; i < 20; i++) {
    result = sol.findStrobogrammatic(i);
    cout << "count "  << i << ": " << result.size() << endl;
  }
  return 0;
}
