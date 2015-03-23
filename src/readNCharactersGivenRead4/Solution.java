class Reader4 {
    int counter = 0;
    public int read4(char[] buffer) {
        int curr = 0;
        for (int i = 0; i < 4; ++i) {
            if (counter < 10) buffer[i] = 'a';
            else if (counter < 20) buffer[i] = 'b';
            else break;
            curr++;
            counter++;
        }
        return curr;
    }
}
public class Solution extends Reader4 {
    char[] buffer = new char[4];
    int bufferStart = 0, bufferLen = 0;
    boolean eof = false;
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int completed = 0;
        while (completed < n) {
            if (bufferLen <= 0) {
                if (!eof) {
                    bufferLen = read4(buffer);
                    if (bufferLen < 4) eof = true;
                    bufferStart = 0;
                } else {
                    break;
                }
            }
            int bytes = Math.min(n - completed, bufferLen);
            System.arraycopy(buffer, bufferStart, buf, completed, bytes);
            bufferStart += bytes;
            bufferLen -= bytes;
            completed += bytes;
        }
        return completed;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int total = 30;
        int each = 4;
        for (int i = 0; i < 10; ++i) {
            char[] buf = new char[each];
            System.out.println(s.read(buf, each));
            System.out.println(new String(buf));
        }
    }
}