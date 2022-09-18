package basic.knowledge.henry.java8.basicApi;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * reference to:
 * https://mkyong.com/java8/java-8-method-references-double-colon-operator/
 */
public class DoubleColon {
    public static void main(String[] args) {
        //objectMethodConsumer();
        //staticMethodConsumer();

        //repalceFunction();

        //replaceBiFunction();

        replaceComparator();
    }

    private static void replaceComparator() {
        List<Employee> list = Arrays.asList(
                new Employee("mkyong", 38, BigDecimal.valueOf(3800)),
                new Employee("zilap", 5, BigDecimal.valueOf(100)),
                new Employee("ali", 25, BigDecimal.valueOf(2500)),
                new Employee("unknown", 99, BigDecimal.valueOf(9999)));


        ComparatorProvider provider = new ComparatorProvider();

        // lambda
        // list.sort((o1, o2) -> provider.compareBySalary(o1, o2));

        // method reference
        list.sort(provider::compareBySalary);

        list.forEach(x -> System.out.println(x));


        String[] stringArray = {"Barbara", "James", "Mary", "John",
                "Patricia", "Robert", "Michael", "Linda"};
        Arrays.sort(stringArray, String::compareToIgnoreCase);// for String::compareToIgnoreCase 只要属于 :(s1,s2) -> 返回一个int 就行

        for (String str : stringArray) {
            System.out.println(str);
        }
    }

    private static void replaceBiFunction() {
        // anonymous class
        String result1 = playTwoArgument(1, 2, new BiFunction<Integer, Integer, String>() {
            @Override
            public String apply(Integer a, Integer b) {
                return IntegerUtils.join(a, b);
            }
        });                                                                   // 3

        // lambda
        String result2 = playTwoArgument(1, 2, (a, b) -> IntegerUtils.join(a, b));  // 3

        // method reference
        String result3 = playTwoArgument(1, 2, IntegerUtils::join);
    }

    private static void repalceFunction() {
        List<String> list = Arrays.asList("1", "2", "3");

        // anonymous class
        List<Integer> collect1 = list.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                })
                .collect(Collectors.toList());

        // lambda expression
        List<Integer> collect2 = list.stream()
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList());

        // method reference
        List<Integer> collect3 = list.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

    private static void staticMethodConsumer() {
        List<String> list = Arrays.asList("A", "B", "C");

        // anonymous class
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String x) {
                SimplePrinter.print(x);
            }
        });

        // lambda expression
        list.forEach(x -> SimplePrinter.print(x));

        // method reference
        list.forEach(SimplePrinter::print);
    }

    private static void objectMethodConsumer() {

        List<String> list1 = Arrays.asList("node", "java", "python", "ruby");

        list1.forEach(new Consumer<String>() {       // anonymous class ,consumer 的accept有参数,不返回值
            @Override
            public void accept(String str) {
                System.out.println(str);
            }
        });

        List<String> list2 = Arrays.asList("node", "java", "python", "ruby");
        list2.forEach(str -> System.out.println(str)); // lambda

        List<String> list3 = Arrays.asList("node", "java", "python", "ruby");
        list3.forEach(System.out::println);          // method references


    }

    private static <R> R playTwoArgument(Integer i1, Integer i2,
                                         BiFunction<Integer, Integer, R> func) {
        return func.apply(i1, i2);
    }

    static class SimplePrinter {
        public static void print(String str) {
            System.out.println(str);
        }
    }


    static class IntegerUtils {

        public static String join(Integer a, Integer b) {
            return String.valueOf(a + b);
        }

    }

    static class ComparatorProvider {

        public int compareByAge(Employee o1, Employee o2) {
            return o1.getAge().compareTo(o2.getAge());
        }

        public int compareByName(Employee o1, Employee o2) {
            return o1.getName().compareTo(o2.getName());
        }

        public int compareBySalary(Employee o1, Employee o2) {
            return o1.getAge().compareTo(o2.getAge());
        }

    }
}
