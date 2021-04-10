package by.courses1.cars;

import by.courses1.cars.validator.CarValidator;

import java.util.List;

public abstract class Car {
    private final int year;
    private final double engineVolume;
    private String color;
    private List<String> options;
    private int wheelSize;


    public Car(String color, List<String> options, int year, int wheelSize, double engineVolume) {
        this.color = CarValidator.validateColor(getModel(), color);
        this.options = options;
        this.year = CarValidator.validateYear(year);
        this.wheelSize = CarValidator.validateWheelSize(getModel(), wheelSize);
        this.engineVolume = CarValidator.validateEngineVolume(getModel(), engineVolume);
    }

    public Car(String color, int year, int wheelSize, double engineVolume) {
        this(color, null, year, wheelSize, engineVolume);
    }


    public abstract Model getModel();

    public void printCar() {
        System.out.println("Цвет " + color);
        System.out.println("Модель " + getModel().getValue());
        System.out.println("Год " + year);
        System.out.println("Размер колёс " + wheelSize);
        System.out.println("Объём двигателя " + engineVolume);
        if (options != null) {
            System.out.println("Список опций: ");
            for (String option : options) {
                System.out.print(option + ", ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = CarValidator.validateColor(getModel(), color);
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public int getYear() {
        return year;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = CarValidator.validateWheelSize(getModel(), wheelSize);
    }

    public double getEngineVolume() {
        return engineVolume;
    }
}




