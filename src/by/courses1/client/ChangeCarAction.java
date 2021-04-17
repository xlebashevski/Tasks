package by.courses1.client;

import by.courses1.cars.Car;
import by.courses1.cars.validator.CarValidator;
import by.courses1.salon.Salon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ChangeCarAction implements CarAction {

    @Override
    public Car run() {
        Salon salon = new Salon();
        System.out.println("Введите номер машины которую хотите изменить: ");
        Scanner sc = new Scanner(System.in);
        int carIndex = sc.nextInt();
        Car car = ConsoleClient.clientCars.get(carIndex);
        if (car == null) {
            System.out.println("Неверный индекс. Машины под таким индексом не сущестсвует");
            return null;
        }
        System.out.println("Текущий цвет: " + car.getColor()
                + ". Если хотите изменить цвет введите true иначе false");
        boolean isColorShouldBeChanged = sc.nextBoolean();
        if (isColorShouldBeChanged) {
            System.out.println("Введите цвет: ");
            List<String> availableModelColors = CarValidator.getAvailableModelColors(car.getModel());
            System.out.println("Доступные цвета для данной модели: " + availableModelColors);
            String colorInput = sc.next();
            try {
                salon.changeCarColor(car, colorInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        System.out.println("Текущий размер колёс: " + car.getWheelSize()
                + " Если хотите изменить размер колёс введите true иначе false");
        boolean isWheelSizeShouldBeChanged = sc.nextBoolean();
        if (isWheelSizeShouldBeChanged) {
            System.out.println("Введите размер колес: ");
            List<Integer> availableModelWheelSizes = CarValidator.getAvailableModelWheelSizes(car.getModel());
            System.out.println("Доступные размеры колес: " + availableModelWheelSizes);
            Integer wheelSizeInput = sc.nextInt();
            try {
                salon.changeCarWheelSize(car, wheelSizeInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        System.out.println("Текущий список опций: " + car.getOptions()
                + " Если хотите изменить список опций введите true иначе false");
        boolean isOptionsShouldBeChanged = sc.nextBoolean();
        if (isOptionsShouldBeChanged) {
            System.out.println("Введите список опций через запятую: ");
            List<String> optionsInput = new ArrayList<>();
            sc.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(sc.nextLine(), ",");
            while (stringTokenizer.hasMoreElements()) {
                optionsInput.add(stringTokenizer.nextToken());
            }
            salon.changeCarOptions(car, optionsInput);
        }
        ConsoleClient.clientCars.remove(carIndex);
        ConsoleClient.clientCars.put(carIndex, car);
        System.out.println("Машина изменена");
        return null;
    }
}
