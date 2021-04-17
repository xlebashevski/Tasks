package by.courses1.client;

import by.courses1.cars.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleClient {
    public static final String EXIT_COMMAND = "-exit";
    public static Map<Integer, Car> clientCars = new HashMap<>();
    public static Map<Integer, Command> commands = new HashMap<>();

    static {
        Command createCarCommand = new Command("Создать машину", new CreateCarAction());
        commands.put(commands.size() + 1, createCarCommand);
        Command getMostSuitableCarCommand = new Command("Получить на складе наиболее подходящую машину",
                new GetMostSuitableCarAction());
        commands.put(commands.size() + 1, getMostSuitableCarCommand);
        Command changeCarCommand = new Command("Изменить машину", new ChangeCarAction());
        commands.put(commands.size() + 1, changeCarCommand);
    }

    public static void run() {
        printHead();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nextCommand = sc.next();
            if (nextCommand.equals(EXIT_COMMAND)) {
                return;
            }
            Integer commandIndex = Integer.valueOf(nextCommand);
            Command command = commands.get(commandIndex);
            if (command != null) {
                try {
                    Car car = command.getAction().run();

                    if (car != null) {
                        clientCars.put(clientCars.size() + 1, car);
                    }
                } catch (Exception e) {
                    System.out.println("Данные введены неверно");
                }
            }
            if (clientCars.size() > 0) {
                printClientsCar();
            }
            printHead();
        }
    }

    public static void printHead() {
        System.out.println("==========================================================================");
        System.out.println("Доступные команды: ");
        commands.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());
        });
    }

    public static void printClientsCar() {
        System.out.println("**************************************************************************");
        System.out.println("Автомобили пользователя: ");
        clientCars.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ": ");
            entry.getValue().printCar();
        });

    }
}
