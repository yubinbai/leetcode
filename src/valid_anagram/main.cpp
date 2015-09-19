#include <iostream>
#include <map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

class Solution {
public:
  bool isAnagram(string s, string t) {
    vector<char> sv(s.begin(), s.end());
    vector<char> tv(t.begin(), t.end());
    sort(sv.begin(), sv.end());
    sort(tv.begin(), tv.end());
    return sv == tv;
  }
};

int main() {
  Solution sol;
  cout << sol.isAnagram("anagram", "nagaram") << endl;
  cout << sol.isAnagram("car", "nar") << endl;
  return 0;
}
