package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TodosTests {
    Todos todos = new Todos();
    Task taskNew = new Task();

    @BeforeEach
    void setUp() {
        String jsonText = "{ \"type\": \"ADD\", \"task\": \"Пробежка\" }";
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        taskNew = gson.fromJson(jsonText, Task.class);
    }

    @Test
    @DisplayName("Тест на добавление задачи")
    void addTaskTest() {
        todos.addTask(taskNew.task);
        Assertions.assertEquals("Пробежка", todos.toString());
    }

    @Test
    @DisplayName("Тест на удаление задачи")
    void removeTaskTest() {
        todos.addTask("Завтрак");
        todos.addTask("Обед");
        todos.removeTask("Завтрак");
        Assertions.assertEquals("Обед", todos.toString());
    }

    @Test
    @DisplayName("Тест на вывод списка")
    void getAllTasksTest() {
        todos.addTask("Завтрак");
        todos.addTask("Обед");
        Assertions.assertEquals("Завтрак Обед \n", todos.getAllTasks());
    }
}