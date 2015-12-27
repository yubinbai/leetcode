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

class ValidWordAbbr {
  unordered_map<string, string> abbs;
  string getAbb(string s){
    int n = s.size();
    if (n <= 2) {
      return s;
    } else {
      return s.substr(0, 1) + to_string(n - 2) + s.substr(n - 1,1);
    }
  }
public:
  ValidWordAbbr(vector<string> &dictionary) {
    for (auto w : dictionary) {
      string a = getAbb(w);
      if (abbs.find(a) != abbs.end()) {
        abbs[a] = "";
      } else {
        abbs[a] = w;
      }
    }
  }
  bool isUnique(string word) {
    string a = getAbb(word);
    return abbs.count(a) == 0 ||
      (abbs.count(a) == 1 && abbs[a] == word);
  }
};

int main() {
  vector<string> dict = {"deer", "door", "cake", "card"}; 
  ValidWordAbbr sol(dict); 
  cout << sol.isUnique("deer") << endl;
  cout << sol.isUnique("cake") << endl;
  return 0;
}
