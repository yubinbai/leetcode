class TrieNode {
    TrieNode[] adj;
    // Initialize your data structure here.
    public TrieNode() {
        adj = new TrieNode[27];
    }
}

public class Trie {
    private TrieNode root;

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

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int ord = c - 'a';
            if (curr.adj[ord] == null) {
                return false;
            }
            curr = curr.adj[ord];
        }
        return curr.adj[26] != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            int ord = c - 'a';
            if (curr.adj[ord] == null) {
                return false;
            }
            curr = curr.adj[ord];
        }
        return curr != null;
    }
    public static void main(String[] args) {
        Trie trie;
        trie = new Trie();
        trie.insert("somestring");
        System.out.println(trie.search("key"));
        System.out.println(trie.search("somestring"));
        System.out.println(trie.startsWith("some"));
        System.out.println(trie.startsWith("soma"));

        trie = new Trie();
        trie.insert("ab");
        System.out.println(trie.search("a"));
        System.out.println(trie.startsWith("a"));
    }
}

