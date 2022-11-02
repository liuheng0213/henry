package basic.knowledge.henry.algorithm.leetcode.Design;


import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/discuss/interview-question/279913/key-value-store-with-transaction
public class TransactionMap {
    Map<Integer, Integer> globalMap = new HashMap<>();
    Map<Integer, Integer> tmpMap = new HashMap<>();
    int status = 0;

//    Begin
//    Commit
//    Rollback


    public void begin() {
        status = 0;
    }

    public void rollback() {
        tmpMap.clear();
        status = 1;
    }

    public void commit() {
        for(Map.Entry<Integer,Integer> entry : tmpMap.entrySet()){
            this.globalMap.put(entry.getKey(),entry.getValue());
        }
        status = 1;
    }

    public int get(int key) {
        if (status == 0 && tmpMap.containsKey(key)) {
            return getFromTmp(key);
        } else {
            return getFromGlobal(key);
        }
    }

    public void set(int key, int val) {
        if (status == 0) {
            tmpMap.put(key, val);
        }
    }


    private int getFromGlobal(int key) {
        if (!globalMap.containsKey(key)) {
            return Integer.MIN_VALUE;
        } else {
            return globalMap.get(key);
        }
    }

    private int getFromTmp(int key) {
        if (!tmpMap.containsKey(key)) {
            throw new RuntimeException();
        } else {
            return tmpMap.get(key);
        }
    }


}
