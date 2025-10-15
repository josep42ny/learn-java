package employeeManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Persons<T extends Employee> {

    private List<T> persons;

    public Persons(List<T> persons) {
        this.persons = persons;
    }

    @Override
    public String toString() {
        return persons.stream()
                .map(Objects::toString)
                .collect(Collectors.joining(", "));
    }
}
