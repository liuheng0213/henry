package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

//https://leetcode.com/discuss/interview-experience/1504226/indeed-karat-interview
public class BadgeAcess_followup {
    public static void main(String[] args) {
        BadgeAcess_followup badgeAcess = new BadgeAcess_followup();
        String[][] badges = new String[][]{
                {"Paul", "1355"},
                {"Jennifer", "1910"},
                {"John", "835"},
                {"John", "830"},
                {"Paul", "1315"},
                {"John", "1615"},
                {"John", "1640"},
                {"Paul", "1405"},
                {"John", "855"},
                {"John", "930"},
                {"John", "915"},
                {"John", "730"},
                {"John", "940"},
                {"Jennifer", "1335"},
                {"Jennifer", "730"},
                {"John", "1630"},
                {"Jennifer", "5"}
        };
        badgeAcess.getRes(badges);
    }

    //任一小时内, 出现大于3次的 人
    private void getRes(String[][] badges) {
        HashMap<String, ArrayList<Integer>> tmpMap = new HashMap<>();
        for (String[] entry : badges) {

            String emp = entry[0];
            String timeStr = entry[1];
            while (timeStr.length() < 4) {
                timeStr = "0" + timeStr;
            }

            int hrs = Integer.parseInt(timeStr.substring(0, 2));
            int mins = Integer.parseInt(timeStr.substring(2, 4));
            tmpMap.putIfAbsent(emp, new ArrayList<>());
            tmpMap.get(emp).add(60 * hrs + mins);
        }

        for (String name : tmpMap.keySet()) {
            ArrayList<Integer> times = tmpMap.get(name);
            Collections.sort(times);

            LinkedList<Integer> queue = new LinkedList<>();
            for (Integer cur : times) {
                if (queue.isEmpty()) {
                    queue.addLast(cur);
                } else {
                    // <= 60
                    if (cur - queue.peekFirst() <= 60) {
                        queue.addLast(cur);
                    } else if (queue.size() < 3) {//> 60 and size <3 means  needing poll first element
                        while (!queue.isEmpty() && cur - queue.peekFirst() > 60) {// do not use if
                            queue.pollFirst();
                        }
                        queue.addLast(cur);
                    } else {// > 60 and size >3 . condition to print
                        break;
                    }
                }
            }

            if (queue.size() > 2) {
                printMoreThan3(name, queue);
            }
        }


    }

    private String convertBack(Integer time) {
        String res = "";
        res += time / 60;
        res += time % 60 < 10 ? "0" + time % 60 : time % 60;

        return res;
    }

    private void printMoreThan3(String s, LinkedList<Integer> times) {
        System.out.print(s + ": ");
        for (int i = 0; i < times.size(); i++) {
            System.out.print(convertBack(times.get(i)) + " ");
        }
    }


}
