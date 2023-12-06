package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.rateLimiter;

import java.util.ArrayDeque;
import java.util.Queue;

public class SlidingWindowRateLimiter {
    private final int maxRequests;
    private final long windowMillis;
    private final Queue<Long> requestTimes;

    public SlidingWindowRateLimiter(int maxRequests, long windowSeconds) {
        this.maxRequests = maxRequests;
        this.windowMillis = windowSeconds * 1000; // Convert seconds to milliseconds
        this.requestTimes = new ArrayDeque<>();
    }

    public synchronized boolean allowRequest() {
        long currentTime = System.currentTimeMillis();

        // Remove requests that are outside the sliding window
        while (!requestTimes.isEmpty() && requestTimes.peek() < currentTime - windowMillis) {
            requestTimes.poll();
        }

        // Check if the number of requests is within the allowed limit
        if (requestTimes.size() < maxRequests) {
            // Allow the request and add the current time to the queue
            requestTimes.offer(currentTime);
            return true;
        } else {
            // Deny the request, as it exceeds the allowed rate
            return false;
        }
    }

    public static void main(String[] args) {
        // Example usage
        SlidingWindowRateLimiter rateLimiter = new SlidingWindowRateLimiter(5, 60); // Allow 5 requests per minute

        for (int i = 0; i < 20; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("Request " + (i + 1) + ": Allowed" + System.currentTimeMillis());
            } else {
                System.out.println("Request " + (i + 1) + ": Denied"+ System.currentTimeMillis());
            }

            try {
                // Simulate a delay between requests
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
