package Simulator;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Scheduler class handles the task scheduling.
 */
public class Scheduler implements IScheduler, IClockObserver {
    private final List<IProcessor> processors;
    private final PriorityQueue<Task> taskQueue;
    private final ISchedulingStrategy schedulingStrategy;

    public Scheduler(List<IProcessor> processors, PriorityQueue<Task> taskQueue, ISchedulingStrategy schedulingStrategy) {
        this.processors = processors;
        this.taskQueue = taskQueue;
        this.schedulingStrategy = schedulingStrategy;
    }

    @Override
    public void scheduleTasks(int currentClockCycle) {
        schedulingStrategy.scheduleTasks(processors, taskQueue, currentClockCycle);
    }

    @Override
    public void update(int currentClockCycle) {
        scheduleTasks(currentClockCycle);
    }
}
