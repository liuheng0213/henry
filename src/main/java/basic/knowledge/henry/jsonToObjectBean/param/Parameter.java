package basic.knowledge.henry.jsonToObjectBean.param;

public class Parameter {
    String type;
    String name;
    Dates dates;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", dates=" + dates +
                '}';
    }
}
