package basic.knowledge.henry.algorithm.InterviewExperience.Atlassian.rateLimiter;

public class TokenBucket_twice {
    double capacity;
    double lastSize;

    double rate;

    long lastAcquireTime;

    public TokenBucket_twice(double capacity,double rate){
        this.capacity= capacity;
        this.rate =rate;
    }

    public boolean acquire(int number){
        long currentTime = System.currentTimeMillis();

        double size = calculateSize(currentTime);

        if(size < number){
            return false;
        }
        lastSize = size - number;
        lastAcquireTime = currentTime;
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
        TokenBucket_twice tokenBucket = new TokenBucket_twice(10, 0.002);
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
