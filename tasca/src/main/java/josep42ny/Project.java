package josep42ny;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {

    private String name;
    private TaskList tasks;
    private List<Enrollment> enrollments;
    private final Date startTimestamp;

    public Project(String name) {
        this.name = name;
        this.tasks = new TaskList();
        this.startTimestamp = new Date();
        this.enrollments = new ArrayList<>();
    }

    public void addDeveloper(Developer developer, Role role) {
        this.enrollments.add(new Enrollment(developer, role));
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public TaskList getTasks() {
        return tasks;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", tasks=" + tasks +
                ", enrollments=" + enrollments +
                ", startTimestamp=" + startTimestamp +
                '}';
    }
}
