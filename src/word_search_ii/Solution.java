import java.util.*;

class TrieNode {
    TrieNode[] adj;
    String word;
    // Initialize your data structure here.
    public TrieNode() {
        adj = new TrieNode[26];
        word = null;
    }
}

class Trie {
    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int ord = c - 'a';
            if (curr.adj[ord] == null) {
                curr.adj[ord] = new TrieNode();
            }
            curr = curr.adj[ord];
        }
        curr.word = word;
    }
}

public class Solution {
    Trie trie;
    HashSet<String> result;
    int n, m;
    char[][] board;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, { -1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        for (String w : words) {
            trie.insert(w);
        }
        result = new HashSet<String>();

        this.board = board;
        n = board.length;
        m = board[0].length;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                search(i, j, trie.root);
            }
        }
        return new ArrayList<String>(result);
 
    }
    private void search(int i, int j, TrieNode curr) {
        int ord = board[i][j] - 'a';
        if (ord >= 0 && ord < 26 && curr.adj[ord] != null) {
            if (curr.adj[ord].word != null) {
                result.add(curr.adj[ord].word);
            }
            board[i][j] = ' ';
            for (int[] d : directions) {
                int ii = i + d[0];
                int jj = j + d[1];
                if (ii >= 0 && ii < n && jj >= 0 && jj < m) {
                    search(ii, jj, curr.adj[ord]);
                }
            }
            board[i][j] = (char) ('a' + ord);
        }
    }

    public static void main(String[] args) {
        Solution s;
        char[][] board;
        String[] words;

        s = new Solution();
        board = new char[][] {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'} };
        words = new String[] {"oath","pea","eat","rain"};
        System.out.println(s.findWords(board, words));

        s = new Solution();
        board = new char[][] {{'a'}};
        words = new String[] {"a"};
        System.out.println(s.findWords(board, words));
    }
}

