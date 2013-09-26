'''
Created on 2013-5-11

@author: Yubin Bai
'''
MAX_INT = 100  # (1 << 33) - 1


def distance(s1, s2):
    size = len(s1)
    counter = 0
    for i in range(size):
        if s1[i] != s2[i]:
            counter += 1
    return counter


def wordLadder(start, end, dictionary):
    dictionary.append(start)
    dictSize = len(dictionary)
    dist = [[MAX_INT for x in range(dictSize)] for y in range(dictSize)]
    for i in range(dictSize):
        for j in range(dictSize):
            if i != j:
                d = distance(dictionary[i], dictionary[j])
                if d == 1:
                    dist[i][j] = dist[j][i] = 1
    distToEnd = [MAX_INT for x in range(dictSize)]
    for i in range(dictSize):
        d = distance(dictionary[i], end)
        if d == 1:
            distToEnd[i] = 1

    # BFS
    startIndex = dictSize - 1
    visited = {}  # also holds the shortest path length
    visited[startIndex] = 0
    prev = {}
    import collections
    frontier = collections.deque([startIndex])  # the start is in dict tail
    while len(frontier) > 0:
        v = frontier.popleft()
        for i in range(dictSize):
            if i not in visited and dist[i][v] == 1:
                frontier.append(i)
                visited[i] = visited[v] + 1
                prev[i] = v

    # match the distance to the end, find the closest nodes
    minNodes = []
    currMin = MAX_INT
    for i in visited:
        if distToEnd[i] + visited[i] < currMin:
            minNodes = [i]
            currMin = distToEnd[i] + visited[i]
        elif distToEnd[i] + visited[i] == currMin:
            minNodes.append(i)

    results = []
    for i in minNodes:
        resultRow = [end]
        while i != startIndex:
            resultRow.append(dictionary[i])
            i = prev[i]
        resultRow.append(dictionary[startIndex])
        resultRow.reverse()
        results.append('->'.join(resultRow))
    return str(results)


if __name__ == '__main__':
    start = "hit"
    end = "cog"
    dictionary = ["hot", "dot", "dog", "lot", "log"]
    print(wordLadder(start, end, dictionary))
