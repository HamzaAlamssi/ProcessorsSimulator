package Simulator;

/**
 * Factory class to create processors.
 */
public class ProcessorFactory {
    public static IProcessor createProcessor(String id) {
        return new Processor(id);
    }
}
