package Simulator;

import java.util.ArrayList;
import java.util.List;

/**
 * Clock class for managing clock ticks.
 */
public class Clock {
    private final List<IClockObserver> observers = new ArrayList<>();

    public void addObserver(IClockObserver observer) {
        observers.add(observer);
    }

    public void tick(int currentClockCycle) {
        for (IClockObserver observer : observers) {
            observer.update(currentClockCycle);
        }
    }
}
