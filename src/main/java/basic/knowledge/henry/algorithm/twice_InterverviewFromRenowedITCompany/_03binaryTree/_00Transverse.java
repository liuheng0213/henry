package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._03binaryTree;


import java.util.Stack;

//非递归 和递归  遍历二叉树
public class _00Transverse {
    public void preUncur(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node pop = stack.pop();
            System.out.println(pop.value);

            if(pop.right != null){
                stack.push(pop.right);
            }

            if(pop.left != null){
                stack.push(pop.left);
            }
        }
    }


    public void inUncur(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty()|| head != null){
          if(head != null){
              stack.push(head);
              head = head.left;
          }else{
              head = stack.pop();
              System.out.println(head.value);
              head = head.right;
          }
        }
    }

    public void postUncur(Node head){
        if(head == null){
            return;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        while(!stack1.isEmpty()){
           head = stack1.pop();
           stack2.push(head);

           if(head.left != null){
               stack1.push(head.left);
           }

            if(head.right != null){
                stack1.push(head.right);
            }
        }


        while(!stack2.isEmpty()){
            System.out.println(stack2.pop().value);
        }
    }

}
