package basic.knowledge.stephen.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class BasicTest {
    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        //test7();
        test8();
    }

    private static void test8() {
        Map<Integer,Integer> map = new HashMap<>();
        Integer integer = map.get(2);
        System.out.println(integer);

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("123");
        String join = String.join(",", list);

        System.out.println(join);
    }

    private static void test7() {
        String str = "";
        char[] chars = str.toCharArray();

        System.out.println(chars.length == 0);
        int ch = 8;
        int x = (char)(ch + '0');

        System.out.println(x);



        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        list.add(4, 0);

        System.out.println();
    }

    private static void test6() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(7);
        queue.add(10);
        queue.add(8);

        System.out.println(queue.peek());

        System.out.println("32155".compareTo("32156"));
    }

    private static void test5() {
        System.out.println('c' - 'a');
    }

    private static void test4() {
        // TODO Auto-generated method stub
        String S = "012345678901234567890123456789";
        System.out.println(S.indexOf("23"));//输出2   （代表第一次出现字符串“23”的下标位置为2）
        System.out.println(S.indexOf("23", 4));//输出12  （代表从下标位置4开始，第一次出现字符串“23”的下标位置为12）

        System.out.println(S.lastIndexOf("89"));//输出30   （代表最后一次出现字符串“89”的下标位置为30）
        System.out.println(S.lastIndexOf("23", 11));//输出2  （代表从下标的位置0开始到下标的位置11结束最后一次出现字符串“23”的下标位置为2）
    }

    private static void test3() {
        String str = "11";
        char[] chars = str.toCharArray();
        System.out.println((chars[0] - '0') * 10 + (chars[1] - '0'));
    }

    private static void test2() {
        String str = "23456";
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            System.out.println("1 =====> " + ch);
            System.out.println("2 =====> " + Integer.valueOf(ch));
            System.out.println("3 =====> " + ch + "");
        }
        System.out.println();
    }

    private static void test1() {
       /* String str = "123";
        System.out.println(str.substring(0, 3));

        str = "1+2+3";
        String[] split = str.split("\\+");
        System.out.println(Arrays.toString(split));
*/
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.push(0);

        //System.out.println(queue.peek());
        System.out.println(queue.pollFirst());//删队列头
        System.out.println(queue.poll());//删队列头

        System.out.println("size :" + queue.size());

        System.out.println(queue.peek());//看队列头
        System.out.println(queue.pop());//删队列头
        System.out.println("size :" + queue.size());
        System.out.println(queue.getLast());//看队列尾
        System.out.println("size :" + queue.size());
        System.out.println(queue.pollLast());//删队列尾

        System.out.println("size :" + queue.size());

    }
}
