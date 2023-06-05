package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._04recursiveAndDynamicProgramming;

public class _04RobotGetDestination {

    public static void main(String[] args) {
        _04RobotGetDestination robotGetDestination = new _04RobotGetDestination();
        int res = robotGetDestination.solution(7, 3, 4, 5);
        System.out.println(res);
    }

    //N 1~N
    //cur current position
    // rest steps
    //target target position
    private int solution(int n, int cur, int rest, int target) {
//        if (N < 2 || M < 1 || M > N || P < 1 || P > N || K < 1) {
//            return 0;
//        }

        if (rest == 0) {
            return cur == target ? 1 : 0;
        }

        if (cur == 1) {
            return solution(n, cur + 1, rest - 1, target);
        }

        if (cur == n) {
            return solution(n, cur - 1, rest - 1, target);
        }

        return solution(n, cur + 1, rest - 1, target) + solution(n, cur - 1, rest - 1, target);
    }

}
