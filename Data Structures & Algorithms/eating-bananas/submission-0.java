class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            r = Math.max(pile, r);
        }
        while (l < r) {
            int mid = l + r >> 1;
            if (calc(piles, mid) <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    public int calc(int[] piles, int rate) {
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            sum += piles[i] % rate == 0 ? piles[i] / rate : piles[i] / rate + 1;
        }
        return sum;
    }
}
