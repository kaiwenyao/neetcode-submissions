class MinStack {
    ArrayDeque<Integer> stk;
    ArrayDeque<Integer> minStk;
    int min;
    public MinStack() {
        stk = new ArrayDeque<>();
        minStk = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (minStk.isEmpty() || val < minStk.peek()) {
            minStk.push(val);
        } else {
            minStk.push(minStk.peek());
        }
        stk.push(val);
    }

    public void pop() {
        stk.pop();
        minStk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}
