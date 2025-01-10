package Simulator;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Priority-based scheduling strategy.
 */
public class PrioritySchedulingStrategy implements ISchedulingStrategy {
    @Override
    public void scheduleTasks(List<IProcessor> processors, PriorityQueue<Task> taskQueue, int currentClockCycle) {
        for (IProcessor processor : processors) {
            if (!processor.isBusy() && !taskQueue.isEmpty()) {
                Task task = taskQueue.poll();
                processor.assignTask(task, currentClockCycle);
            }
        }
    }
}
