package basic.knowledge.stephen.java8.mapNewMethods;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        //putIfAbsent  donot override original value
        String haha = map.putIfAbsent(1, "haha1");
        String haha2 = map.putIfAbsent(2, "haha2");
        String haha3 = map.putIfAbsent(1, "haha11");
        String haha4 = map.putIfAbsent(3, "haha13");


        HashMap<Integer, String> map1 = new HashMap<>();
        String kaka = map1.computeIfAbsent(1, key -> "kaka");
        String kaka1 = map1.computeIfAbsent(2, key -> "kaka1");
        String kaka2 = map1.computeIfAbsent(1, key -> "kaka2");
        String kaka3 = map1.computeIfAbsent(3, key -> "kaka3");


        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1, "haha1");
        map2.put(2, "haha2");
        map2.put(1, "haha11");


        String dd = map.getOrDefault(1, "dd");//haha1
        String dd1 = map.getOrDefault(4, "dd");//dd

        System.out.println();

    }
}
