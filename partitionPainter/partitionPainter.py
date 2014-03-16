# You have to paint N boards of length {A0, A1, A2 … AN-1}. There are K
# painters available and you are also given how much time a painter takes
# to paint 1 unit of board. You have to get this job done as soon as
# possible under the constraints that any painter will only paint
# continuous sections of board, say board {2, 3, 4} or only board {1} or
# nothing but not board {2, 4, 5}.

'''
Created on Jun 19, 2013
@author: Yubin Bai
'''
import unittest


class PartitionPainter(object):

    def shortestTime(self, data, segments):
        low = data[0]
        high = sum(data)

        def check(number):
            counter = 0
            currSum = 0
            for d in data:
                if currSum + d > number:
                    counter += 1
                    currSum = d
                else:
                    currSum += d
            return counter + 1 <= segments

        while low < high:
            mid = (low + high) >> 1
            if check(mid):
                high = mid
            else:
                low = mid + 1
        return high


class Test(unittest.TestCase):

    def testPainter(self):
        data = [100, 200, 300, 400, 500, 600, 700, 800, 900]
        p = PartitionPainter()
        self.assertEquals(1700, p.shortestTime(data, 3))

if __name__ == "__main__":
    # import sys;sys.argv = ['', 'Test.testPainter']
    unittest.main()
