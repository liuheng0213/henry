package basic.knowledge.henry.algorithm.algorithm_4_Edition.ch3;

import java.util.Arrays;

public class BinarySearchDemo {
    public static void main(String[] args) {
        BinarySearchDemo binarySearchDemo = new BinarySearchDemo();
        int[] arr = new int[]{2, 2, 8, 8, 8, 8, 11, 11, 13, 14, 15};

        int index = binarySearchDemo.searchTargetWithSmallestIndex(arr, 12);
        int index2 = Arrays.binarySearch(arr, 12);
        int index3 = binarySearchDemo.searchTargetWithBiggestIndex(arr, 3);
        System.out.println(index);
        System.out.println(index2);
        System.out.println(index3);

    }
    private int searchTargetWithBiggestIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        int res = -1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (arr[mid] == target) {
                res = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res == -1 ? left : res;
    }
    private int searchTargetWithSmallestIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        int res = -1;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (arr[mid] == target) {
                res = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res == -1 ? left : res;
    }

    private int search(int[] arr, int target) {
        return search(arr, 0, arr.length - 1, target);
    }

    /**
     * 要保证 哪怕找不到 也要返回应该在哪个索引中
     *
     * @param arr
     * @param start
     * @param end
     * @param target
     * @return
     */
    private int search(int[] arr, int start, int end, int target) {
        //要小于等于, 如果arr 长度是奇数  小于就行, 但是是偶数 必须小于等于
        while (start <= end) {
            int mid = (start + end) >> 1;
           /*if (arr[mid] == target) {  //有确定值的  不鼓励不给与相等条件的值
                return mid;
            } else*/
            //只有mid 值偏大(当然arr[mid]  偏大)  适合于 end = mid - 1;
            if (arr[mid] >= target) {  // 对于确定值(= 的条件)  只能放于 end 缩小的  情况中
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        //如果target找不到 最后会有start  = end + 1出来
        return start;


        //or
       /* while (start != end - 1) {
            int mid = (start + end) >> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return end;*/
    }


    public int getLessPreIndexAnother(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;

        while (left + 1 < right) {
            mid = (left + right) >> 1;
            if (arr[mid] > target) {
                right = mid;
            } else if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (left < arr.length && arr[left] >= target) {
            return left;
        }

        if (right >= 0 && arr[right] >= target) {
            return right;
        }
        return arr.length;
    }
}
