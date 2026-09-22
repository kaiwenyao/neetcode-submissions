class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int[] st = new int[1010];
        int n = hand.length;
        for (int i = 0;i < n; i ++ ) {
            st[hand[i]] ++;
        }
        for (int i = 0; i < 1010;i ++ ) {
            if (st[i] > 0) {
                int val = st[i];
                for (int j = i; j < Math.min(i + groupSize, 1010); j ++ ) {
                    st[j] -= val;
                }
            }
        }
        for (int i= 0; i < 1010; i ++ ) 
        {
            if (st[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
