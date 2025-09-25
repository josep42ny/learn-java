package josep42ny;

import java.util.*;

public class Enrollment {

    private Developer developer;
    private Role role;

    public Enrollment(Developer developer, Role role) {
        this.developer = developer;
        this.role = role;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "developer=" + developer.getName() +
                ", role=" + role +
                '}';
    }
}
