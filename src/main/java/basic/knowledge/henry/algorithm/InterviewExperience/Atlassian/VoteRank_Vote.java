package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;

import java.util.*;

public class VoteRank_Vote {



    public String rankVote(String[] votes) {

        HashMap<Character, Vote> map = new HashMap<>();
        int len = votes[0].length();
        for (String str : votes) {
            char[] charArray = str.toCharArray();
            for (int i = 0; i < len; i++) {
                Vote vote = map.getOrDefault(charArray[i], new Vote(charArray[i], len));
                vote.ranks[i]++;
                map.put(charArray[i], vote);
            }
        }

        ArrayList<Map.Entry<Character, Vote>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<Character, Vote>>() {
            @Override
            public int compare(Map.Entry<Character, Vote> e1, Map.Entry<Character, Vote> e2) {
                Vote o1 = e1.getValue();
                Vote o2 = e2.getValue();
                int index = 0;
                while(index < len && o1.ranks[index] == o2.ranks[index]){
                    index++;
                }
                return index == len? o1.letter- o2.letter : o2.ranks[index] - o1.ranks[index];
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character, Vote> entry : entries){
            sb.append(entry.getKey());
        }
        return sb.toString();

    }

    private class Vote {
        char letter;
        int[] ranks;

        public Vote(char letter, int n) {
            this.letter = letter;
            this.ranks = new int[n];
        }
    }
}
