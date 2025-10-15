package employeeManager.dao;

import employeeManager.model.Developer;
import employeeManager.model.Employee;
import employeeManager.model.Manager;

import java.util.List;

public interface EmployeeDao {

    public List<Manager> getManagers(int amount);
    public List<Developer> getDevelopers(int amount);

}
