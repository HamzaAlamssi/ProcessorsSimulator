package Simulator;

import java.util.*;
import java.io.*;

/**
 * Simulation class manages the overall simulation of processors and tasks.
 */
public class Simulation {
    private final int totalClockCycles;
    private final List<IProcessor> processors;
    private final PriorityQueue<Task> taskQueue;
    private final Clock clock;
    private int currentClockCycle;
    private final List<Task> tasks;

    public Simulation(int numProcessors, int totalClockCycles, String tasksFilePath) throws TaskReadException {
        this.totalClockCycles = totalClockCycles;
        this.processors = initializeProcessors(numProcessors);
        this.taskQueue = new PriorityQueue<>(new TaskComparator());
        IScheduler scheduler = new Scheduler(processors, taskQueue, new PrioritySchedulingStrategy());
        this.tasks = new TaskReader().readTasksFromFile(tasksFilePath);
        this.clock = new Clock();
        this.currentClockCycle = 0;
        for (IProcessor processor : processors) {
            clock.addObserver((IClockObserver) processor);
        }
        clock.addObserver((IClockObserver) scheduler);
    }

    private List<IProcessor> initializeProcessors(int numProcessors) {
        List<IProcessor> processors = new ArrayList<>();
        for (int i = 1; i <= numProcessors; i++) {
            processors.add(ProcessorFactory.createProcessor("P" + i));
        }
        return processors;
    }

    public void runSimulation() {
        for (currentClockCycle = 1; currentClockCycle <= totalClockCycles; currentClockCycle++) {
            createTasks();
            clock.tick(currentClockCycle);
            generateReport();
        }
    }

    private void createTasks() {
        for (Task task : tasks) {
            if (task.creationTime() == currentClockCycle) {
                taskQueue.add(task);
            }
        }
    }

    private void generateReport() {
        System.out.println("Clock Cycle: " + currentClockCycle);
        for (IProcessor processor : processors) {
            System.out.println(processor);
        }
        System.out.println();
    }
}
