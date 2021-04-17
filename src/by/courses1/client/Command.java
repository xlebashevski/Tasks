package by.courses1.client;

public class Command {
    private String description;
    private CarAction action;

    public Command(String description, CarAction action) {
        this.description = description;
        this.action = action;
    }

    public String getDescription() {
        return description;
    }

    public CarAction getAction() {
        return action;
    }


}
