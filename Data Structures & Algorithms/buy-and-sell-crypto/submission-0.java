class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0 ;
        for (int a : prices ) {
            if (a < min ) min = a;
            else res = Math.max(res, a - min);
        }
        return res;
    }
}
