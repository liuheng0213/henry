package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk;


import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 *
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 *
 *
 *
 * Example 1:
 *
 * Input: s = "1 + 1"
 * Output: 2
 * Example 2:
 *
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * Example 3:
 *
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
public class Leetcode224 {
    public int calculate(String s) {
        Stack<Integer> numstack = new Stack<Integer>();
        Stack<Integer> signstack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        char[] chs = s.toCharArray();
        for(int i = 0;i< chs.length;i++){
            char c = chs[i];
            if(Character.isDigit(c)){
                number = 10 * number + (c- '0');
            }else if(c == '+'){
                result+= sign* number;
                sign = 1;
                number = 0;
            }else if(c == '-'){
                result+= sign* number;
                sign = -1;
                number = 0;
            }else if(c == '('){
                numstack.push(result);
                signstack.push(sign);
                sign = 1;
                result = 0;
            }else if(c == ')'){
                result += sign*number;
                number = 0;
                result *= signstack.pop();
                result += numstack.pop();
            }
        }

        if(number != 0) result += sign * number;
        return result;
    }
}
