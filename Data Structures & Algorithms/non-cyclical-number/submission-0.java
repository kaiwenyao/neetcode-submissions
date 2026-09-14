class Solution {
    public boolean isHappy(int n) {
        while (n != 1 && n != 4) {
            int tmp = 0;
            while (n > 0) {
                tmp += (n % 10) * (n % 10);
                n /=10; 
            }
            n = tmp;
        }  
        return n == 1;
    }
}
