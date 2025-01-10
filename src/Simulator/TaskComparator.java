package Simulator;

import java.util.Comparator;

/**
 * TaskComparator class compares tasks based on priority and execution time.
 */
public class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task t1, Task t2) {
        if (t1.priority() != t2.priority()) {
            return t2.priority() - t1.priority();
        } else if (t1.executionTime() != t2.executionTime()) {
            return t2.executionTime() - t1.executionTime();
        } else {
            return 0;
        }
    }
}
