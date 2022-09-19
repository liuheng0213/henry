package basic.knowledge.henry.java8.excercise_1;

public class Trader {

    String name;

    String city;

    public Trader() {
    }

    public Trader(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
