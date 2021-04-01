package by.courses1.services.impl;

import by.courses1.cars.Car;
import by.courses1.services.ColorService;

public class ColorServiceImpl extends ColorService {
    @Override
    public void changeColor(Car car, String color) {
        car.setColor(color);
    }
}
