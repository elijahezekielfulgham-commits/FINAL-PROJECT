package controller;

import java.util.ArrayList;
import java.util.List;
import model.Task;
public class TaskManager {
    private final List<Task> tasks;
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }
    public void removeTask(int taskId) {
        tasks.removeIf(t -> t.getTaskId() == taskId);
    }
    public List<Task> getTasks() {
        return tasks;
    }
    public int generateNextId() {
        if (tasks.isEmpty()) {
            return 1;
        }
        return tasks.get(tasks.size() - 1).getTaskId() + 1;
    }
}
