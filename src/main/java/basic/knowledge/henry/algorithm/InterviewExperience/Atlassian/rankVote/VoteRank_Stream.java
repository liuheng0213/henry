package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.rankVote;

import java.util.*;

// use stream
public class VoteRank_Stream {
    public static void main(String[] args) {
        VoteRank_Stream voteRankStream = new VoteRank_Stream();
        //["ABC","ACB","ABC","ACB","ACB"]
        String x = voteRankStream.rankTeams("ABC");
        System.out.println(x);
        String y = voteRankStream.rankTeams("ACB");
        String z = voteRankStream.rankTeams("ABC");
        System.out.println(z);
        String e = voteRankStream.rankTeams("ACB");
        String f = voteRankStream.rankTeams("ACB");
        System.out.println(f);
    }
    HashMap<Character, Vote> voteMap = new HashMap<>();
    int len;
    TreeSet<Vote> ranks = new TreeSet<>();
    public String rankTeams(String str) {
        this.len = str.length();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < len; i++) {
            Vote vote = voteMap.getOrDefault(charArray[i], new Vote(charArray[i], len));
            ranks.remove(vote);
            vote.ranks[i]++;
            voteMap.put(charArray[i], vote);
            ranks.add(vote);
        }
        StringBuilder sb = new StringBuilder();
        for(Vote v : ranks){
            sb.append(v.letter);
        }
        return sb.toString();
    }

    private class Vote implements Comparable<Vote> {
        Character letter;
        int[] ranks;

        public Vote(char letter, int n) {
            this.letter = letter;
            this.ranks = new int[n];
        }

        @Override
        public int compareTo(Vote that) {
            int index = 0;
            while (index < len && this.ranks[index] == that.ranks[index]) {
                index++;
            }
            return index == len ? this.letter.compareTo(that.letter) : that.ranks[index] - this.ranks[index];
        }
    }
}
