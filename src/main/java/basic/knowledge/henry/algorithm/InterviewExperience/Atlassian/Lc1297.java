package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lc1297 {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        HashMap<Character, Integer> chMap = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            chMap.put(cur, chMap.getOrDefault(cur, 0) + 1);

            while (right - left + 1 >= minSize && right - left + 1 <= maxSize) {
                String sub = s.substring(left, right + 1);

                if (chMap.size() <= maxLetters) {
                    map.put(sub, map.getOrDefault(sub, 0) + 1);
                }
                char leftCh = s.charAt(left);
                if (chMap.get(leftCh) == 1) {
                    chMap.remove(leftCh);
                } else {
                    chMap.put(leftCh, chMap.get(leftCh) - 1);
                }
                left++;
            }
            right++;
        }
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, (a, b) -> b - a);

        return list.size() == 0 ? 0 : list.get(0);
    }
}
