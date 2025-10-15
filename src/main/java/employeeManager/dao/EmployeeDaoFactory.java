package employeeManager.dao;

public class EmployeeDaoFactory {

    public static EmployeeDao create() {
        return new EmployeeDaoApiImplementation();
    }

}
