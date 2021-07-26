package basic.knowledge.stephen.java8.lambda.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComTest {
    public static void main(String[] args) {
        //sortByName(getEmployees());
        //sortOnMultipleFields(getEmployees());
        parallelSort(getEmployees());
    }

    private static void parallelSort(List<Employee> employees) {
        Employee[] employeesArray = employees.toArray(new Employee[employees.size()]);
        //Sorting on multiple fields; Group by.
        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getName);

        //Parallel sorting
        Arrays.parallelSort(employeesArray, groupByComparator);

        //Let's print the sorted list
        for (Employee employee : employeesArray) {
            System.out.println(employee);
        }
    }

    private static void sortOnMultipleFields(List<Employee> employees) {

        //Sorting on multiple fields; Group by.
        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getAge)
                .thenComparing(Employee::getName);
        employees.sort(groupByComparator);
        //Let's print the sorted list
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void sortByName(List<Employee> employees) {
        //Sort all employees by first name
        //employees.sort(Comparator.comparing(e -> e.getName()));

        //OR you can use below
        employees.sort(Comparator.comparing(Employee::getAge).reversed());

        //Let's print the sorted list
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }


    private static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(5, "c", 19));
        employees.add(new Employee(4, "d", 72));
        employees.add(new Employee(7, "b", 88));
        employees.add(new Employee(8, "a", 88));
        employees.add(new Employee(6, "a", 25));
        employees.add(new Employee(2, "b", 25));
        employees.add(new Employee(3, "a", 52));
        employees.add(new Employee(1, "e", 32));
        employees.add(new Employee(9, "d", 33));
        employees.add(new Employee(10, "c", 60));
        return employees;
    }


}
