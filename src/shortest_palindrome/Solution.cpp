class Solution {
public:
    string shortestPalindrome(string s) {
        int len = s.size();
        if(len <= 1) return s;

        int n = 2 * len + 3;
        string t(n, '#');
        t[0] = '^';
        t[n-1] = '$';
        for(int i = 0; i < len; ++i) t[2 * i + 2] = s[i];
        t += "#$";
        int* p = new int[n];
        for(int i = 0; i < n; ++i) p[i] = 0;

        int c = 0, r = 0;
        for(int i = 1; i < n - 1; ++i){
            int i_mirror = c - i + c;
            p[i] = r > i ? min(r - i, p[i_mirror]) : 0;
            while(t[i - p[i]] == t[i + p[i]]) ++p[i];
            if(i + p[i] > r){
                c = i;
                r = i + p[i];
            }
        }

        int reverseLen = 1;
        for(int i = 0; i < n; ++i) if(p[i] == i) reverseLen = i;

        delete[] p;
        string ret;
        --reverseLen;
        ret += s.substr(reverseLen, len - reverseLen);
        reverse(ret.begin(), ret.end());
        ret += s;

        return ret;
    }
};