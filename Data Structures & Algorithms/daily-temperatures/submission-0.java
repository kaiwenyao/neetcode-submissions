class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res= new int[n];
        ArrayDeque<Integer> stk = new ArrayDeque<>();

        for (int i = 0; i < n; i ++ ) {
            while (!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()]) {
                int p = stk.pop();
                res[p] = i - p;
            }
            stk.push(i);
        }
        return res;

    }
}
