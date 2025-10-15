package employeeManager.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class Result {

    private String gender;
    private String email;
    private String phone;
    private String nat;
    @Getter(AccessLevel.NONE)
    private Name name;
    @Getter(AccessLevel.NONE)
    private Location location;
    @Getter(AccessLevel.NONE)
    private Picture picture;
    @Getter(AccessLevel.NONE)
    private Dob dob;

    public static class Dob {
        private String date;
        private int age;
    }

    public String getName() {
        return this.name.getTitle() + ". " + this.name.getFirst() + " " + this.name.getLast();
    }

}
