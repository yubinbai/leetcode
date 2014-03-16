# Given a 2D board containing 'X' and 'O', capture all regions surrounded
# by 'X'.

# A region is captured by flipping all 'O's into 'X's in that surrounded
# region .

# For example,
# X X X X
# X O O X
# X X O X
# X O X X
# After running your function, the board should be:

# X X X X
# X X X X
# X X X X
# X O X X


def solve(board):
    def dfs(i, j):
        if board[i][j] == 'X':
            return True
        visited[i][j] = True
        d = [(i + 1, j), (i - 1, j), (i, j + 1), (i, j - 1)]
        flag = True
        for row, col in d:
            if row < 0 or row >= n or col < 0 or col >= m:
                return False
            if not visited[row][col]:
                flag &= dfs(row, col)
        if flag:
            surroundCount[0] += 1
            return True
        else:
            return False

    n = len(board)
    m = len(board[0])
    visited = [[False] * m for _ in range(n)]
    surroundCount = [0]
    for i in range(n):
        for j in range(m):
            if not visited[i][j]:
                dfs(i, j)
    return surroundCount[0]

board = ['XXXX', 'XOOX', 'XXOX', 'XOXX']
print solve(board)
