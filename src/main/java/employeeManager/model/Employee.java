package employeeManager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public abstract class Employee implements Comparable<Employee> {

    private String name;
    private String pictureUrl;
    private int age;
    private String sex;
    private String country;

    @Override
    public int compareTo(Employee o) {
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return name + " (age " + age + ")" + " [" + pictureUrl + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(pictureUrl, employee.pictureUrl) && Objects.equals(sex, employee.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pictureUrl, age, sex);
    }
}
