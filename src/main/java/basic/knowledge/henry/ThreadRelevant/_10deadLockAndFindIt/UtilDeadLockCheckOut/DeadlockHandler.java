package basic.knowledge.henry.ThreadRelevant._10deadLockAndFindIt.UtilDeadLockCheckOut;

import java.lang.management.ThreadInfo;

public interface DeadlockHandler {
    void handleDeadlock(final ThreadInfo[] deadlockedThreads);
}
