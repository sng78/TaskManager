package ru.netology.javacore;

import java.util.*;

public class Todos {
    protected List<String> tasks = new ArrayList<>();

    public Todos() {
    }

    public void addTask(String task) {
        if (tasks.size() < 7) {
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