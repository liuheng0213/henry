package basic.knowledge.henry.javaCollections.HashSet;

import basic.knowledge.henry.javaCollections.entity.Person;

import java.util.HashSet;
import java.util.LinkedList;

public class HashSetTest {
    public static void main(String[] args) {

        HashSet<Person> set = new HashSet<>();

        set.add(new Person("1",24));
        set.add(new Person("2",56));
        set.add(new Person("2",56));

        set.add(new Person("1",24));
        HashSet<Person> se2 = new HashSet<>();

        se2.add(new Person("4",56));
        se2.add(new Person("5",24));
        System.out.println(se2.contains(new Person("4",76))); //false

        boolean b = set.containsAll(se2);
        System.out.println(b);

        HashSet<Integer> intSet = new HashSet<>();
        boolean add = intSet.add(1);
        boolean add2 = intSet.add(1);
        System.out.println();
        for (Person p:
                set ) {
            System.out.println(p.toString());
        }

        LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(new Person("4",56));
        boolean equals = linkedList.peekLast().equals(new Person("5", 56));
        linkedList.peekLast().setAge(30);

        System.out.println(equals);
    }
}
