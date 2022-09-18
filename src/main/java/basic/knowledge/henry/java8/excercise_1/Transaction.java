package basic.knowledge.henry.java8.excercise_1;

public class Transaction {

    Trader trade;

    Integer year;

    Integer value;


    public Transaction(Trader trade, Integer year, Integer value) {
        this.trade = trade;
        this.year = year;
        this.value = value;
    }

    public Transaction() {
    }

    public Trader getTrade() {
        return trade;
    }

    public void setTrade(Trader trade) {
        this.trade = trade;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public int compareByValue(Transaction transaction){
        return this.getValue()-transaction.getValue();
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trade=" + trade +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
