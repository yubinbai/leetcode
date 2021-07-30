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

class Solution {
public:
  string decodeString(string s) {
    vector<int> repeat;
    vector<stringstream> ss;
    repeat.push_back(1);
    stringstream start;
    ss.push_back(move(start));

    for (int i = 0; i < s.size(); i++) {
      if (s[i] >= '0' && s[i] <= '9') {
        int num_start = i;
        while (s[i] >= '0' && s[i] <= '9') {
          i++;
        }
        string num = s.substr(num_start, i - num_start);
        repeat.push_back(stoi(num));
        stringstream next;
        ss.push_back(move(next));
        // trust s[i] is '[', go to next
      } else if (s[i] >= 'a' && s[i] <= 'z') {
        ss.back() << s[i];
      } else if (s[i] == ']') {
        string curr = ss.back().str();
        ss.pop_back();
        int repeats = repeat.back();
        repeat.pop_back();
        for (int r = 0; r < repeats; r++) {
          ss.back() << curr;
        }
      }
    }

    if (ss.empty()) {
      throw;
    } else {
      return ss[0].str();
    }
  }
};

int main() {

  Solution sol;
  string s;

  s = "3[a]2[bc]";
  cout << sol.decodeString(s) << endl;

  s = "3[a2[c]]";
  cout << sol.decodeString(s) << endl;

  s = "2[abc]3[cd]ef";
  cout << sol.decodeString(s) << endl;

  s = "abc3[cd]xyz";
  cout << sol.decodeString(s) << endl;

  return 0;
}
