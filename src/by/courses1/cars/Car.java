package by.courses1.cars;

import java.util.List;

public abstract class Car {
    private String color;
    private List<String> options;
    private final int year;
    private int wheelSize;
    private final double engineVolume;


    public Car(String color, List<String> options, int year, int wheelSize, double engineVolume) {
        this.color = color;
        this.options = options;
        this.year = year;
        this.wheelSize = wheelSize;
        this.engineVolume = engineVolume;
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
        System.out.println("Список опций: ");
        for (String option : options) {
            System.out.print(option + ", ");
        }
        System.out.println();
        System.out.println();
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getColor() {
        return color;
    }

    public List<String> getOptions() {
        return options;
    }


    public int getYear() {
        return year;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public double getEngineVolume() {
        return engineVolume;
    }
}




