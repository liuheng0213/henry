package basic.knowledge.henry.algorithm.algorithm_4_Edition.ch1.stack;


//用栈解析运算过程

import java.util.Stack;

/**
 * 用两个栈一个存运算符,一个存操作数符
 *  遇到")" 两个都需要弹栈并运算,将结果再推到vals
 */
public class CalculatorUtil {
    public static Double getCalcResult(String calStr){
        char[] chars = calStr.toCharArray();
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]);
            if(s.equals(" ")){
                continue;
            }
            if ("(".equals(s)) {
                //do nothing
            } else if ("+".equals(s)) {
                ops.push(s);
            } else if ("-".equals(s)) {
                ops.push(s);
            } else if ("*".equals(s)) {
                ops.push(s);
            } else if ("/".equals(s)) {
                ops.push(s);
            } else if ("s".equals(s)) {
                char[] temp = new char[4];
                ops.push(String.valueOf(temp));
                i = i + 3;
            } else if (")".equals(s)) {
                Double val = vals.pop();
                String op = ops.pop();
                if ("+".equals(op)) {
                    val = vals.pop() + val;
                } else if ("-".equals(op)) {
                    val = vals.pop() - val;
                } else if ("*".equals(op)) {
                    val = vals.pop() * val;
                } else if ("/".equals(op)) {
                    val = vals.pop() / val;
                } else {
                    val = Math.sqrt(val);
                }
                vals.push(val);
            } else{
                vals.push(Double.valueOf(s));
            }
        }
        return vals.pop();
    }
}
