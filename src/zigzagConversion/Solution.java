public class Solution {
    public String convert(String s, int nRows) {
	if (nRows == 1) return s;
	StringBuilder[] sb = new StringBuilder[nRows];
	for (int i = 0; i < nRows; i++) {
	    sb[i] = new StringBuilder();
	}
	int m = nRows * 2 - 2;
	for (int i = 0; i < s.length(); i++) {
	    if (i % m < nRows) {
		sb[i % m].append(s.charAt(i));
	    } else {
		sb[m - i % m].append(s.charAt(i));
	    }
	}
	String result = "";
	for (StringBuilder curr : sb) {
	    result += curr.toString();
	}
	return result;
    }
    public static void main(String[] args) {
	Solution s = new Solution();
	System.out.println(s.convert("PAYPALISHIRING", 3));
	System.out.println(s.convert("AB", 1));
	System.out.println(s.convert("ABC", 2));
    }
}
