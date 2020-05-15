package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.Arrays;
/**
 * 题目：已知一些孩子和一些糖果，每个孩子有需求因子g，每个糖果有大小s，当某个糖果的大小s>=某个孩子的需求因子g时，代表该糖果可以满足该孩子，求使用这些糖果，最多能满足多少孩子（注意，某个孩子最多只能用1个糖果满足）

 思考：
 当某个孩子可以被多个糖果满足时，是否需要优先用某个糖果满足这个孩子？
 当某个糖果可以满足多个孩子时，是否需要优先满足某个孩子？
 贪心规律是什么？

 贪心规律：
 某个糖果如果不能满足某个孩子，则该糖果也一定不能满足需求因子更大的孩子

 某个孩子可以用更小的糖果满足，则没必要用更大糖果满足，因为可以保留更大的糖果满足需求因子更大的孩子
 孩子的需求因子更小则其更容易被满足，故优先从需求因子小的孩子尝试，可以得到正确的结果(因为我们追求更多的孩子被满足，所以用一个糖果满足需求因子较小或较大的孩子都是一样的)。
 算法设计：

 (1)对需求因子数组g和糖果大小数组s进行从小到大的排序
 (2)按照从小到大的顺序使用各糖果尝试是否可满足某个孩子，每个糖果只尝试1次，只有尝试成功时，换下一个孩子尝试，直到发现没更多的孩子或者没有更多的糖果，循环结束。
 */




/**
 * 题目描述：leetcode 455

 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

 注意：

 你可以假设胃口值为正。
 一个小朋友最多只能拥有一块饼干。

 示例 1:

 输入: [1,2,3], [1,1]

 输出: 1

 解释:
 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 所以你应该输出1。

 示例 2:

 输入: [1,2], [1,2,3]

 输出: 2

 解释:
 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 所以你应该输出2.

 */



public class Leetcode455CandyAllocation {
    public static void main(String[] args) {
        int[] g = {5,10,2,9,15,9};//小孩的糖果需求因子数组  child
        int[] s = {6,1,20,3,8};//糖果大小数组   candy

        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0;
        int candy = 0;

        while(child != g.length && candy != s.length){
            if(g[child] <= s[candy]){
                child++;
            }
            candy++;
        }
        // child == g.length || candy == length  出来时的情况
        System.out.println(candy);
    }

    /**
     * leetcode455
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        // 首先对两个数组排序
        Arrays.sort(g);
        Arrays.sort(s);
        // 两个数组的下标索引
        int gi = g.length - 1;
        int si = s.length - 1;
        // 满足孩子的数量
        int result = 0;
        // 分发饼干
        while (gi >= 0 && si >= 0) {
            // 将最大的饼干分给胃口最大的小孩 孩子满足
            if (g[gi] <= s[si]) {
                // 满足孩子数量+1
                result++;
                // 孩子胃口数下标-1
                gi--;
                // 饼干数组下标-1
                si--;
            } else {
                // 将最大的饼干分给胃口最大的小孩 孩子不满足
                // 将饼干分给胃口小一号的孩子
                gi--;
            }
        }
        return result;
    }

}