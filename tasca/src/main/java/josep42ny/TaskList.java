package josep42ny;

import java.util.List;
import java.util.ArrayList;

public class TaskList {

    private final List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public void push(Task task) {
        tasks.add(task);
    }

    public void pop() {
        tasks.removeLast();
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        tasks.remove(index > 0 ? index : tasks.size() - index);
    }

}
