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
private:
  const vector<string> words = {
    "Zero",
    "One",
    "Two",
    "Three",
    "Four",
    "Five",
    "Six",
    "Seven",
    "Eight",
    "Nine",
    "Ten",
    "Eleven",
    "Twelve",
    "Thirteen",
    "Fourteen",
    "Fifteen",
    "Sixteen",
    "Seventeen",
    "Eighteen",
    "Nineteen",
  };
  const vector<string> tens = {
    "",
    "",
    "Twenty",
    "Thirty",
    "Forty",
    "Fifty",
    "Sixty",
    "Seventy",
    "Eighty",
    "Ninety",
  };
  const int BILLION = 1000000000; 
  const int MILLION = 1000000; 
  const int THOUSAND = 1000; 

  string getThreeDigitWord(int n) {
    string result = "";
    if (n >= 100) {
      result += words[n / 100];
      result += " Hundred";
      n %= 100;
    }
    if (n >= 20) {
      if (result.size() > 0) {
        result += " ";
      }
      result += tens[n / 10];
      if (n % 10 > 0) {
        result += " ";
        result += words[n % 10];
      }
    } else if (n > 0) {
      if (result.size() > 0) {
        result += " ";
      }
      result += words[n];
    }
    return result;
  }

public:
  string numberToWords(int num) {
    string result = "";
    if (num == 0) {
      return words[0];
    }
    if (num >= BILLION) {
      result += getThreeDigitWord(num / BILLION);
      result += " Billion";
      num %= BILLION;
    }
    if (num >= MILLION) {
      if (result.size() > 0) {
        result += " ";
      }
      result += getThreeDigitWord(num / MILLION);
      result += " Million";
      num %= MILLION;
    }
    if (num >= THOUSAND) {
      if (result.size() > 0) {
        result += " ";
      }
      result += getThreeDigitWord(num / THOUSAND);
      result += " Thousand";
      num %= THOUSAND;
    }
    if (num > 0) {
      if (result.size() > 0) {
        result += " ";
      }
      result += getThreeDigitWord(num);
    }
    return result; 
  }
};

int main() {
  Solution sol;
  cout << sol.numberToWords(0) << endl;
  cout << sol.numberToWords(20) << endl;
  cout << sol.numberToWords(100) << endl;
  cout << sol.numberToWords(123) << endl;
  cout << sol.numberToWords(12345) << endl;
  cout << sol.numberToWords(1234567) << endl;
  return 0;
}
