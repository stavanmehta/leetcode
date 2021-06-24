class MovingAverage {
    
    Queue<Integer> abc = new LinkedList<Integer>();
    int length;
    int count;
    double result=0;
    
    
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        length = size;  
        count = 0;
    }
    
    public double next(int val) {
        if (abc.size() == length)
            result-=abc.remove();
        result += val;
        abc.add(val);
        return result/abc.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
