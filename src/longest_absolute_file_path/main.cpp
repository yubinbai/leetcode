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
  int lengthLongestPath(string input) {
    stringstream ss(input);
    string line;
    vector<string> stack;
    int ret = 0;
    while (std::getline(ss, line)) {
      cout << line << endl;
      int depth = 1;
      while (line[0] == '\t') {
        depth++;
        line.erase(0, 1);
      }
      int line_len = line.size();
      if (line.size() > 4 && line[line_len - 4] == '.') {
        // is file
        int curr = 0;
        for (int i = 0; i < depth - 1; i++) {
          curr += stack[i].size() + 1;
        }
        curr += line.size();
        ret = max(ret, curr);
      } else {
        // is dir
        if (depth > stack.size()) {
          stack.push_back(line);
        } else {
          stack[depth - 1] = line;
          while (stack.size() > depth) {
            stack.pop_back();
          }
        }
      }
    }
    return ret;
  }
};


int main() {

  Solution sol;
  string input;

  input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
  cout << sol.lengthLongestPath(input) << endl;

  input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
  cout << sol.lengthLongestPath(input) << endl;

  input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2sfo\n\t\tsubsubdir2xyzabc\n\t\t\tfile2.ext";
  cout << sol.lengthLongestPath(input) << endl;

  input = "a";
  cout << sol.lengthLongestPath(input) << endl;

  input = "file1.txt\nfile2.txt\nlongfile.txt";
  cout << sol.lengthLongestPath(input) << endl;

  return 0;
}
