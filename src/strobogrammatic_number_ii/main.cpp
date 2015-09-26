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
  for (auto s : sol.findStrobogrammatic(2)) {
    cout << s << endl;
  }
  for (auto s : sol.findStrobogrammatic(3)) {
    cout << s << endl;
  }
  for (auto s : sol.findStrobogrammatic(4)) {
    cout << s << endl;
  }
  return 0;
}
