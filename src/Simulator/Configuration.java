package Simulator;

/**
 * Singleton class for application configuration.
 */
public class Configuration {
    private static Configuration instance;
    private int numProcessors;
    private int totalClockCycles;
    private String tasksFilePath;

    private Configuration() { }

    public static synchronized Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public void initialize(int numProcessors, int totalClockCycles, String tasksFilePath) {
        this.numProcessors = numProcessors;
        this.totalClockCycles = totalClockCycles;
        this.tasksFilePath = tasksFilePath;
    }

    public int getNumProcessors() {
        return numProcessors;
    }

    public int getTotalClockCycles() {
        return totalClockCycles;
    }

    public String getTasksFilePath() {
        return tasksFilePath;
    }
}
