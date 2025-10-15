package employeeManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Persons<T extends Employee> {

    private final List<T> persons;

    public Persons(List<T> persons) {
        this.persons = persons;
    }

    public T get(int index) throws IndexOutOfBoundsException {
        return persons.get(index);
    }

    public List<T> getMales() {
        return persons.stream()
                .filter(t -> t.getSex().equals("male"))
                .toList();
    }

    public List<T> getMalesSorted(Predicate<T> predicate) {
        return persons.stream()
                .filter(predicate)
                .sorted()
                .toList();
    }

    public List<T> getMalesSortedByAgeFrom(String country) {
        Predicate<T> predicate = t -> t.getSex().equals("male") && t.getCountry().equals(country);
        return persons.stream()
                .filter(predicate)
                .sorted()
                .toList();
    }

    @Override
    public String toString() {
        return persons.stream()
                .map(Objects::toString)
                .collect(Collectors.joining("\n"));
    }
}
