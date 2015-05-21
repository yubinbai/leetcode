public class WordDictionary {
    Trie t;
    public WordDictionary() {
        t = new Trie();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        t.insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchAt(word, t.root);
    }
    private boolean searchAt(String word, TrieNode curr) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                boolean result = false;
                for (TrieNode next : curr.adj) {
                    if (next != null) {
                        result |= searchAt(word.substring(i + 1), next);
                    }
                }
                return result;
            } else {
                int ord = c - 'a';
                if (curr.adj[ord] == null) {
                    return false;
                }
                curr = curr.adj[ord];
            }
        }
        return curr.adj[26] != null;
    }
    public static void main(String[] args) {
        WordDictionary wordDictionary;

        wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        System.out.println(wordDictionary.search("."));

        wordDictionary = new WordDictionary();
        wordDictionary.addWord("ab");
        System.out.println(wordDictionary.search("a."));
    }
}
class TrieNode {
    TrieNode[] adj;
    // Initialize your data structure here.
    public TrieNode() {
        adj = new TrieNode[27];
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
        curr.adj[26] = new TrieNode();
    }
}


