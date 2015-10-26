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

class Codec {
public:

  // Encodes a list of strings to a single string.
  string encode(vector<string>& strs) {
    string ret;
    for (string str : strs) {
      ret += to_string(str.length()) + '^' + str;
    }
    return ret;
  }

  // Decodes a single string to a list of strings.
  vector<string> decode(string s) {
    vector<string> strs;
    size_t n = s.length(), p = 0 ;
    while (p < n) {
      size_t pos = s.find('^', p);
      if (pos == string::npos) {
        break;
      }
      size_t sz = stoi(s.substr(p, pos - p));
      strs.push_back(s.substr(pos + 1, sz));
      p = pos + sz + 1;
    }
    return strs;
  }
};


int main() {
  Codec codec;
  vector<string> strs = {"hello", "", "a new", "world"};
  cout << codec.encode(strs) << endl;
  for (string s : codec.decode(codec.encode(strs))) {
    cout << s << endl;
  }
  return 0;
}
