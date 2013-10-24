# There are N gas stations along a circular route, where the amount of gas
# at station i is gas[i].

# You have a car with an unlimited gas tank and it costs cost[i] of gas to
# travel from station i to its next station (i+1). You begin the journey
# with an empty tank at one of the gas stations.

# Return the starting gas station's index if you can travel around the
# circuit once, otherwise return -1.

# Note:
# The solution is guaranteed to be unique.


def canCompleteCircuit(gas, cost):
    s = total = 0
    j = -1
    for i in range(len(gas)):
        s += gas[i] - cost[i]
        total += gas[i] - cost[i]
        if s < 0:
            j = i
            s = 0
    if total >= 0:
        return j + 1
    else:
        return -1

gas = [1, 2, 3]
cost = [2, 4, 0]

print canCompleteCircuit(gas, cost)
