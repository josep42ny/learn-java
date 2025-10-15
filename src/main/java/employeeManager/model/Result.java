package employeeManager.model;

import lombok.Getter;

@Getter
public class Result {

    private String gender;
    private String email;
    private String phone;
    private String nat;
    private Name name;
    private Location location;
    private Picture picture;
    private Dob dob;

    public static class Name {
        private String title;
        private String first;
        private String last;
    }

    public static class Dob {
        private String date;
        private int age;
    }

}
