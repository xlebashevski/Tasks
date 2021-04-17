package by.courses1.client;

import by.courses1.cars.Car;
import by.courses1.cars.Model;
import by.courses1.cars.validator.CarValidator;
import by.courses1.salon.Salon;

import java.util.*;
import java.util.stream.Collectors;

public class CreateCarAction implements CarAction {
    @Override
    public Car run() {
        System.out.println("Введите модель машины которую вы хотите создать: ");
        Model[] models = Model.values();
        System.out.println("Доступные модели машин: ");
        for (Model model : models) {
            System.out.print(model.getValue() + ", ");
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        String modelInput = sc.nextLine();
        boolean isCorrectModel = Arrays.stream(models)
                .map(model -> model.getValue().toUpperCase(Locale.ROOT))
                .collect(Collectors.toList())
                .contains(modelInput.toUpperCase(Locale.ROOT));
        Model model;
        if (isCorrectModel) {
            model = Model.valueOf(modelInput.toUpperCase(Locale.ROOT));
        } else {
            System.out.println("Невозможно создать данную модель: " + modelInput);
            return null;
        }
        System.out.println("Введите цвет: ");
        List<String> availableModelColors = CarValidator.getAvailableModelColors(model);
        System.out.println("Доступные цвета для данной модели: " + availableModelColors);
        String colorInput = sc.next();
        System.out.println("Введите год: ");
        int yearInput = sc.nextInt();
        System.out.println("Введите размер колес: ");
        List<Integer> availableModelWheelSizes = CarValidator.getAvailableModelWheelSizes(model);
        System.out.println("Доступные размеры колес: " + availableModelWheelSizes);
        Integer wheelSizeInput = sc.nextInt();
        System.out.println("Введите объём двигателя: ");
        List<Double> availableModelEngineVolumes = CarValidator.getAvailableModelEngineVolumes(model);
        System.out.println("Доступные объёмы двигателей: " + availableModelEngineVolumes);
        double engineVolumesInput = sc.nextDouble();
        System.out.println("Введите список опций через запятую: ");
        List<String> optionsInput = new ArrayList<>();
        sc.nextLine();
        StringTokenizer stringTokenizer = new StringTokenizer(sc.nextLine(), ",");
        while (stringTokenizer.hasMoreElements()) {
            optionsInput.add(stringTokenizer.nextToken());
        }
        Salon salon = new Salon();
        Car carOrder;
        try {
            carOrder = salon.createCarOrder(colorInput, optionsInput, model, yearInput, wheelSizeInput, engineVolumesInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        System.out.println("Машина создана");
        return carOrder;
    }
}
