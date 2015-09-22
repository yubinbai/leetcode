#include <iostream>
#include <map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

class Solution {
private:
  map<char, char> digit_map = {{'6', '9'}, {'9', '6'}, {'8', '8'}, {'1', '1'}};
public:
  bool isStrobogrammatic(string str) {
    int left = 0, right = str.size() - 1;
    while (left <= right) {
      char c1 = str[left], c2 = str[right];
      if (digit_map.count(c1) &&
          digit_map.count(c2) &&
          digit_map[str[left]] == digit_map[str[right]]) {
        left++;
        right--;
      } else {
        return false;
      }
    }
    return true; 
  }
};

int main() {
  Solution sol;
  cout << sol.isStrobogrammatic("818") << endl;
  cout << sol.isStrobogrammatic("414") << endl;
  return 0;
}
