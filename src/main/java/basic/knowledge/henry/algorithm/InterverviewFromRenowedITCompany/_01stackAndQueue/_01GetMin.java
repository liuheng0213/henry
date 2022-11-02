package basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 用栈完成getMin方法 且O(1)
 */
public class _01GetMin {
    public static void main(String[] args) {
        _01GetMin getMin = new _01GetMin();
        getMin.push(512);
        getMin.push(-1024);
        getMin.push(-1024);
        getMin.push(512);

        getMin.pop();
//        System.out.println(pop);
        Integer min = getMin.getMin();
        System.out.println(min);
         getMin.pop();
//        System.out.println(pop1);
        Integer min1 = getMin.getMin();
        System.out.println(min1);
         getMin.pop();
//        System.out.println(pop2);
        Integer min2 = getMin.getMin();
        System.out.println(min2);
    }
    private Stack<Integer> stack;
    private Stack<Integer> minStack;


    public _01GetMin() {
        this.minStack = new Stack<>();
        this.stack = new Stack<>();
    }


    public void push(Integer value) {
        this.stack.push(value);
        if (minStack.isEmpty() || this.getMin() >= value) {
            this.minStack.push(value);
        }
    }

    public Integer getMin() {
        if (this.minStack.isEmpty()) {
            throw new RuntimeException("");
        }
        return this.minStack.peek();
    }

    public void pop() {
//        if (this.stack.isEmpty()) {
//            throw new RuntimeException("");
//        }
//        if (!minStack.isEmpty() && this.getMin() == this.stack.peek()) {
//            this.minStack.pop();
//        }
//        return this.stack.pop();



        if(!minStack.isEmpty() &&stack.peek() == minStack.peek()){
            minStack.pop();
        }
        stack.pop();



    }
}
