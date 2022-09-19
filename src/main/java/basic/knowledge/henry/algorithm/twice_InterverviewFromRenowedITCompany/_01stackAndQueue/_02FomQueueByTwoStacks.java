package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 用两个队列构成一个栈 且有如下API
 * add poll peek
 */
public class _02FomQueueByTwoStacks {
    Stack<Integer> stackPop;
    Stack<Integer> stackPush;

    public _02FomQueueByTwoStacks(Stack<Integer> stackPop, Stack<Integer> stackPush) {
        this.stackPop = stackPop;
        this.stackPush = stackPush;
    }

    public void pushToPop(){
        if(stackPop.isEmpty()){
            while(!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
    }

    public void add(int num){
        this.stackPush.push(num);
        pushToPop();
    }

    public int poll(){
        //todo judgement
        pushToPop();
        return this.stackPop.pop();
    }

    public int peek(){
        //todo judgement
        pushToPop();
        return this.stackPop.peek();
    }


}
