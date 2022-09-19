package basic.knowledge.henry.algorithm.twice_InterverviewFromRenowedITCompany._06bigDatAndSpaceLimitaion;

import basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._06bigDatAndSpaceLimitaion.BloomFilter;
import basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._06bigDatAndSpaceLimitaion.JavaBitSet;

public class JavaBitSetTest {

    public static void main(String[] args) {
        //(falsePositiveProbability, expectedNumberOfElements)
        basic.knowledge.henry.algorithm.InterverviewFromRenowedITCompany._06bigDatAndSpaceLimitaion.BloomFilter<String> filter = new BloomFilter<String>(0.0001, 10000);
        filter.bind(new JavaBitSet());

        filter.add("filter");
        System.out.println(filter.contains("filter"));
        System.out.println(filter.contains("bloom"));
        filter.add("bitset");
        filter.add("redis");
        System.out.println(filter.contains("bitset"));
        System.out.println(filter.contains("redis"));
        System.out.println(filter.contains("mysql"));
        System.out.println(filter.contains("linux"));
        System.out.println(filter.count());
        System.out.println(filter.isEmpty());
        filter.clear();
        System.out.println(filter.isEmpty());
        System.out.println(filter.contains("filter"));

        /**
         Test results:
         true
         false
         true
         true
         false
         false
         3
         false
         true
         false
         */

    }

}