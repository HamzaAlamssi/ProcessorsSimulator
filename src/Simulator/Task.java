package Simulator;

/**
 * Task record represents a task in the simulation.
 */
public record Task(String id, int creationTime, int executionTime, int priority) {
    @Override
    public String toString() {
        return "Task{id='" + id + "', creationTime=" + creationTime +
                ", executionTime=" + executionTime + ", priority=" + priority + "}";
    }
}
