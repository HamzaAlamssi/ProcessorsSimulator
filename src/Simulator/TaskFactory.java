package Simulator;

/**
 * Factory class to create tasks.
 */
public class TaskFactory {
    private static int taskId = 1;

    public static Task createTask(int creationTime, int executionTime, int priority) {
        return new Task("T" + taskId++, creationTime, executionTime, priority);
    }
}
