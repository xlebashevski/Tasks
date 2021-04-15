package by.courses1.client;

import by.courses1.cars.Model;

import java.util.Scanner;

public class Command {
    private String description;
    private Runnable action;

    public Command(String description, Runnable action) {
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public Runnable getAction() {
        return action;
    }


}
