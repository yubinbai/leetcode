'''
Created on May 16, 2013

@author: Yubin Bai
'''


def wordSearch(matrix, w):
    '''
    search for words in matrix
    '''
    def _search(x, y, step, w):
        '''
        backtrack
        '''
        if step == len(w):
            result[0] = True
            return
        if result[0] or x < 0 or x >= len(matrix) or y < 0 or y >= len(matrix[0]):
            return

        if matrix[x][y] == w[step]:
            temp = matrix[x][y]
            matrix[x][y] = -1
            _search(x - 1, y, step + 1, w)
            _search(x + 1, y, step + 1, w)
            _search(x, y + 1, step + 1, w)
            _search(x, y - 1, step + 1, w)
            matrix[x][y] = temp

    result = [False]
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            _search(i, j, 0, w)
            if result[0]:
                return True
    return False


if __name__ == '__main__':
    matrix = [
        list("ABCE"),
        list("SFCS"),
        list("ADEE")
    ]
    words = ['SEE', 'ABCB', 'ABCCED']

    for w in words:
        print(wordSearch(matrix, w))
