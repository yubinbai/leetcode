public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // lookup table
        int[][] distances = new int[len2 + 1][len1 + 1];

        for (int i = 0; i < len2 + 1; ++i)
            distances[i][0] = i;
        for (int j = 0; j < len1 + 1; ++j)
            distances[0][j] = j;

        for (int i = 1; i < len2 + 1; ++i) {
            for (int j = 1; j < len1 + 1; ++j) {
                if (word1.charAt(j - 1) == word2.charAt(i - 1))
                    distances[i][j] = distances[i - 1][j - 1];
                else {
                    int deletion = distances[i][j - 1] + 1;
                    int insertion = distances[i - 1][j] + 1;
                    int substitution = distances[i - 1][j - 1] + 1;
                    distances[i][j] = Math.min(Math.min(deletion, insertion), substitution);
                }
            }
        }
        return distances[len2][len1];
    }
}
