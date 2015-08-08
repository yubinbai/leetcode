#include <iostream>
#include <map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

class Solution {
private:
  map<string, vector<int>> memo;
public:
  int compute(int a, int b, char op) {
    switch (op) {
    case '+': return a + b;
    case '-': return a - b;
    case '*': return a * b;
    }
    return 1;
  }
  vector<int> diffWaysToCompute(string input) {
    if (memo.count(input)) {
      return memo[input];
    }

    int val = 0, idx = 0;
    while (idx < input.length() && isdigit(input[idx])) {
      val *= 10;
      val += input[idx++] - '0';
    }
    if (idx == input.length()) return {val};
    vector<int> res;
    vector<int> left, right;
    for (int i = 0; i < input.length(); ++i) {
      if (!isdigit(input[i])) {
        left = diffWaysToCompute(input.substr(0, i));
        right = diffWaysToCompute(input.substr(i + 1, input.length() -1 - i));
        for (int j = 0; j < left.size(); ++j) {
          for (int k = 0; k < right.size(); ++k) {
            res.push_back(compute(left[j], right[k], input[i]));
          }
        }
      }
    }
    return memo[input] = res;
  }
};

int main() {
  Solution sol;
  for (int i : sol.diffWaysToCompute("2-1-1")) {
    cout << i << endl;
  }
  for (int i : sol.diffWaysToCompute("2*3-4*5")) {
    cout << i << endl;
  }
  return 0;
}
