package by.courses1.cars.impl;

import by.courses1.cars.Car;
import by.courses1.cars.Model;

import java.util.List;

public class Opel extends Car {
    public Opel(String color, List<String> options, int year, int wheelSize, double engineVolume) {
        super(color, options, year, wheelSize, engineVolume);
    }

    @Override
    public Model getModel() {
        return Model.OPEL;
    }
}
