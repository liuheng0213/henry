package basic.knowledge.henry.algorithm.algorithm_4_Edition.ch2.sort_01_bubble_select_insert_shell;

import basic.knowledge.henry.algorithm.algorithm_4_Edition.mock.MockData;
import basic.knowledge.henry.algorithm.algorithm_4_Edition.util.SortUtil;

import java.util.ArrayList;
import java.util.List;

public class _01BubbleSort {
    public static void main(String[] args) {
        sort(MockData.INTEGER_FOR_SORT_MOCK);
        SortUtil.isSorted(MockData.INTEGER_FOR_SORT_MOCK);
    }

    //每一轮把最大的放后面
    public static void sort(Comparable[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - (i - 1) - 1; j++) {
                if (SortUtil.less(arr[j + 1], arr[j])) {
                    SortUtil.exch(arr, j, j + 1);
                }
            }
        }

    }
    public static void countSort(List<List<String>> arr) {
        // Write your code here
        List<Line> lines = new ArrayList<>();
        for(List<String> ele : arr){
            lines.add(new Line(Integer.valueOf(ele.get(0)),ele.get(1),false));
        }

    }


    static class Line implements Comparable<Line>{
        int idx;
        String value;
        boolean deleted;

        public Line(int idx,String value,boolean deleted){
            this.idx = idx;
            this.value = value;
            this.deleted = deleted;
        }

        @Override
        public int compareTo(Line that) {
            return this.idx - that.idx;
        }
    }
}
