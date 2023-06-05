package basic.knowledge.henry.java8.basicApi;


import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * reference to
 * https://stackify.com/streams-guide-java-8/
 */
public class TypicalUsage {
    public static void main(String[] args) {
//        mapAndFilter();
//
//        mapToInt();
//
//        findFirst();
//
//        flapMap();
//
        peekDemo();
//
//        skipAndLimit();
//
//        reduceDemo();
//
//        collectorsUsage();
//
//        summarizingDouble();
//
//        partitioningBy();
//
//        groupBy();
//
//        mappingAndFilter();
//
//        groupAndReduce();
//
//        generateDemo();
//
//        iterateDemo();
//
//        sortedDemo();

        //      GetIndex();

    }

    private static void GetIndex() {
        String[] my_array = {"T", "h", "i", "s", "s", "a", "m", "p", "l", "e"};
        AtomicInteger my_index = new AtomicInteger();

        System.out.println("字符串数组中的元素是:");

        Stream<String> stringStream = Arrays.stream(my_array).map(str -> my_index.getAndIncrement() + " -> " + str);
        stringStream.forEach(System.out::println);


    }

    private static void sortedDemo() {
    }

    /**
     * iterate() takes two parameters: an initial value, called seed element
     * and a function which generates next element using the previous value. iterate(),
     * by design, is stateful and hence may not be useful in parallel streams:
     */
    private static void iterateDemo() {

        Stream<Integer> evenNumStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = evenNumStream
                .limit(5)
                .collect(Collectors.toList());

        assertEquals(collect, Arrays.asList(2, 4, 8, 16, 32));

    }

    private static void generateDemo() {
        //generate is infinite , but we can control number by limit
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    private static void groupAndReduce() {

        Employee_2[] arrayOfEmps = {
                new Employee_2(1, "Jeff Bezos", 100000.0),
                new Employee_2(2, "Jeff Be", 100000.0),
                new Employee_2(3, "Bill Gates", 200000.0),
                new Employee_2(4, "Bill Gates haha", 200000.0),
                new Employee_2(5, "Mark Zuckerberg", 300000.0),
                new Employee_2(6, "Mark Zuckerberg12", 300000.0),
                new Employee_2(7, "Mark Zuckerberg3456", 300000.0),
        };

        List<Employee_2> empList = Arrays.asList(arrayOfEmps);
        Comparator<Employee_2> byNameLength = Comparator.comparing(Employee_2::getName);

        Map<Character, Optional<Employee_2>> longestNameByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e -> new Character(e.getName().charAt(0)),
                        Collectors.reducing(BinaryOperator.maxBy(byNameLength))));

        assertEquals(longestNameByAlphabet.get('B').get().getName(), "Bill Gates haha");
        assertEquals(longestNameByAlphabet.get('J').get().getName(), "Jeff Bezos");
        assertEquals(longestNameByAlphabet.get('M').get().getName(), "Mark Zuckerberg3456");
    }

    private static void mappingAndFilter() {
        Map<Integer, String> A_MAP_EXAMPLE = new HashMap<>();

        //Map -> Stream -> Filter -> String
        String result = A_MAP_EXAMPLE.entrySet().stream()
                .filter(map -> "something".equals(map.getValue()))
                .map(map -> map.getValue())
                .collect(Collectors.joining());

        //Map -> Stream -> Filter -> MAP
        Map<Integer, String> collect = A_MAP_EXAMPLE.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));
    }

    private static void groupBy() {
        Employee_2[] arrayOfEmps = {
                new Employee_2(1, "Jeff Bezos", 100000.0),
                new Employee_2(2, "Bill Gates", 200000.0),
                new Employee_2(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee_2> empList = Arrays.asList(arrayOfEmps);
        Map<Character, List<Employee_2>> groupByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e -> new Character(e.getName().charAt(0))));

        assertEquals(groupByAlphabet.get('B').get(0).getName(), "Bill Gates");
        assertEquals(groupByAlphabet.get('J').get(0).getName(), "Jeff Bezos");
        assertEquals(groupByAlphabet.get('M').get(0).getName(), "Mark Zuckerberg");


        // groupBy and mapping, groupingBy 方法有两个参数
        /**
         * groupingBy() discussed in the section above, groups elements of the stream with the use of a Map.

         However, sometimes we might need to group data into a type other than the element type.
         */
        Map<Character, List<Integer>> idGroupedByAlphabet = empList.stream().collect(
                Collectors.groupingBy(e -> e.getName().charAt(0),
                        Collectors.mapping(Employee_2::getId, Collectors.toList())));


        assertEquals(idGroupedByAlphabet.get('B').get(0), new Integer(2));
        assertEquals(idGroupedByAlphabet.get('J').get(0), new Integer(1));
        assertEquals(idGroupedByAlphabet.get('M').get(0), new Integer(3));
    }

    private static void partitioningBy() {
        List<Integer> intList = Arrays.asList(2, 4, 5, 6, 8);
        Map<Boolean, List<Integer>> isEven = intList.stream().collect(
                Collectors.partitioningBy(i -> i % 2 == 0));

        assertEquals(isEven.get(true).size(), 4);
        assertEquals(isEven.get(false).size(), 1);
    }

    private static void summarizingDouble() {
        Employee_2[] arrayOfEmps = {
                new Employee_2(1, "Jeff Bezos", 100000.0),
                new Employee_2(2, "Bill Gates", 200000.0),
                new Employee_2(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee_2> empList = Arrays.asList(arrayOfEmps);

        // two options:
        //1
        DoubleSummaryStatistics stats1 = empList.stream()
                .collect(Collectors.summarizingDouble(Employee_2::getSalary));

        // 2
        DoubleSummaryStatistics stats2 = empList.stream()
                .mapToDouble(Employee_2::getSalary)
                .summaryStatistics();

        assertEquals(stats1.getCount(), 3);
        assertEquals(stats1.getSum(), 600000.0, 0);
        assertEquals(stats2.getMin(), 100000.0, 0);
        assertEquals(stats2.getMax(), 300000.0, 0);
        assertEquals(stats2.getAverage(), 200000.0, 0);
    }

    private static void collectorsUsage() {
        Employee_2[] arrayOfEmps = {
                new Employee_2(1, "Jeff Bezos", 100000.0),
                new Employee_2(2, "Bill Gates", 200000.0),
                new Employee_2(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee_2> empList = Arrays.asList(arrayOfEmps);
        String empNames = empList.stream()
                .map(Employee_2::getName)
                .collect(Collectors.joining(", "))
                .toString();

        assertEquals(empNames, "Jeff Bezos, Bill Gates, Mark Zuckerberg");

        Set<String> empNameSet = empList.stream()
                .map(Employee_2::getName)
                .collect(Collectors.toSet());

        assertEquals(empNameSet.size(), 3);


        Vector<String> empNamesVector = empList.stream()
                .map(Employee_2::getName)
                .collect(Collectors.toCollection(Stack::new));

        assertEquals(empNamesVector.size(), 3);
    }

    private static void mapToInt() {
        Employee_2[] arrayOfEmps = {
                new Employee_2(1, "Jeff Bezos", 100000.0),
                new Employee_2(2, "Bill Gates", 200000.0),
                new Employee_2(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee_2> empList = Arrays.asList(arrayOfEmps);
        Integer latestEmpId = empList.stream()
                .mapToInt(Employee_2::getId) //getId 必须是Employee_2 里的方法
                .max()
                .orElseThrow(NoSuchElementException::new);

        assertEquals(latestEmpId, new Integer(3));
    }


    /**
     *
     */
    private static void reduceDemo() {
        Employee_2[] arrayOfEmps = {
                new Employee_2(1, "Jeff Bezos", 100000.0),
                new Employee_2(2, "Bill Gates", 200000.0),
                new Employee_2(3, "Mark Zuckerberg", 300000.0)
        };
        List<Employee_2> empList = Arrays.asList(arrayOfEmps);
        Double sumSal = empList.stream()
                .map(Employee_2::getSalary)//getSalary 必须是Employee_2 里的方法
                .reduce(0.0, Double::sum);//sum 是Double 里的方法

        assertEquals(sumSal, new Double(600000));


        Double percentage = 10.0;
        // reducing =先identiy,  再map ,再reduce
        Double salIncrOverhead = empList.stream().collect(Collectors.reducing(
                0.0, e -> e.getSalary() * percentage / 100, (s1, s2) -> s1 + s2));

        assertEquals(salIncrOverhead, 60000.0, 0);

    }

    private static void skipAndLimit() {

        Stream<Integer> infiniteStream = Stream.iterate(2, i -> i * 2);

        List<Integer> collect = infiniteStream
                .skip(3) //前三次忽略2,4,8 忽略
                .limit(5) // 最多5个数
                .collect(Collectors.toList());

        assertEquals(collect, Arrays.asList(16, 32, 64, 128, 256));
    }

    private static void peekDemo() {
        Employee_2[] arrayOfEmps = {
                new Employee_2(1, "Jeff Bezos", 100000.0),
                new Employee_2(2, "Bill Gates", 200000.0),
                new Employee_2(3, "Mark Zuckerberg", 300000.0)
        };

        List<Employee_2> empList = Arrays.asList(arrayOfEmps);

        empList.stream()
                .peek(e -> e.salaryIncrement(10.0))
                .peek(System.out::println)
                .collect(Collectors.toList());

        //empList.forEach(System.out::println);

    }

    private static void flapMap() {
        List<List<String>> namesNested = Arrays.asList(
                Arrays.asList("Jeff", "Bezos"),
                Arrays.asList("Bill", "Gates"),
                Arrays.asList("Mark", "Zuckerberg"));

        List<String> namesFlatStream = namesNested.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        namesFlatStream.forEach(System.out::println);
    }

    private static void findFirst() {
        Integer[] empIds = {1, 2, 3, 4};

//        Employee employee = Stream.of(empIds)
//                .map(employeeRepository::findById)
//                .filter(e -> e != null)
//                .filter(e -> e.getSalary() > 100000)
//                .findFirst()
//                .orElse(null);
    }

    private static void mapAndFilter() {
        Integer[] empIds = {1, 2, 3, 4};


        /**
         * employeeRepository  is a instance in dao
         */
        //     List<Employee_2> employees = Stream.of(empIds)
//                .map(employeeRepository::findById)
//                .filter(e -> e != null)
//                .filter(e -> e.getSalary() > 200000)
//                .collect(Collectors.toList());
    }


}
