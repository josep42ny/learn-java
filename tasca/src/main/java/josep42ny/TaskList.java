package josep42ny;

import java.util.List;
import java.util.ArrayList;

public class TaskList {

    private final List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void add(Task task) {
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        tasks.remove(index > 0 ? index : tasks.size() - index);
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "tasks=" + tasks +
                '}';
    }
}
