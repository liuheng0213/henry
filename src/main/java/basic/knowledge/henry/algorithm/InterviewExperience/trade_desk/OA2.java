package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Imagine an exclusive event that many people wish to attend. The event starts at time 0. For every person attending,
 * you are given a time in seconds (since the start time of the event) representing when they arrived at the event.
 * However, entry into this event requires an identification check which takes time, so people may wait in the queue to enter.
 * Specifically, it takes 5 minutes to do an ID check for every attendee.
 * Additionally, if the person arrives at the event and sees that there are more than 10 people in the queue, they leave immediately.
 *
 * Your task is to return an array of integers representing the time when each person will be processed and their ID check completed.
 * The time should be in seconds since the start time of the event.
 * If a person leaves immediately upon arrival, this time should be the same as their arrival time.
 *
 * Notes:
 *
 * The queue size is calculated by the number of people waiting to start their ID check, not including the person who is already in the process of ID check.
 * If a new person arrives at the same moment as when another person completes their ID check, the first person waiting in the queue should have their ID checked first, and the new person should wait in the queue.
 * Note: You are not expected to provide the most optimal solution, but a solution with time complexity not worse than O(times.length2) will fit within the execution time limit.
 *
 * Example
 *
 * For times = [4, 400, 450, 500,2000], the output should be solution(times) = [304, 700, 1000, 1300].
 *
 * Let consider this scenario:
 *
 * The first person arrives at time 4, and there is no one in the queue, so they immediately start their ID check. Queue - [].
 * The first person finishes their ID check at time 304. Queue - [].
 * The second person arrives at time 400, and there is no one in the queue, so they immediately start their ID check. Queue - [].
 * The third person arrives at time 450, but there is one person getting their ID checked, so they wait in the queue. Queue - [3].
 * The fourth person arrives at time 500, and there is one person in the queue, so they wait in the queue. Queue - [3, 4].
 * The second person finishes their ID check at time 700, and the next person in queue (person 3) starts their ID check. Queue - [4].
 * The third person finishes their ID check at time 1000, and the next person in queue (person 4) starts their ID check. Queue - [].
 * The fourth (and the last) person finishes their ID check at time 1300.
 * For times = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15], the output should be
 * solution(times) = [301, 601, 901, 1201, 1501, 1801, 2101, 2401, 2701, 3001, 3301, 3601, 13, 14, 15].
 *
 * Initially, the first person arrives at time 1 and starts their ID check.
 * The next 11 people arrive at the event and wait in the queue for their ID check.
 * The last three people immediately leave, as they see more than 10 people in the queue.
 */
public class OA2 {
    public static void main(String[] args) {
        OA2 test = new OA2();
        Queue<Integer> queue = new LinkedList<>();

        int[] nums = new int[]{4, 200,400, 450, 500,505,700,1500,1700,2000};
        int[] res = test.processGuests2(nums);
        int[] res1 = test.processGuests(nums);
        System.out.println(Arrays.toString(res));  // [304, 700, 1000, 1300, 2300]
        System.out.println(Arrays.toString(res1));  // [304, 700, 1000, 1300, 2300]
    }

    public int[] processGuests2(int[] nums) {
        int n = nums.length;
        //initiate the out array
        int[] out = new int[n];

        LinkedList<Integer> queue = new LinkedList<>();
        int processingIndex = 0;
        for(int i = 0; i< n; i++){
            if(queue.size() > 10) {
                out[i] = nums[i];
                continue;
            }
            // is not in the status of processing ,
            if(out[processingIndex] <= nums[i]){
                //need to see if the queue can poll out or not
                while(!queue.isEmpty()&&  out[processingIndex] <= nums[i]){
                    int id = queue.pollFirst();
                    out[id] = out[processingIndex] + 300;
                    processingIndex = id;
                }
                // now queue.isEmpty() or out[processingIndex] > nums[i]

                //then starts to process i;
                if(queue.isEmpty() && out[processingIndex] <= nums[i]){
                    processingIndex= i;
                    out[i] = nums[i] + 300;
                }else if(queue.isEmpty() && out[processingIndex] > nums[i]){
                    queue.addLast(i);
                }else { //!queue.isEmpty() && out[processingIndex] > nums[i]
                    queue.addLast(i);
                }

            }else{     // is in the status of processing, adding i to queue directly
                queue.addLast(i);
            }
        }

        while(!queue.isEmpty()){
            int idx = queue.pollFirst();
            out[idx] = out[processingIndex]  + 300;
            processingIndex = idx;
        }

        return out;
    }
    public int[] processGuests(int[] nums) {
        nums[0] += 300;
        int inQ = 1;
        int processingIndex = 0;
        for(int i = 1; i< nums.length; i++){
            if(inQ > 11) continue;
            if(nums[i] < nums[i-1]){
                inQ++;
                nums[i] = nums[i-1] + 300;
            } else {
                nums[i] += 300;
                while(nums[i] >= nums[processingIndex] && inQ >=0) {
                    processingIndex++;
                    inQ--;
                }
            }
        }

        return nums;
    }
}
