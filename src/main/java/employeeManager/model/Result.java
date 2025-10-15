package employeeManager.model;

import com.google.gson.annotations.SerializedName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class Result {

    @SerializedName("gender")
    private String sex; // sexe != gènere :)
    private String email;
    private String phone;
    @Getter(AccessLevel.NONE)
    private Name name;
    @Getter(AccessLevel.NONE)
    private Location location;
    @Getter(AccessLevel.NONE)
    private Picture picture;
    @Getter(AccessLevel.NONE)
    private Dob dob;

    @Getter
    public static class Dob {
        private String date;
        private int age;
    }

    @Data
    public static class Name {
        private String title;
        private String first;
        private String last;
    }

    @Data
    public static class Location {
        private String country;
    }

    public String getName() {
        return this.name.getTitle() + ". " + this.name.getFirst() + " " + this.name.getLast();
    }

    public String getPicture() {
        return picture.getLarge();
    }

    public int getAge() {
        return dob.getAge();
    }

    public String getCountry() {
        return location.getCountry();
    }

}
