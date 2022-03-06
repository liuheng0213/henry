package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 用栈完成getMin方法 且O(1)
 */
public class _01GetMin {
    public static void main(String[] args) {

    }
    Stack<Integer> minStack = new Stack<>();
    Stack<Integer> popStack = new Stack<>();

    public _01GetMin(Stack<Integer> minStack, Stack<Integer> popStack) {
        this.minStack = minStack;
        this.popStack = popStack;
    }

    public int getMin(){
        if(!minStack.isEmpty()){
            return minStack.peek();
        }else {
            throw new RuntimeException();
        }
    }

    public int pop(){
        if(popStack.isEmpty()){
            throw new RuntimeException();
        }

        if(popStack.peek() == minStack.peek()){
            minStack.pop();
        }
        return popStack.pop();
    }

    public void push(int num){
        if(minStack.isEmpty() || minStack.peek() >= num){
            minStack.push(num);
        }
        popStack.push(num);
    }

}
