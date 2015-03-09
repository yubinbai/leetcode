class Solution:
    # @param gas, a list of integers
    # @param cost, a list of integers
    # @return an integer
    def canCompleteCircuit(self, gas, cost):
        tank = total = 0
        start = 0 
        for i in range(len(gas)):
            tank += gas[i] - cost[i]
            total += gas[i] - cost[i]
            if tank < 0:
                start = i + 1
                tank = 0
        if total >= 0:
            return start
        else:
            return -1

if __name__ == '__main__':
    gas = [1, 2, 3]
    cost = [2, 4, 0]
    s = Solution()

    print s.canCompleteCircuit(gas, cost)
