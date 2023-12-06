package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.rateLimiter;

import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindowRateLimiter {
    private final int maxRequests;
    private final long windowMillis;
    private final AtomicInteger requestCount;
    private volatile long windowStart;

    public FixedWindowRateLimiter(int maxRequests, long windowSeconds) {
        this.maxRequests = maxRequests;
        this.windowMillis = windowSeconds * 1000; // Convert seconds to milliseconds
        this.requestCount = new AtomicInteger(0);
        this.windowStart = System.currentTimeMillis();
    }

    public boolean allowRequest() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - windowStart;

        // Reset the window if the time window has passed
        if (elapsedTime > windowMillis) {
            windowStart = currentTime;
            requestCount.set(0);
        }

        // Check if the number of requests is within the allowed limit
        return requestCount.incrementAndGet() <= maxRequests;
    }

    public static void main(String[] args) {
        // Example usage
        FixedWindowRateLimiter rateLimiter = new FixedWindowRateLimiter(5, 60); // Allow 5 requests per minute

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
