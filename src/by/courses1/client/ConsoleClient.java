package by.courses1.client;

import by.courses1.cars.Car;
import by.courses1.cars.Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleClient {
    public static Map<Integer, Car> clientCars = new HashMap<>();
    public static final String EXIT_COMMAND = "-exit";
    public static Map<Integer, Command> commands = new HashMap<>();

    static {
        Command createCarCommand = new Command("Создать машину", new Runnable() {
            @Override
            public void run() {
                System.out.println("Введите модель машины которую вы хотите создать: ");
                System.out.println("Доступные модели машин: " + Model.values());
                Scanner sc = new Scanner(System.in);
            }
        });
        commands.put(commands.size() + 1, createCarCommand);
    }

    public static void run() {
        System.out.println("Доступные команды: ");
        commands.entrySet().stream().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue().getDescription());

        });
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String nextCommand = sc.nextLine();
            if (nextCommand.equals(EXIT_COMMAND)) {
                return;
            }
            if (clientCars.size() > 0) {
                System.out.println("Автомобили пользователя: ");
                clientCars.entrySet().stream().forEach(entry -> {
                    System.out.println(entry.getKey() + ": ");
                    entry.getValue().printCar();
                });
            }
            Integer commandIndex = Integer.valueOf(nextCommand);
            commands.get(commandIndex).getAction().run();
        }
    }
}
