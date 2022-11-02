package basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

public class _01MinStack {
    public static void main(String[] args) {
        _01MinStack getMin = new _01MinStack();
        getMin.push(512);
        getMin.push(-1024);
        getMin.push(-1024);
        getMin.push(512);

        getMin.pop();
        Integer min = getMin.getMin();
        System.out.println(min);
        getMin.pop();
        Integer min1 = getMin.getMin();
        System.out.println(min1);
        getMin.pop();
        Integer min2 = getMin.getMin();
        System.out.println(min2);
    }

    Stack<Integer> s = new Stack<>();
    Stack<Integer> mS = new Stack<>();

    public _01MinStack() {

    }

    public void push(int val) {
        s.push(val);
        if (mS.isEmpty() || mS.peek() >= val) {
            mS.push(val);
        }

    }

    public void pop() {

        if (!mS.isEmpty() && s.peek() == mS.peek()) {
            mS.pop();
        }
        s.pop();

    }

    public int top() {

        return s.peek();
    }

    public int getMin() {

        return mS.peek();
    }
}
