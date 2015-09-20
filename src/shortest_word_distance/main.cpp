#include <iostream>
#include <map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

class Solution {
public:
  int shortestDistance(vector<string>& words, string word1, string word2) {
    int n = words.size(), idx1 = -1, idx2 = -1, dist = INT_MAX;
    for (int i = 0; i < n; i++) {
      if (words[i] == word1) {
        idx1 = i;
      } else if (words[i] == word2) {
        idx2 = i;
      }
      if (idx1 != -1 && idx2 != -1) {
        dist = min(dist, abs(idx1 - idx2));
      }
    }
    return dist;
  }
};

int main() {
  Solution sol;
  vector<string> words = {"practice", "makes", "perfect", "coding", "makes"};
  cout << sol.shortestDistance(words, "makes", "coding") << endl;
  cout << sol.shortestDistance(words, "practice", "coding") << endl;
  return 0;
}
