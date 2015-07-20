#include <iostream>
#include <vector>

using namespace std;

class Solution {
  public:
    int countDigitOne(int n) {
      long long res(0);
      int high(n), low_count(1), low_number(0);
      while(high > 0){
        int digit = high % 10;
        high = high / 10;
        if(1 == digit){
          //higher: 0~(high-1);  lower:  0 ~ (low_count-1)
          res += high * low_count;
          //higher: high ~ high;     lower:0~low_number
          res += low_number + 1;
        }else if(0 == digit){
          //higher: 0~(high-1);  lower:  0 ~ (low_count-1)
          res += high * low_count;
        }else{
          //digit > 1
          res += (high + 1) * low_count;
        }
        //update low_number and low_count
        low_number = digit * low_count + low_number;
        low_count = low_count * 10;
      }
      return res;
    }
};
int main() {
  Solution s;
  vector<int> list {1, 2, 11, 13, 19, 21, 91, 99, 100};
  for (auto &c : list) {
    int d = s.countDigitOne(c);
    cout << c << "\t" << d << endl << endl;
  }
}
