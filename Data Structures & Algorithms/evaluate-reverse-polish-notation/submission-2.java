class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(token.length() - 1))) {
                stk.push(Integer.parseInt(token));
            }
            else {
                int tmp = 0;
                int a = stk.pop();
                int b = stk.pop();
                if (token.equals("+"))
                {
                    stk.push(a + b);
                }
                else if (token.equals("-"))
                {
                    stk.push(b - a);
                }
                else if (token.equals("*"))
                {
                    stk.push(a * b);
                }
                else {
                    stk.push(b / a);
                }
            }
        }
        return stk.pop();
    }
}
