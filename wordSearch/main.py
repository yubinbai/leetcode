'''
Created on May 16, 2013
@author: Yubin Bai
'''

class Solution:
    # @param board, a list of lists of 1 length string
    # @param word, a string
    # @return a boolean
    def exist(self, board, word):
        # backtrack
        def _search(x, y, step, word):
            if step == len(word):
                result[0] = True
                return
            if result[0] or x < 0 or x >= len(board) or y < 0 or y >= len(board[0]):
                return

            if board[x][y] == word[step]:
                temp = board[x][y]
                board[x][y] = -1
                _search(x - 1, y, step + 1, word)
                _search(x + 1, y, step + 1, word)
                _search(x, y + 1, step + 1, word)
                _search(x, y - 1, step + 1, word)
                board[x][y] = temp

        result = [False]
        for i in range(len(board)):
            for j in range(len(board[0])):
                _search(i, j, 0, word)
                if result[0]:
                    return True
        return False


if __name__ == '__main__':
    board = [
        list("ABCE"),
        list("SFCS"),
        list("ADEE")
    ]
    words = ['SEE', 'ABCB', 'ABCCED']
    sol = Solution()
    for word in words:
        print(sol.exist(board, word))
