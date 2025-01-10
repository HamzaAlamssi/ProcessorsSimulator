package Simulator;

/**
 * IProcessor interface represents a processor in the simulation.
 */
public interface IProcessor {
    boolean isBusy();
    void assignTask(Task task, int currentTime);
    void checkAndCompleteTask(int currentTime);
    String toString();
}
