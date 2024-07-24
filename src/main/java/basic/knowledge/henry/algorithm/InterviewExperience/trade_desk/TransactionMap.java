package basic.knowledge.henry.algorithm.InterviewExperience.trade_desk;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

//https://leetcode.com/discuss/interview-question/279913/key-value-store-with-transaction
//backup
public class TransactionMap {
    // get -> just return from the store
    // begin -> just adds a new hashMap to the stack
    // Commit -> take all the stuff in transactional Stack and dump it into store
    // Rollback -> clears transactional stack
    // Set -> updates the transactional stack but not the store.
    // delete -> remove from store if not part of transaction, else remove the key from curr transaction.

    Map<String, String> store;
    Stack<Map<String, String>> transactionalStack;

    TransactionMap () {
        store = new HashMap<>();
        transactionalStack = new Stack<>();
    }

    void begin() {
        transactionalStack.push(new HashMap<>());
    }

    String get(String key) {
        if (store.isEmpty() || !store.containsKey(key)) {
            return null;
        }

        return store.get(key);
    }

    void set(String key, String val) {
        if (transactionalStack.isEmpty()) {
            store.put(key, val);
            return;
        }

        Map<String, String> curr = transactionalStack.peek();
        curr.put(key, val);
    }

    void commit() {
        if (transactionalStack.isEmpty()) {
            throw new RuntimeException("Stack is empty nothing to commit");
        }
        Map<String, String> curr = transactionalStack.pop();
        store.putAll(curr);
    }

    void rollback() {
        if (transactionalStack.isEmpty()) {
            throw new RuntimeException("Nothing to rollback");
        }
        transactionalStack.pop();
    }

    void delete (String key) {
        if (!transactionalStack.isEmpty()) {
            store.remove(key);
        }
        transactionalStack.peek().remove(key);
    }


}
