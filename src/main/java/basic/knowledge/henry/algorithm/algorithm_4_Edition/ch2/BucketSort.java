package basic.knowledge.henry.algorithm.algorithm_4_Edition.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int i;
        int a[] = {8,2,3,4,3,6,6,3,9};

        System.out.printf("before sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");

        bucketSort(a); // 桶排序

        System.out.printf("after  sort:");
        for (i=0; i<a.length; i++)
            System.out.printf("%d ", a[i]);
        System.out.printf("\n");
    }
    public static int[] bucketSort(int[] arr){
        if(arr == null || arr.length< 2){
            return arr;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        int idx = 0;
        for(int i = 0; i < bucketArr.size(); i++){
//            Collections.sort(bucketArr.get(i));
            Collections.sort(bucketArr.get(i));
            for(int num : bucketArr.get(i)){
                arr[idx++] =num;
            }
        }

        System.out.println(Arrays.toString(arr));
        return arr;

    }
}
