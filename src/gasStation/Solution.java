public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int curr = 0;
        int total = 0;
        for (int i = 0; i < gas.length; ++i) {
            if (curr < 0) {
                start = i;
                curr = gas[i] - cost[i];
            } else {
                curr += gas[i] - cost[i];
            }
            total += gas[i] - cost[i];
        }
        if (total >= 0) {
            return start;
        } else {
            return -1;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] gas = new int[] {1, 9, 1, 1};
        int[] cost = new int[] {2, 1, 1, 1};

        System.out.println(s.canCompleteCircuit(gas, cost));
    }
}