package basic.knowledge.henry.java8.excercise_1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class Excercise {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(alan, 2011, 700),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );
        // 找出2011年发生的所有交易，并按交易额聪小到大排序
        List<Transaction> collect1 = transactions.stream()
                .filter(transaction -> 2011 == transaction.getYear())
                .sorted(comparing(Transaction::getValue)).collect(Collectors.toList());

        System.out.println("找出2011年发生的所有交易，并按交易额聪小到大排序 方法1 " + collect1);

        //找出2011年发生的所有交易，并按交易额聪小到大排序 第二种方式  Transaction 定义新方法 类似Arrays.sort(stringArray, String::compareToIgnoreCase);
        List<Transaction> collect2 = transactions.stream()
                .filter(transaction -> 2011 == transaction.getYear())
                .sorted(Transaction::compareByValue).collect(Collectors.toList());

        System.out.println("找出2011年发生的所有交易，并按交易额聪小到大排序 方法2 " + collect2);

        // 找出2011年发生的所有交易，并按交易额聪大到小排序 ,
        ComparatorProvider provider = new ComparatorProvider();
        List<Transaction> collect3 = transactions.stream()
                .filter(transaction -> 2011 == transaction.getYear())
                .sorted(provider::compareByValueReverse).collect(Collectors.toList());

        System.out.println("找出2011年发生的所有交易，并按交易额聪大到小排序 " + collect3);


        // 交易员在哪些不同的城市工作过
        List<String> collect4 = transactions.stream()
                .map(transaction -> transaction.getTrade().getName() + "---" + transaction.getTrade().getCity())
                .distinct()
                .collect(Collectors.toList());
        System.out.println("交易员在哪些不同的城市工作过 " + collect4);

        // 查找所有来自剑桥的交易员，并按姓名排序
        List<Trader> collect5 = transactions.stream()
                .map(Transaction::getTrade)
                .filter(x -> "Cambridge".equals(x.getCity()))
                .sorted(comparing(Trader::getName))
                .distinct()
                .collect(Collectors.toList());
        System.out.println("找所有来自剑桥的交易员，并按姓名排序 " + collect5);


        // 返回所有交易员的姓名字符串，并按字母顺序排序
        String collect6 = transactions.stream()
                .map(transaction -> transaction.getTrade().getName())
                .distinct()
                .sorted()
                .reduce("", (n1, n2) -> n1 + n2);
        System.out.println("返回所有交易员的姓名字符串，并按字母顺序排序 " + collect6);

        // 有没有交易员在米兰工作的？
        // .anyMatch表示一组数据中,是否包含一条或多条该数据
        boolean anyMatch = transactions.stream().anyMatch(transaction -> "Milan".equals(transaction.getTrade().getCity()));
        System.out.println(anyMatch);

        // 打印生活在剑桥的每一个交易员的所有交易额 map<String,Integer> 方法1
        Map<String, Integer> cambridge7 = transactions.stream()
                .filter(x -> x.getTrade().getCity().equals("Cambridge"))
                .collect(Collectors.groupingBy(e -> new String(e.getTrade().getName()), Collectors.summingInt(Transaction::getValue)));
        System.out.println("打印生活在剑桥的每一个交易员的所有交易额 方法1" + cambridge7);


        // 打印生活在剑桥的每一个交易员的所有交易额 map<String,Integer>  方法2
        Map<String, Integer> cambridge8 = transactions.stream()
                .filter(x -> x.getTrade().getCity().equals("Cambridge"))
                .collect(Collectors.groupingBy(e -> new String(e.getTrade().getName()), Collectors.reducing(0, e -> e.getValue(), (s1, s2) -> s1 + s2)));
        System.out.println("打印生活在剑桥的每一个交易员的所有交易额 方法2" + cambridge8);


        // 所有交易中，最高的交易额是多少
        Integer reduce = transactions.stream()
                .map(Transaction::getValue)
                .reduce(0, Integer::max);
        System.out.println("所有交易中，最高的交易额是多少 " + reduce);


        // 找到交易额最小的交易
        Integer reduce1 = transactions.parallelStream()
                .map(Transaction::getValue)
                .reduce(Integer::min).get();
        System.out.println("到交易额最小的交易 " + reduce1);

    }


    static class ComparatorProvider {

        public int compareByValueReverse(Transaction o1, Transaction o2) {
            return o2.getValue().compareTo(o1.getValue());
        }

    }
}
