Problem
===
Given a 2D board containing 'X' and 'O', capture all regions surrounded
by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded
region .

    For example,
    X X X X
    X O O X
    X X O X
    X O X X
    After running your function, the board should be:

    X X X X
    X X X X
    X X X X
    X O X X

Solution
===
BFS from borders of the matrix, kind of a hackish solution

Notice some optimizations about the bfs, the frontier contains more nodes than the rest of it combined!