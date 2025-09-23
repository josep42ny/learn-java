package josep42ny;

import java.util.Date;

public class Project {

    private String name;
    private TaskList tasks;
    private final Date startTimestamp;

    public Project(String name) {
        this.name = name;
        this.tasks = new TaskList();
        this.startTimestamp = new Date();
    }

    public String getName() {
        return name;
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

}
