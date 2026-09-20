class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        ArrayDeque<Double> stk = new ArrayDeque<>();
        int n = position.length;
        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> a[0]- b[0]); 

        for (int i = 0; i < n; i++) {
            double t = (target - cars[i][0]) * 1.0 / cars[i][1];
            while (!stk.isEmpty() && t >= stk.peek()) {
                stk.pop();
            }
            stk.push(t);
            // for (double a : stk) {
            //     System.out.printf("%f, ", a);
            // }
            // System.out.println();
        }

        return stk.size();
    }
}
