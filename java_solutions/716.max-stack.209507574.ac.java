/*
 * @lc app=leetcode id=716 lang=java
 *
 * [716] Max Stack
 *
 * https://leetcode.com/problems/max-stack/description/
 *
 * algorithms
 * Easy (40.56%)
 * Total Accepted:    28.6K
 * Total Submissions: 70.5K
 * Testcase Example:  '["MaxStack","push","push","push","top","popMax","top","peekMax","pop","top"]\n' +
  '[[],[5],[1],[5],[],[],[],[],[],[]]'
 *
 * Design a max stack that supports push, pop, top, peekMax and popMax.
 * 
 * 
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you
 * find more than one maximum elements, only remove the top-most one.
 * 
 * 
 * 
 * Example 1:
 * 
 * MaxStack stack = new MaxStack();
 * stack.push(5); 
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * 
 * 
 * 
 * Note:
 * 
 * -1e7 
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 * 
 * 
 */
class MaxStack {
    Stack<Integer> actualStack;
    Stack<Integer> maxStack;
    
    /** initialize your data structure here. */
    public MaxStack() {
        maxStack = new Stack<Integer>();
        actualStack = new Stack<Integer>();
    }
    
    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
        maxStack.push(x > max ? x : max);
        actualStack.push(x);
    }
    
    public int pop() {
        maxStack.pop();
        return actualStack.pop();
    }
    
    public int top() {
        return actualStack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = maxStack.peek();
        Stack<Integer> buffer = new Stack<Integer>();
        while (actualStack.peek() != max)
            buffer.push(pop());
        pop();
        while (!buffer.isEmpty())
            push(buffer.pop());
        return max;
        
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
