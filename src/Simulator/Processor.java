package Simulator;

/**
 * Processor class represents a processor that can execute tasks.
 */
public class Processor implements IProcessor, IClockObserver {
    private final String id;
    private Task currentTask;
    private int taskEndTime;

    public Processor(String id) {
        this.id = id;
        this.currentTask = null;
        this.taskEndTime = 0;
    }

    @Override
    public boolean isBusy() {
        return currentTask != null;
    }

    @Override
    public void assignTask(Task task, int currentTime) {
        this.currentTask = task;
        this.taskEndTime = currentTime + task.executionTime();
    }

    @Override
    public void checkAndCompleteTask(int currentTime) {
        if (currentTask != null && currentTime >= taskEndTime) {
            currentTask = null;
            taskEndTime = 0;
        }
    }

    @Override
    public void update(int currentClockCycle) {
        checkAndCompleteTask(currentClockCycle);
    }

    @Override
    public String toString() {
        return id + ": " + (isBusy() ? "Working on " + currentTask.id() + " till " + taskEndTime : "Idle");
    }
}
