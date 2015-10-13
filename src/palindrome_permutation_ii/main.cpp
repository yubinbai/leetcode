#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <string>
#include <vector>

using namespace std;

class Solution {
public:
  vector<string> generatePalindromes(string s) {
    vector<string> palindromes;
    map<char, int> counts;
    for (char c : s) {
      counts[c]++;
    }
    int odd = 0;
    char mid;
    string half;
    for (auto p : counts) {
      if (p.second & 1) {
        odd++, mid = p.first;
        if (odd > 1) return palindromes;
      }
      half += string(p.second / 2, p.first);
    }
    palindromes = permutations(half);
    for (string& p : palindromes) {
      string t(p);
      reverse(t.begin(), t.end());
      if (odd) {
        p += mid;
      }
      p += t;
    }
    return palindromes;
  }
private: 
  vector<string> permutations(string& s) {
    vector<string> perms;
    string t(s);
    do {
      perms.push_back(s);
      next_permutation(s.begin(), s.end());
    } while (s != t);
    return perms;
  }
};

int main() {
  Solution sol;
  for (auto s : sol.generatePalindromes("code")) {
    cout << s << endl;
  }
  for (auto s : sol.generatePalindromes("aab")) {
    cout << s << endl;
  }
  for (auto s : sol.generatePalindromes("caracar")) {
    cout << s << endl;
  }
  return 0;
}
