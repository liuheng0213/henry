package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _04RobotGetDestination {

    public static void main(String[] args) {
        _04RobotGetDestination robotGetDestination = new _04RobotGetDestination();
        int res = robotGetDestination.ways(7, 3, 4, 5);
        System.out.println(res);
    }

    private int ways(int N, int cur, int rest, int P) {
        if (N < 2 || cur < 1 || cur > N || P < 1 || P > N || rest < 1) {
            return 0;
        }
        return walk(N, cur, rest, P);
    }

    private int walk(int n, int cur, int rest, int p) {
        if (rest == 0) {
            return cur == p ? 1 : 0;
        }

        if (cur == 1) {
            return walk(n, 2, rest - 1, p);
        }

        if (cur == n) {
            return walk(n, n - 1, rest - 1, p);
        }

        return walk(n, cur + 1, rest - 1, p) + walk(n, cur - 1, rest - 1, p);
    }


}
