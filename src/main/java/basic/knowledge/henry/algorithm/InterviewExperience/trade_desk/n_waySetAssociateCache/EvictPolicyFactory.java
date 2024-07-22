package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk.n_waySetAssociateCache;

public class EvictPolicyFactory {
    public static LRUEvictPolicy createLRUEvictPolicy() {
        return new LRUEvictPolicy<>();
    }

    public static LFUEvictPolicy createLFUEvictPolicy() {
        return new LFUEvictPolicy();
    }

    public static MRUEvictPolicy createMRUEvictPolicy() {
        return new MRUEvictPolicy();
    }
}
