class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1
        cur = 0
        st = 0
        
        for i in range(len(gas)):
            cur += gas[i]
            if cur < cost[i]:
                st = i + 1
                cur = 0
            else:
                cur -= cost[i]
        return st