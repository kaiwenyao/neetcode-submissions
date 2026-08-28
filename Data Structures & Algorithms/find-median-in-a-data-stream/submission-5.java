class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a, b) -> { return b - a; });

        
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if (min.size() > max.size() ) {
            max.offer(min.poll());
        }

    }

    public double findMedian() {
        if (max.size() > min.size() ){
            return max.peek();
        }
        return (max.peek() + min.peek()) / 2.0;

    }
}
