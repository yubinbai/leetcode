#include <iostream>
using namespace std;

bool isPalindrome(int x)
{
    if (x < 0) return false;
    int div = 1;
    while (x / div >= 10)
    {
        div *= 10;
    }
    while (x != 0)
    {
        int l = x / div;
        int r = x % 10;
        if (l != r) return false;
        x = (x % div) / 10;
        div /= 100;
    }
    return true;
}

int main()
{
    cout << isPalindrome(101) << endl;
}