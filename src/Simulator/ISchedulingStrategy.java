package Simulator;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Strategy interface for scheduling algorithms.
 */
public interface ISchedulingStrategy {
    void scheduleTasks(List<IProcessor> processors, PriorityQueue<Task> taskQueue, int currentClockCycle);
}
