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
  vector<string> split(const string &s, char delim) {
    vector<string> elems;
    stringstream ss(s);
    string item;
    while (getline(ss, item, delim)) {
      elems.push_back(item);
    }
    return elems;
  }
public:
  bool wordPattern(string pattern, string str) {
    vector<string> words = split(str, ' ');
    if (words.size() != pattern.size()) {
      return false;
    }
    map<char, string> char_word;
    map<string, int> word_char; 
    for (int i = 0; i < pattern.size(); i++) {
      char c = pattern[i];
      string w = words[i]; 
      if (char_word.count(c) > 0 && char_word[c] != w) {
        return false;
      } else if (word_char.count(w) > 0 && word_char[w] != c) {
        return false;
      } else {
        word_char[w] = c;
        char_word[c] = w;
      }
    }
    return true;
  }
};

int main() {
  string pattern = "syys";
  string str = "a abc abc a";
  Solution sol;
  cout << sol.wordPattern(pattern, str) << endl;
  return 0;
}
