package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1307 {
    public static void main(String[] args) {

        Leetcode1307 leetcode1307 = new Leetcode1307();
        String[] words = new String[]{"SIX","SEVEN","SEVEN"};
        String result = "TWENTY";
        boolean solvable = leetcode1307.isSolvable(words, result);
        System.out.println("res ----> " + solvable);
    }

    public boolean isSolvable(String[] words, String result) {
        String uniqueLetter = "";

        boolean[] added = new boolean[26];
        for (String word : words) {
            for (int itr = 0; itr < word.length(); itr++) {
                char ch = word.charAt(itr);
                if (!added[ch - 'A']) {
                    added[ch - 'A'] = true;
                    uniqueLetter += ch;
                }
            }
        }
        for (int itr = 0; itr < result.length(); itr++) {
            char ch = result.charAt(itr);
            if (!added[ch - 'A']) {
                added[ch - 'A'] = true;
                uniqueLetter += ch;
            }
        }
        return helper(uniqueLetter, 0, words, result, new boolean[10], new int[26]);
    }

    /**
     * helper means whether it can return true or false by replace the letters in uniqueLetter with trying different numbers
     * @param uniqueLetter
     * @param vidx
     * @param words
     * @param result
     * @param used
     * @param charInt
     * @return
     */
    public boolean helper(String uniqueLetter, int vidx, String[] words, String result, boolean[] used, int[] charInt)     {
        if (vidx == uniqueLetter.length()) {
            int leftNo = 0;
            int rightNo = 0;
            for (String word : words) {
                leftNo += stringToNumber(word, charInt);
            }
            rightNo = stringToNumber(result, charInt);

            if (leftNo == rightNo) {
                for (int i = 0; i < uniqueLetter.length(); i++) {
                    char ch = uniqueLetter.charAt(i);
                }
                return true;
            }
            return false;
        }
        char ch = uniqueLetter.charAt(vidx);
        // purpose :   try with replacing  letters in uniqueLetter with different val
        for (int val = 0; val <= 9; val++) {
           // I think  falg is used to skip the condition that first letter to represent zero when the word's length is more than 1
            boolean flag = false;
            if (val == 0) {
                for (String word : words) {
                    //word.charAt(0) is not allowed to be zero(val)
                    if (word.charAt(0) == ch  && word.length() > 1) {
                        flag = true;
                        break;
                    }
                }
                if ( ch == result.charAt(0) && result.length() > 1) {
                    flag = true;
                }
            }
            if (flag) {
                continue;
            }
            if (!used[val]) {
                used[val] = true;
                charInt[ch - 'A'] = val;
                if (helper(uniqueLetter, vidx + 1, words, result, used, charInt)) {
                    return true;
                }
                charInt[ch - 'A'] = -1;
                used[val] = false;
            }
        }
        return false;
    }
    public int stringToNumber(String s, int[] charInt) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int val = charInt[ch - 'A'];
            //num+=val*(Math.pow(10,s.length()-1-i));
            num = num * 10 + val;
        }
        return num;
    }

}
