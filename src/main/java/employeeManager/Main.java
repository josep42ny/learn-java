package employeeManager;

import employeeManager.dao.EmployeeDao;
import employeeManager.dao.EmployeeDaoFactory;
import employeeManager.model.Developer;
import employeeManager.model.Persons;

public class Main {

    public static void main(String[] args) {
        EmployeeDao dao = EmployeeDaoFactory.create();
        Persons<Developer> devs = new Persons<>(dao.getDevelopers(10));
        System.out.println(devs);
    }

}
