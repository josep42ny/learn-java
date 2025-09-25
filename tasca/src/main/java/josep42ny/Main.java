package josep42ny;

public class Main {

    public static void main(String[] args) {
        Project project = new Project("Test Project");
        project.addDeveloper(new Developer("Pep"), Role.BACKEND);
        project.addDeveloper(new Developer("Clara"), Role.FRONTEND);
        project.addDeveloper(new Developer("Carlos"), Role.FULLSTACK);

        Task task1 = new Task("Task one", "Description", 5);
        Task task2 = new Task("Task one", "Description", 5, task1);

        project.addTask(task1);
        project.addTask(task2);

        System.out.println(project);

    }


}
