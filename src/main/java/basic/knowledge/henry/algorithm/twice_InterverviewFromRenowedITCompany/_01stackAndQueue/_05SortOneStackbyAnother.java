package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 */
public class _05SortOneStackbyAnother {
    public void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack<>();
        while(!stack.isEmpty()){
            int cur = stack.pop();
            while(!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while(!help.isEmpty()){
            stack.push(help.pop());
        }
    }
}
