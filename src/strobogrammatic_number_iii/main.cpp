#include <iostream>
#include <map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

class Solution {
private:
  map<char, char> digit_map {
    {'0', '0'},
    {'1', '1'},
    {'6', '9'},
    {'8', '8'},
    {'9', '6'},
  };
  long count_in_len_allow_zero[100] = {-1L};

public:
  long strobogrammaticInRange(string low, string high) {
    long count = countSmaller(high) - countSmaller(low);
    if (isStrobogrammatic(high)) {
      count++;
    }
    return count;
  }

  long countSmaller(string num) {
    long result = 0;
    for (int i = 1; i < num.size(); i++) {
      result += countInLength(i);
    }
    result += countSmallerSameLength(num);
    return result;
  }

  long countSmallerSameLength(string num) {
    long result = 0;
    int left = 0, right = num.size() - 1;
    while (left < right) {
      for (const auto& kvp : digit_map) {
        if (num[left] > kvp.first) {
          if (left == 0 && kvp.first == '0') {
            continue;
          }
          result += countInLengthAllowZero(right - left - 1);
        }
      }
      left++;
      right--;
    }
    if (left == right) {
      for (const auto& kvp : digit_map) {
        if (num[left] > kvp.first && kvp.first == kvp.second) {
          if (left == 0 && kvp.first == '0' && num.size() > 1) {
            continue;
          }
          result++;
        }
      }
    }
    return result;
  }

  long countInLengthAllowZero(int len) {
    if (count_in_len_allow_zero[len] != -1L) {
      return count_in_len_allow_zero[len];
    }

    if (len == 0) {
      return count_in_len_allow_zero[len] = 0;
    } else if (len == 1) {
      return count_in_len_allow_zero[len] = 3;
    }
    long result = 1;
    if (len % 2 == 0) {
      for (int i = 0; i < len; i += 2) {
        result *= 5;
      }
    } else {
      for (int i = 1; i < len; i += 2) {
        result *= 5;
      }
      result *= 3;
    }
    return count_in_len_allow_zero[len] = result;
  }

  long countInLength(int len) {
    switch (len) {
    case 0:
      return 0;
    case 1:
      return 3;
    case 2:
      return 4;
    default:
      return 4 * countInLengthAllowZero(len - 2);
    }
  }

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
  vector<string> result;

  cout << sol.strobogrammaticInRange("0", "8") << endl;
  cout << sol.strobogrammaticInRange("0", "181") << endl;
  cout << sol.strobogrammaticInRange("50", "100") << endl;
  cout << sol.strobogrammaticInRange("0", "49") << endl;
  cout << sol.strobogrammaticInRange("0", "100") << endl;
  cout << sol.strobogrammaticInRange("11", "100") << endl;
  cout << sol.strobogrammaticInRange("11", "101") << endl;
  cout << sol.strobogrammaticInRange("0", "111111111111111110") << endl;
  cout << sol.strobogrammaticInRange("111111111111111111", "222222222222222222") << endl;
  cout << sol.strobogrammaticInRange("0", "222222222222222222") << endl;
  cout << sol.strobogrammaticInRange("0", "2222222222222222222222222222222") << endl;

  return 0;
}
