package josep42ny;

public class Task {

    private String taskDescription;
    private int estimatedHours;

    public Task(String name, String description, int estimatedHours) {
        this.taskDescription = description;
        this.estimatedHours = estimatedHours;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public int getEstimatedHours() {
        return estimatedHours;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setEstimatedHours(int estimatedHours) {
        this.estimatedHours = estimatedHours;
    }
}
