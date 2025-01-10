import Simulator.*;

/**
 * Main class to run the simulation.
 */
public class Main {
    public static void main(String[] args) {
        Configuration config = Configuration.getInstance();
        config.initialize(4, 10, "src/Resources/tasks.txt");
        try {
            Simulation sim = new Simulation(
                    config.getNumProcessors(),
                    config.getTotalClockCycles(),
                    config.getTasksFilePath()
            );
            sim.runSimulation();
        } catch (TaskReadException e) {
            System.out.println("Error during simulation: " + e.getMessage());
        }
    }
}
