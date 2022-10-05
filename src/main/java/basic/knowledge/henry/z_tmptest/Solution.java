package basic.knowledge.henry.z_tmptest;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Integer.valueOf("06"));



    }




    //for amazon
    public boolean isStrictlyPalindromic(int n) {

        ArrayList<Integer> list = null;

        for (int base = 2; base <= n - 2; base++) {
            list = new ArrayList<>();
            int temp = n;
            while (temp > 0) {
                list.add(temp % base);
                temp /= base;
            }

            int l = 0;
            int r = list.size() - 1;

            while (l <= r) {
                if (list.get(l) != list.get(r)) {
                    return false;
                }
                l++;
                r--;
            }


        }

        return true;
    }


    //first
    public static int shoppingOptions(int[] pants, int[] shirts, int[] shoes, int[] skirts, int budget) {
        int X = pants.length;
        int Y = shirts.length;

        int[] sumOfPantsShirts = new int[X * Y];
        int counter = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {

                int sum = pants[i] + shirts[j];
                sumOfPantsShirts[counter++] = sum;
            }
        }

        Arrays.sort(sumOfPantsShirts);


        int ans = 0;
        for (int i = 0; i < shoes.length; i++) {
            for (int j = 0; j < skirts.length; j++) {
                int remainingAmount = budget - shoes[i] - skirts[j];
                int idx = getNumbersLessAmount(sumOfPantsShirts, remainingAmount);
                ans += idx == -1 ? 0 : idx + 1;
            }
        }

        return ans;
    }

    private static int getNumbersLessAmount(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;


        int res = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;

    }


    //second

    /**
     * Give you a list servers. Their processing power is given as a array of integer, and boot power as a array of integer.
     * Write a function to return the max length of sub array which's power consumption is less than or equal to max power limit.
     * Formula to calculate the power consumption for a subArray is:
     * Max(bootPower[i...j]) + Sum(processPower[i....j]) * length of subArray.
     * <p>
     * Note: Single server is also a subArray, return 0 if no such subArray can be found.
     *
     * @return
     */
    //TreeSet o(nlogn)
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        PriorityQueue<Integer> set = new PriorityQueue<>();

        int i = 0;
        int n = chargeTimes.length;

        int res = 0;
        long sum = 0;
        for (int j = 0; j < n; j++) {
            sum += runningCosts[j];
            set.add(chargeTimes[j]);

            if (set.peek() + sum * (j - i + 1) <= budget) {
                res = Math.max(res, j - i + 1);

            } else {
                if (set.peek() == chargeTimes[i]) {
                    set.poll();
                }
                sum -= runningCosts[i++];
            }
        }

        return res;
    }

    /**
     * leetcode 907
     * Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr.
     * Since the answer may be large, return the answer modulo 109 + 7.
     *
     * @param arr
     * @return
     */
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int mod = 1000000007;

        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                int pop = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();

                res += (1L * arr[pop] * (pop - left) * (i - pop)) % mod;
                res = res % mod;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int pop = st.pop();
            int left = st.isEmpty() ? -1 : st.peek();

            res += (1L * arr[pop] * (pop - left) * (arr.length - pop)) % mod;
            res = res % mod;
        }

        return (int) res;
    }

    /**
     * 1041
     *
     * @param instructions
     * @return
     */
    public boolean isRobotBounded(String instructions) {
        char[] ins = instructions.toCharArray();
        int x = 0;
        int y = 0;
        char dir = 'N';

        for (char pos : ins) {

            switch (pos) {
                case 'G':
                    if (dir == 'E')
                        x++;
                    else if (dir == 'W')
                        x--;
                    else if (dir == 'N')
                        y++;
                    else if (dir == 'S')
                        y--;
                    break;
                case 'L':
                    if (dir == 'E')
                        dir = 'N';
                    else if (dir == 'W')
                        dir = 'S';
                    else if (dir == 'N')
                        dir = 'W';
                    else if (dir == 'S')
                        dir = 'E';
                    break;
                case 'R':
                    if (dir == 'E')
                        dir = 'S';
                    else if (dir == 'W')
                        dir = 'N';
                    else if (dir == 'N')
                        dir = 'E';
                    else if (dir == 'S')
                        dir = 'W';
                    break;
            }

        }


        if ((x == 0 && y == 0) || dir != 'N') {
            return true;
        }

        return false;
    }


}
