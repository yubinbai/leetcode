#include <iostream>
#include <map>
#include <unordered_map>
#include <vector>
#include <string> 
#include <cstdlib> 

using namespace std;

class WordDistance {

private:
  unordered_map<string, vector<int> > str_idx;

  int shortestDifferent(string word1, string word2) {
    vector<int> idx1 = str_idx[word1];
    vector<int> idx2 = str_idx[word2];
    int m = idx1.size(), n = idx2.size();
    int i = 0, j = 0, dist = INT_MAX;
    while (i < m && j < n) {
      dist = min(dist, abs(idx1[i] - idx2[j]));
      if (idx1[i] < idx2[j]) {
        i++;
      } else {
        j++;
      }
    }
    return dist;
  }

  int shortestSame(string word) {
    vector<int> idx = str_idx[word];
    int i = 0, dist = INT_MAX;
    for (i = 0; i < idx.size() - 1; i++) {
      dist = min(dist, idx[i + 1] - idx[i]);
    }
    return dist;
  }

public:
  WordDistance(vector<string> words) {
    int n = words.size();
    for (int i = 0; i < n; i++) {
      str_idx[words[i]].push_back(i);
    }
  }

  int shortest(string word1, string word2) {
    if (word1 == word2) {
      return shortestSame(word1);
    } else {
      return shortestDifferent(word1, word2);
    }
  }

};

int main() {
  vector<string> words = {"practice", "makes", "perfect", "coding", "makes"};
  WordDistance wordDistance(words);
  cout << wordDistance.shortest("makes", "coding") << endl;
  cout << wordDistance.shortest("practice", "coding") << endl;
  cout << wordDistance.shortest("makes", "makes") << endl;
  return 0;
}
