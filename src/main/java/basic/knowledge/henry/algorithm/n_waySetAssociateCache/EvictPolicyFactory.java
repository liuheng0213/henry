package basic.knowledge.henry.algorithm.n_waySetAssociateCache;

import basic.knowledge.henry.design_Pattern._03DesignPattern_Factory._02multiMethodsFactory_commonSeen.LzNoodles;

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
