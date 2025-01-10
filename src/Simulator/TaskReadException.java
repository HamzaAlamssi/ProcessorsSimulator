package Simulator;

public class TaskReadException extends Exception {
    public TaskReadException(String message) {
        super(message);
    }

    public TaskReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
