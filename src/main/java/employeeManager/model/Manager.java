package employeeManager.model;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

public class Manager extends Employee {

    public Manager(String name, String pictureUrl, int age, String sex, String country) {
        super(name, pictureUrl, age, sex, country);
    }

    @Override
    public String toString() {
        return super.toString() + " is a manager";
    }
}
