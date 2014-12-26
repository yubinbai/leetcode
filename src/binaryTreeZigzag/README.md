Problem
===
Given a binary tree, print out the tree in zig zag level order (ie, from left to right, then right to left for the next level and alternate between). Output a newline after the end of each level.

         3
       /  \
      9   20    
         /  \
        15    7
For example, the zig zag level order output of the tree above is:

    3 
    20 9
    15 7

Solution
===
Use two collections to alternate on each level

Reverse odd levels