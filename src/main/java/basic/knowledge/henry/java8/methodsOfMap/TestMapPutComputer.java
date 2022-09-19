package basic.knowledge.henry.java8.methodsOfMap;

import java.util.HashMap;
import java.util.Map;

public class TestMapPutComputer {
    public static void main(String[] args) {
        TestMapPutComputer test = new TestMapPutComputer();
        test.testMap();
        test.testMap2();
        test.testMap3();
        test.testMap4();
    }
    public void testMap() {
        Map<String, String> map = new HashMap<>();
        map.put("a", "A");
        map.put("b", "B");
        String val = map.compute("b", (k, v) -> "B2"); // 返回 B2
        System.out.println(val);
        String v1 = map.compute("c", (k, v) -> "C"); // 返回 C
        System.out.println(v1);
        System.out.println(map);
    }
    public void testMap2() {
        Map<String, String> map = new HashMap<>();
        map.put("a","A");
        map.put("b","B");

        //computeIfAbsent:存在时返回存在的值(旧值)，不存在时返回null
        String v = map.putIfAbsent("b","B2");  // 返回 B ,不更新, b
        System.out.println(v);
        String v1 = map.putIfAbsent("c","C");  // 返回 null,更新
        System.out.println(v1);
        System.out.println(map);
    }
    public void testMap3() {
        Map<String, String> map = new HashMap<>();
        map.put("a","A");
        map.put("b","B");

        //computeIfAbsent:存在时返回存在的值(旧值)，不存在时返回新值
        String v = map.computeIfAbsent("b",k->"B2");  // 返回 B 且不更新
        System.out.println(v);
        String v1 = map.computeIfAbsent("c",k->k+"C"); // 返回 C 更新
        System.out.println(v1);
        System.out.println(map);
    }
    public void testMap4() {
        Map<String, String> map = new HashMap<>();
        map.put("a","A");
        map.put("b","B");
        map.put("c", null);//允许
        map.putIfAbsent("d", null);//允许
        map.compute("e", null);//空指针
        map.computeIfAbsent("f", null);//空指针
    }




}
