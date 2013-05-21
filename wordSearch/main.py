'''
Created on May 16, 2013

@author: Administrator
'''
def wordSearch(matrix, w):
    result = [False]
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            _wordSearch(matrix, i, j, 0, w, result)
            if result[0]:
                return True
    return False

def _wordSearch(matrix, x, y, step, w, result):
    if step == len(w):
        result[0] = True
        return
    if result[0] or x < 0 or x >= len(matrix) or y < 0 or y >= len(matrix[0]):
        return

    if matrix[x][y] == w[step]:
        temp = matrix[x][y]
        matrix[x][y] = -1
        _wordSearch(matrix, x - 1, y, step + 1, w, result)
        _wordSearch(matrix, x + 1, y, step + 1, w, result)
        _wordSearch(matrix, x, y + 1, step + 1, w, result)
        _wordSearch(matrix, x, y - 1, step + 1, w, result)
        matrix[x][y] = temp
    
    
if __name__ == '__main__':
    matrix = [
              list("ABCE"),
              list("SFCS"),
              list("ADEE")
            ]
    words = [ 'SEE', 'ABCB', 'ABCCED' ]
    
    for w in words:
        print(wordSearch(matrix, w))
    
