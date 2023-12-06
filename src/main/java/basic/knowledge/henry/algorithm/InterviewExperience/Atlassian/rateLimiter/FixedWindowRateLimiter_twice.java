package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.rateLimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter_twice {

    long startTime;
    long windowMillis;
    int maxRequests;
    AtomicInteger requestCount;

    public FixedWindowRateLimiter_twice(int maxRequests, long windowSeconds) {
        this.maxRequests = maxRequests;
        this.windowMillis = windowSeconds * 1000;
        this.startTime = System.currentTimeMillis();
        requestCount = new AtomicInteger(0);
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        long diff = currentTime - startTime;
        if(diff > windowMillis){
            startTime = currentTime;
            requestCount.set(0);
        }
        return requestCount.incrementAndGet() <= maxRequests;
    }

    public static void main(String[] args) {
        // Example usage
        FixedWindowRateLimiter_twice rateLimiter = new FixedWindowRateLimiter_twice(5, 10); // Allow 5 requests per minute

        for (int i = 0; i < 20; i++) {
            if (rateLimiter.allowRequest()) {
                System.out.println("Request " + (i + 1) + ": Allowed");
            } else {
                System.out.println("Request " + (i + 1) + ": Denied");
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
