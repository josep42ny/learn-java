package employeeManager.dao;

import employeeManager.model.*;
import employeeManager.services.ApiService;

import java.util.List;

public class EmployeeDaoApiImplementation implements EmployeeDao {

    private ApiService service;

    public EmployeeDaoApiImplementation() {
        this.service = new ApiService();
    }

    @Override
    public List<Manager> getManagers(int amount) {
        ApiResponse response = service.getResults(amount);
        List<Result> results = response.getResults();
        return results.stream()
                .map(person ->
                    new Manager(
                            person.getName()
                    )
                )
                .toList();
    }

    @Override
    public List<Developer> getDevelopers(int amount) {
        ApiResponse response = service.getResults(amount);
        List<Result> results = response.getResults();
        return results.stream()
                .map(person ->
                        new Developer(
                                person.getName()
                        )
                )
                .toList();
    }

}
