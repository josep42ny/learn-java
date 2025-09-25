package josep42ny;

public class Task {

    private String taskDescription;
    private int estimatedHours;
    private Task parent;

    public Task(String name, String description, int estimatedHours, Task parent) {
        this.taskDescription = description;
        this.estimatedHours = estimatedHours;
        this.parent = parent;
    }

    public Task(String name, String description, int estimatedHours) {
        this(name, description, estimatedHours, null);
    }

    public void setParent(Task parent) {
        this.parent = parent;
    }

    public void removeParent() {
        this.parent = null;
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

    @Override
    public String toString() {
        return "Task{" +
                "taskDescription='" + taskDescription + '\'' +
                ", estimatedHours=" + estimatedHours +
                ", parent=" + parent +
                '}';
    }
    
}
