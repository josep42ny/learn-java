package employeeManager;

import employeeManager.dao.EmployeeDao;
import employeeManager.dao.EmployeeDaoFactory;
import employeeManager.model.Developer;
import employeeManager.model.Manager;
import employeeManager.model.Persons;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        EmployeeDao dao = EmployeeDaoFactory.create();
        Persons<Manager> managers = new Persons<>(dao.getManagers(5));
        System.out.println(
                "All managers\n" +
                        managers +
                        "\n"
        );

        Persons<Developer> devs = new Persons<>(dao.getDevelopers(10));
        System.out.println(
                "Only male devs\n" +
                        devs.getMales() + "\n"
        );
        Predicate<Developer> maleDevs = t -> t.getSex().equals("male");
        System.out.println(
                "Male devs sorted by youngest first\n" +
                        devs.getMalesSorted(maleDevs) + "\n"
        );
        System.out.println(
                "Turkish male devs sorted by youngest first\n" +
                        devs.getMalesSortedByAgeFrom("Turkey") + "\n"
        );
        System.out.println(
                "Is " + devs.get(1).getName() + " equal to themselves?\n" +
                        devs.get(1).equals(devs.get(1)) + "\n"
        );
        System.out.println(
                "Is " + devs.get(0).getName() + " equal to " + devs.get(2).getName() + "?\n" +
                        devs.get(0).equals(devs.get(2)) + "\n"
        );
    }

}
