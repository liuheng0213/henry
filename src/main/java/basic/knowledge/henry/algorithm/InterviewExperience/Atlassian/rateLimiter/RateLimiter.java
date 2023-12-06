package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.rateLimiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//This example limits a customer to 5 requests every 10 seconds.
public class RateLimiter {
    private Map<String, LinkedList<Long>> requestInfoMap = new HashMap<>();
    private static final int REQUEST_LIMIT = 5; // Adjust this limit as needed
    private static final long TIME_LIMIT_MILLIS = 10000; // Adjust this limit as needed (e.g., 10 seconds)

    public boolean rateLimit(String customerId) {
        long currentTime = System.currentTimeMillis();

        if (!requestInfoMap.containsKey(customerId)) {
            // If customer is making the first request, initialize the timestamp and count
            LinkedList<Long> list = new LinkedList<>();
            list.add(currentTime);
            requestInfoMap.put(customerId, list);
            return true;
        }

        LinkedList<Long> count = requestInfoMap.get(customerId);
        Long limit_start = currentTime - TIME_LIMIT_MILLIS;
        while (!count.isEmpty() && count.peekFirst() < limit_start) { // do not use if
            count.pollFirst();
        }
        if (count.size() < REQUEST_LIMIT) {
            // If the time limit has passed since the last request, reset the timestamp and count
            count.add(currentTime);
            return true;
        }else{
            // Customer has exceeded the request limit
            return false;
        }


    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter();

        // Simulate requests
        String customerId = "exampleCustomerId";
        for (int i = 0; i < 20; i++) {
            boolean allowed = rateLimiter.rateLimit(customerId);
            Thread.sleep(1000);
            System.out.println("Request " + (i + 1) + ": " + (allowed ? "Allowed" : "Rate Limited"));
        }
    }


}
