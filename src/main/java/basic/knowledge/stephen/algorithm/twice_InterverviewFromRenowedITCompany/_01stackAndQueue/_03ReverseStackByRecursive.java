package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 仅用递归函数逆序一个栈
 */
public class _03ReverseStackByRecursive {
    public void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);

    }

    private int getAndRemoveLastElement(Stack<Integer> stack) {
        // correctly get the base case
        int result = stack.pop();
        if(stack.isEmpty()){
            return result;
        }



        int last = getAndRemoveLastElement(stack);
        stack.push(result);

        return last;
    }

}
