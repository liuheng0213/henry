package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.rankVote;

import java.util.*;

// use stream
public class VoteRank_Stream_string_key {
    public static void main(String[] args) {
        VoteRank_Stream_string_key voteRankStream = new VoteRank_Stream_string_key();

        List<String> list1 = Arrays.asList("henry", "paul", "Sing", "Usha");
        List<String> list2 = Arrays.asList("paul", "henry", "Sing", "Usha");
        List<String> list3 = Arrays.asList("paul", "henry");
        List<String> list4 = Arrays.asList("paul", "henry", "Usha", "Sing");
        List<String> list5 = Arrays.asList("paul", "henry", "Usha");
        List<String> list6 = Arrays.asList("paul", "henry", "Usha");
        List<String> list7 = Arrays.asList("paul", "henry", "Sing","Usha");
        voteRankStream.rankTeams(list1);
        System.out.println("====================");
        voteRankStream.rankTeams(list2);
        System.out.println("====================");
        voteRankStream.rankTeams(list3);
        System.out.println("====================");
        voteRankStream.rankTeams(list4);
        System.out.println("====================");
        voteRankStream.rankTeams(list5);
        System.out.println("====================");
        voteRankStream.rankTeams(list6);
        System.out.println("====================");
        voteRankStream.rankTeams(list7);
    }

    HashMap<String, Vote> voteMap = new HashMap<>();
    TreeSet<Vote> ranks = new TreeSet<>();

    int sequence = 0;
    public void rankTeams(List<String> voteList) {
        sequence++;
        for (int i = 0; i < voteList.size(); i++) {
            Vote vote = voteMap.getOrDefault(voteList.get(i), new Vote(voteList.get(i)));
            ranks.remove(vote);
            vote.updateVote(i,sequence);
            voteMap.put(voteList.get(i),vote);
            ranks.add(vote);
        }
        printRank(4);
    }

    private void printRank(int k) {
        for(Vote v : ranks){
            System.out.println(v.name);
            k--;
            if(k == 0){
                return;
            }
        }

    }


    private class Vote implements Comparable<Vote> {
        String name;
        int score;
        int sequence;

        private void updateVote(int rank,int sequence){
            if (rank == 0) {
                score += 3;
            } else if (rank == 1) {
                score += 2;
            } else if (rank == 2) {
                score++;
            }
            this.sequence = sequence;
        }

        public Vote(String name) {
            this.score = 0;
            this.sequence = 0;
            this.name = name;
        }


        @Override
        public int compareTo(Vote that) {
            if (this.score != that.score) {
                return that.score - this.score;
            }

            if (this.sequence != that.sequence) {
                return this.sequence - that.sequence;
            }
            return this.name.compareTo(that.name);
        }
    }
}
