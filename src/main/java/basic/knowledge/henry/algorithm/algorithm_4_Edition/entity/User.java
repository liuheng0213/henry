package basic.knowledge.henry.algorithm.algorithm_4_Edition.entity;

import java.util.Objects;

public class User implements Comparable<User> {
    String name;
    Integer id;

    public User(String name) {
        this.name = name;
    }

    public User(Integer id) {
        this.id = id;
    }

    public User() {
    }

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(User that) {
        return this.id - that.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) &&
                Objects.equals(getId(), user.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getId());
    }
}
