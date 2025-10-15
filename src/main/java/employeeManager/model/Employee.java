package employeeManager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Employee {

    private String name;

    @Override
    public String toString() {
        return name;
    }
}
