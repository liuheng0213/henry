package basic.knowledge.henry.javaCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestConstrcutor {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> hashSet = new LinkedHashSet<>();

        ArrayList<Integer> arrayList = new ArrayList<>(list);

        LinkedHashSet<Integer> integers = new LinkedHashSet<>(list);
        

        TreeSet<Double> treeSet = new TreeSet<>();
        treeSet.add(1.2);
        treeSet.add(4.4);
        treeSet.add(3.4);
        treeSet.add(2.4);
        Double ceiling = treeSet.ceiling(3.2);
        Double lower = treeSet.lower(3.2);
        Double aDouble = treeSet.pollLast();
        System.out.println(aDouble);
        Double first = treeSet.first();
        System.out.println(first);

        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
//        System.out.println(ceiling);
//        System.out.println(lower);

        Map<Integer,Integer> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();

        Set<Integer> integers1 = map.keySet();
        Iterator<Integer> iterator1 = integers1.iterator();
    }
}
