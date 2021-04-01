package by.courses1.cars.impl;

import by.courses1.cars.Car;
import by.courses1.cars.Model;

import java.util.List;

public class Ferrari extends Car {
    public Ferrari(String color, List<String> options, int year, int wheelSize, double engineVolume) {
        super(color, options, year, wheelSize, engineVolume);
    }

    @Override
    public Model getModel() {
        return Model.FERRARI;
    }
}
