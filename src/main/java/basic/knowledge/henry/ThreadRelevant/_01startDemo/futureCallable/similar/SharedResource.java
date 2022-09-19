package basic.knowledge.henry.ThreadRelevant._01startDemo.futureCallable.similar;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedResource {
    Map<String, String> map = new ConcurrentHashMap<>();
}
