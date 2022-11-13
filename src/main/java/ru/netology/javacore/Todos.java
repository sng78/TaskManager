package ru.netology.javacore;

import java.util.*;

public class Todos {
    protected List<String> tasks = new ArrayList<>();
    protected final int maxTasks = 7;

    public Todos() {
    }

    public void addTask(String task) {
        if (tasks.size() < maxTasks) {
            tasks.add(task);
        }
    }

    public void removeTask(String task) {
        tasks.remove(task);
    }

    public String getAllTasks() {
        List<String> tasksSort = new ArrayList<>(tasks);
        Collections.sort(tasksSort);
        StringBuilder sb = new StringBuilder();
        for (String task : tasksSort) {
            sb.append(task).append(" ");
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return tasks.get(tasks.size() - 1);
    }
}