import java.util.Objects;

public class Person implements Comparable {
    private String name;
    private char gender;
    private int age;

    public Person(String name, char gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "[" + gender + "] " + name + " (" + age + ")";
    }

    @Override
    public boolean equals(Object o) {
        Person p = (Person) o;
        return this.getName().equals(p.getName());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.getName());

        return hash;
    }

    @Override
    public int compareTo(Object o) {
        Person p = (Person) o;
        return this.getName().compareTo(p.getName());
    }
}
