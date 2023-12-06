package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.rankVote;

import java.util.*;

//different length
// use stream
public class VoteRank_Stream_2 {
    public static void main(String[] args) {
        TreeSet<Integer> set1 = new TreeSet<>();
        set1.add(1);
        set1.remove(1);
        set1.remove(2);
        VoteRank_Stream_2 voteRankStream = new VoteRank_Stream_2();
        //["ABC","ACB","ABC","ACB","ACB"]
        String x = voteRankStream.rankTeams("ABCD");
        System.out.println(x);
        String y = voteRankStream.rankTeams("DACBB");
        System.out.println(y);
        String z = voteRankStream.rankTeams("DABC");
        System.out.println(z);
        String e = voteRankStream.rankTeams("ADCBA");
        System.out.println(e);
        String f = voteRankStream.rankTeams("AADDCB");
        System.out.println(f);
    }

    HashMap<Character, Vote> voteMap = new HashMap<>();

    TreeSet<Vote> ranks = new TreeSet<>();

    public String rankTeams(String str) {

        char[] charArray = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            Vote vote = voteMap.getOrDefault(charArray[i], new Vote(charArray[i]));
            ranks.remove(vote);
            vote.ranks.put(i, vote.ranks.getOrDefault(i, 0) + 1);
            vote.updateMax(vote.ranks.getOrDefault(i, 0) + 1);
            voteMap.put(charArray[i], vote);
            ranks.add(vote);
        }
        StringBuilder sb = new StringBuilder();
        for (Vote v : ranks) {
            sb.append(v.letter);
        }
        return sb.toString();
    }

    private class Vote implements Comparable<Vote> {
        Character letter;
        HashMap<Integer, Integer> ranks;
        int max = -1; // 用于compareTo中
        public Vote(char letter) {
            this.letter = letter;
            this.ranks = new HashMap<>();
        }

        public void updateMax(int num){
            this.max = Math.max(num,this.max);
        }

        @Override
        public int compareTo(Vote that) {
            int index = 0;
            int max = Math.max(this.max, that.max);
            while (index <= max) {
                int this_times = this.ranks.containsKey(index) ? this.ranks.get(index) : 0;
                int that_times = that.ranks.containsKey(index) ? that.ranks.get(index) : 0;
                if (this_times != that_times) {
                    return that_times - this_times;
                }
                index++;
            }
            return this.letter.compareTo(that.letter);


        }
    }

//    private class Vote implements Comparable<Vote> {
//        Character letter;
//        TreeMap<Integer, Integer> ranks;
//
//        public Vote(char letter) {
//            this.letter = letter;
//            this.ranks = new TreeMap<>();
//        }
//
//        @Override
//        public int compareTo(Vote that) {
//            int index = 0;
//            int max = Math.max(this.ranks.size() == 0 ? 0 : this.ranks.lastKey(), that.ranks.size() == 0 ? 0 :that.ranks.lastKey());
//            while (index <= max) {
//                int this_times = this.ranks.containsKey(index) ? this.ranks.get(index) : 0;
//                int that_times = that.ranks.containsKey(index) ? that.ranks.get(index) : 0;
//                if (this_times != that_times) {
//                    return that_times - this_times;
//                }
//                index++;
//            }
//            return this.letter.compareTo(that.letter);
//
//
//        }
//    }
}
