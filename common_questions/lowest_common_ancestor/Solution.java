class Solution {
    class Node {
        int val;
        Node left, right;
        public Node(int v) {
            val = v;
        }
    }
    public Node findLowestCommonAncestor(Node root, Node a, Node b) {
        if (root == null) return null;
        if (root == a) return a;
        if (root == b) return b;

        Node e1 = findLowestCommonAncestor(root.left, a, b); 
        Node e2 = findLowestCommonAncestor(root.right, a, b); 

        if ( (e1 == a && e2 == b) 
            || (e1 == b && e2 == a) ) {
            return root;
        } else {
            if (e1 != null) return e1;
            return e2;
        }
    } 
}