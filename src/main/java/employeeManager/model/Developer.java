package employeeManager.model;

import lombok.AllArgsConstructor;

public class Developer extends Employee {

    public Developer(String name, String pictureUrl, int age, String sex, String country) {
        super(name, pictureUrl, age, sex, country);
    }

    @Override
    public String toString() {
        return super.toString() + " is a developer";
    }

}
