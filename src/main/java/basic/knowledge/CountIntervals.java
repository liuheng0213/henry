package basic.knowledge;

import java.util.Iterator;
import java.util.TreeSet;

public class CountIntervals {

    public static void main(String[] args) {
        CountIntervals countIntervals = new CountIntervals();

//        countIntervals.add(571,770);
//        countIntervals.add(920,996);
//        countIntervals.add(65,512);
//
//        System.out.println();
//        countIntervals.add(959,959);
//        System.out.println();
//        countIntervals.add(313,330);
//        System.out.println();
//        countIntervals.add(473,928);

//        countIntervals.add(2,3);
//        countIntervals.add(7,10);
//        countIntervals.add(5,8);

        countIntervals.add(5,10);
        countIntervals.add(5,10);
        System.out.println(countIntervals.count());


    }
    TreeSet<int[]> intervals = null;
    int count = 0;
    public CountIntervals() {
        this.intervals = new TreeSet<>((o1,o2)->o1[0] - o2[0]);
    }

    public void add(int left, int right) {

        int[] interval = new int[]{left,right};
        if(!this.intervals.add(interval)){
            return;
        }

        ;

        int[] lower = this.intervals.lower(interval);
        int[] higher = this.intervals.higher(interval);



        if((lower == null || lower[1] < interval[0]) && (higher == null || higher[0] > interval[1])){
            this.count += interval[1] - interval[0] + 1;
        }else{
            int min = interval[0];
            int max = interval[1];
            while(true){


                min = interval[0];
                max = interval[1];
                if(lower != null && lower[1] >= interval[0]){
                    min = Math.min(lower[0],min);
                    max = Math.max(lower[1],max);

                    count-= lower[1] - lower[0] + 1;
                    this.intervals.remove(lower);
                }
                if(higher != null && higher[0] <= interval[1]){
                    min = Math.min(higher[0],min);
                    max = Math.max(higher[1],max);
                    count-= higher[1] - higher[0] + 1;
                    this.intervals.remove(higher);
                }
                this.intervals.remove(interval);

                interval = new int[]{min,max};
                if(!this.intervals.add(interval)){
                    return;
                }


                lower = this.intervals.lower(interval);
                higher = this.intervals.higher(interval);
                if((lower == null || lower[1] < interval[0]) && (higher == null || higher[0] > interval[1])){
                    break;
                }
            }

            this.count += max - min + 1;

        }


    }

    public int count() {
        return this.count;
    }
}
