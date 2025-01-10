package Simulator;

import java.util.*;
import java.io.*;

/**
 * The TaskReader class reads tasks from a file.
 */
public class TaskReader {
    /**
     * Reads tasks from the specified file path.
     *
     * @param filePath the path to the task file
     * @return a list of tasks
     * @throws TaskReadException if an error occurs while reading the file
     */
    public List<Task> readTasksFromFile(String filePath) throws TaskReadException {
        List<Task> tasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int taskId = 1;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length != 3) {
                    throw new TaskReadException("Invalid task format: " + line);
                }
                int creationTime = Integer.parseInt(parts[0]);
                int executionTime = Integer.parseInt(parts[1]);
                int priority = Integer.parseInt(parts[2]);
                Task task = new Task("T" + taskId++, creationTime, executionTime, priority);
                tasks.add(task);
            }
        } catch (IOException e) {
            throw new TaskReadException("Error reading file: " + filePath, e);
        } catch (NumberFormatException e) {
            throw new TaskReadException("Invalid number format in file: " + filePath, e);
        }
        return tasks;
    }
}
