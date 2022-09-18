package basic.knowledge.henry.java8.basicApi;


public class Employee_2 {
    int id;
    String name;
    Double salary;


    public Employee_2(int id, String name, Double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Employee_2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee_2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public void salaryIncrement(double v) {
        this.setSalary(this.getSalary() + v);
    }


}
