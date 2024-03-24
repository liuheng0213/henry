package basic.knowledge.henry.algorithm;


import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        String bcabc = new Solution().smallestSubsequence("cbacdcbc");
        System.out.println(bcabc);
    }

    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[26];

        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']--;
            while (!stack.isEmpty() && stack.peek() >= s.charAt(i)) {
                if(counts[stack.peek() - 'a'] == 0){
                    break;
                }
                stack.pop();

            }
            System.out.println(s.charAt(i));
            stack.push(s.charAt(i));


        }

        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();


    }
}