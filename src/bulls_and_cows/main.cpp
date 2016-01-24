#include <cstdlib>
#include <iostream>
#include <map>
#include <queue>
#include <sstream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <vector>

const int NUM_DIGITS = 10;

using namespace std;

class Solution {
public:
  string getHint(string secret, string guess) {
    int len = secret.size();
    int a = 0, b = 0;
    int secret_counter[NUM_DIGITS] = {0}, guess_counter[NUM_DIGITS] = {0};
    for (int i = 0; i < len; i++) {
      if (secret[i] == guess[i]) {
        a++;
      } else {
        secret_counter[secret[i] - '0']++;
        guess_counter[guess[i] - '0']++;
      }
    }
    for (int i = 0; i < NUM_DIGITS; i++) {
      b += min(secret_counter[i], guess_counter[i]);
    }
    return to_string(a) + "A" + to_string(b) + "B";
  }
};

int main() {
  Solution sol;
  cout << sol.getHint("1123", "0111") << endl;
  cout << sol.getHint("1", "0") << endl;
  return 0;
}
