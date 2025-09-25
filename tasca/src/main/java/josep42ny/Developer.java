package josep42ny;

public class Developer {

    private String name;
    private int workHours;

    public Developer(String name) {
        this.name = name;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getWorkHours() {
        return workHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
