Problem
===
Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.

    Example:
    Given binary tree 
              1
             / \
            2   3
           / \ 
          4   5
    Returns [4, 5, 3], [2], [1].
                                        
Explanation:

    1. Remove the leaves [4, 5, 3] from the tree
                                        
      1
     / 
    2

    2. Remove the leaf [2] from the tree

    1

    3. Remove the leaf [1] from the tree
                                                                             
    []

    Returns [4, 5, 3], [2], [1].
