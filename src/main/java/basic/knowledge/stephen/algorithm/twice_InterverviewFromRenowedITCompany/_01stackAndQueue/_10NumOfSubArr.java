package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._01stackAndQueue;

import java.util.LinkedList;

//最大值减去最小值小于等于Num的 所有子数组的数量
public class _10NumOfSubArr {


    public int getNum(int[] arr, int num) {
        //todo if judgement
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();

        int i = 0;
        int j = 0;
        int res = 0;

        while (i < arr.length) {
            while (j < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
                    qmin.pollLast();
                }
                qmin.addLast(j);

                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);

                if (qmax.peekFirst() - qmin.peekFirst() > num) {
                    break;
                }

                j++;
            }

            res += j - i;

            if (qmin.peekFirst() == i) {
                qmin.pollFirst();
            }

            if (qmax.peekFirst() == i) {
                qmax.pollFirst();
            }

            i++;
        }

        return res;
    }


}
