package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.rateLimiter;

public class TokenBucket {
    private double capacity;// 令牌容量，桶内能容纳的令牌数
    private double rate;// 令牌增加速率，每毫秒增加的可用令牌数

    private double lastSize;// 上次获得令牌之后，桶内的剩余可用令牌数
    private long lastAcquireTime;// 上次获得令牌的时间

    /**
     * @param capacity 令牌容量，桶内能容纳的令牌数
     * @param rate     令牌增加速率，每毫秒增加的可用令牌数
     */
    public TokenBucket(double capacity, double rate) {
        this.capacity = capacity;
        this.rate = rate;
    }

    /**
     * 请求令牌
     *
     * @param number 所需令牌数
     * @return true表示请求成功，false表示请求失败
     */
    public synchronized boolean acquire(double number) {
        long now = System.currentTimeMillis();
        double currentSize = calculateSize(now);// 当前可用令牌数
        if (number > currentSize) {// 令牌不够用
            return false;
        }
        lastSize = currentSize - number;// 减去所需令牌数，记录剩余可用令牌数
        lastAcquireTime = now;// 记录时间
        return true;
    }

    /**
     * 计算当前可用令牌数
     *
     * @param now
     * @return
     */
    private double calculateSize(long now) {
        if (lastAcquireTime <= 0) {// 未获得过令牌
            return capacity;// 当前可用令牌数直接就等于令牌容量
        }
        long interval = now - lastAcquireTime;// 计算距离上次获得令牌的时间间隔
        return Math.min(capacity, lastSize + rate * interval);// 计算当前可用令牌数
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(10, 0.002);
        long totalCount = 0, successCount = 0;
        while (true) {
            totalCount++;
            if (tokenBucket.acquire(1)) {
                successCount++;
                System.out.printf("%s\t%s\t%s\n", System.currentTimeMillis(), successCount, totalCount);
            }
        }
    }
}
