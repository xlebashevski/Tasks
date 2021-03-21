package by.courses1.cars;

import java.util.Arrays;
import java.util.Random;

public class Factory {
    private String[] models;
    private int[] wheelSizes;
    private String[] colors;
    private double[] engineVolumes;
    private Car[] storage;
    private Service service = new Service();

    public Factory(String[] models, int[] wheelSizes, String[] colors, double[] engineVolumes) {
        if (models != null && models.length > 0) {
            this.models = models;
        } else {
            throw new IllegalArgumentException("Список моделей не может быть пустым");
        }
        if (wheelSizes != null && wheelSizes.length > 0) {
            this.wheelSizes = wheelSizes;
        } else {
            throw new IllegalArgumentException("Список размеров колес не может быть пустым");
        }
        if (colors != null && colors.length > 0) {
            this.colors = colors;
        } else {
            throw new IllegalArgumentException("Список цветов не может быть пустым");
        }
        if (engineVolumes != null && engineVolumes.length > 0) {
            this.engineVolumes = engineVolumes;
        } else {
            throw new IllegalArgumentException("Список объёмов двигателей не может быть пустым");
        }
        storage = new Car[100];
        Random random = new Random();
        int modelLength = models.length;
        int colorsLength = colors.length;
        int wheelSizesLength = wheelSizes.length;
        int engineVolumesLength = engineVolumes.length;
        for (int i = 0; i < 100; i++) {
            int modelIndex = random.nextInt(modelLength);
            int colorsIndex = random.nextInt(colorsLength);
            int wheelSizesIndex = random.nextInt(wheelSizesLength);
            int engineVolumesIndex = random.nextInt(engineVolumesLength);
            storage[i] = createCar(colors[colorsIndex], null, models[modelIndex], 2021,
                    wheelSizes[wheelSizesIndex], engineVolumes[engineVolumesIndex]);
        }
    }


    public Car createCar(String color, String[] listOfOptions, String model,
                         int year, int wheelSize, double engineVolume) {
        if (Arrays.asList(colors).contains(color) && Arrays.asList(models).contains(model) &&
                Arrays.asList(engineVolumes).contains(engineVolume) && Arrays.asList(wheelSize).contains(wheelSize)) {
            for (int i = 0; i < storage.length; i++) {
                if (storage[i] != null && color == storage[i].getColor() && model == storage[i].getModel() &&
                        year == storage[i].getYear() && wheelSize == storage[i].getWheelSize() &&
                        engineVolume == storage[i].getEngineVolume() && Arrays.equals(listOfOptions, storage[i].getListOfOptions())) {
                    return storage[i];
                }
            }
            Car car = new Car(color, listOfOptions, model, year, wheelSize, engineVolume);
            return car;
        } else {
            throw new IllegalArgumentException("Завод не может создать заданной машины");
        }
    }

    public Car getMostSuitableCar(String color, String[] listOfOptions, String model,
                                  int year, int wheelSize, double engineVolume) {
        for (int i = 0; i < storage.length; i++) {
            if (model == storage[i].getModel() && year == storage[i].getYear() && engineVolume == storage[i].getEngineVolume()) {
                service.changeColor(storage[i], color);
                service.changeWheelSize(storage[i], wheelSize);
                String[] currentListOfOptions = storage[i].getListOfOptions();
                if (currentListOfOptions != null) {
                    for (int j = 0; j < currentListOfOptions.length; j++) {
                        service.deleteOption(storage[i], currentListOfOptions[j]);
                    }
                }
                for (int j = 0; j < listOfOptions.length; j++) {
                    service.addOption(storage[i], listOfOptions[j]);
                }
                return storage[i];
            }
        }
        return null;
    }

    public void printModels() {
        for (int i = 0; i < models.length; i++) {
            System.out.print(models[i] + " ");
        }
        System.out.println();
    }

    public void printColors() {
        for (int i = 0; i < colors.length; i++) {
            System.out.print(colors[i] + " ");
        }
        System.out.println();
    }

    public void printWheelSizes() {
        for (int i = 0; i < wheelSizes.length; i++) {
            System.out.print(wheelSizes[i] + " ");
        }
        System.out.println();
    }

    public void printEngineVolumes() {
        for (int i = 0; i < engineVolumes.length; i++) {
            System.out.print(engineVolumes[i] + " ");
        }
        System.out.println();
    }

}
