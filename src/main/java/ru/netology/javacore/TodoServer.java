package ru.netology.javacore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TodoServer {
    public int port;
    public Todos todos;

    public TodoServer(int port, Todos todos) {
        this.port = port;
        this.todos = todos;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            System.out.println("Starting server at " + port + "...");
            //noinspection InfiniteLoopStatement
            while (true) {
                try (
                        Socket socket = serverSocket.accept();
                        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        PrintWriter out = new PrintWriter(socket.getOutputStream())
                ) {
                    String jsonText = in.readLine();
                    GsonBuilder builder = new GsonBuilder();
                    Gson gson = builder.create();
                    Task taskNew = gson.fromJson(jsonText, Task.class);

                    switch (taskNew.type) {
                        case "ADD":
                            todos.addTask(taskNew.task);
                            break;
                        case "REMOVE":
                            todos.removeTask(taskNew.task);
                            break;
                    }

                    out.println(todos.getAllTasks());
                }
            }
        } catch (IOException e) {
            System.out.println("Can't start the server");
            e.printStackTrace();
        }
    }
}