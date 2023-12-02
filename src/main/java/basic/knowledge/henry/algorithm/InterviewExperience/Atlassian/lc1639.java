package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian;

public class lc1639 {
    public static void main(String[] args) {
        lc1639 lc1639 = new lc1639();
        int i = lc1639.numWays(new String[]{"acca", "bbbb", "caca"}, "aba");
        System.out.println(i);
    }


    int[][] count;
    int MOD = (int) (Math.pow(10, 9) + 7);
    Long[][] memo;

    public int numWays(String[] words, String target) {
        count = new int[26][words[0].length()];
        memo = new Long[words[0].length()][target.length()];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                count[word.charAt(i) - 'a'][i]++;
            }
        }

        return (int) dfs(target, 0, 0);
    }

    // at i (in word[i].length),
    // at k (in target)
    private long dfs(String target, int i, int k) {
        if (k == target.length())
            return 1;

        if (i == count[0].length)
            return 0;

        if (memo[i][k] != null)
            return memo[i][k];

        memo[i][k] = dfs(target, i + 1, k);  // do not choose target.charAt(k), so we still need to start with K
        memo[i][k] += count[target.charAt(k) - 'a'][i] * dfs(target, i + 1, k + 1);// //  choose target.charAt(k), we start with K= 1

        return memo[i][k] % MOD;
    }

//    public int numWays(String[] words, String target) {
//        return solution(0, 0, words, target);
//    }

    private int solution(int idx, int k, String[] words, String target) {
        if (target.equals("")) {
            return 1;
        }

        int num = 0;
        int i = idx;
        while (i != idx + words.length) {
            int convertedI = i > words.length - 1? i % words.length : i;
            for (int j = k; j < words[0].length(); j++) {
                if (words[convertedI].charAt(j) == target.charAt(0)) {
                    num += solution(i + 1, j + 1, words, target.substring(1));
                }

            }
            i++;

        }


        return num;
    }
}
