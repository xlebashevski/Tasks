package by.courses1.services.impl;

import by.courses1.cars.Car;
import by.courses1.services.WheelSizeService;

public class WheelSizeServiceImpl extends WheelSizeService {
    @Override
    public void changeWheelSize(Car car, int wheelSize) {
        if (car != null) {
            car.setWheelSize(wheelSize);
        }
    }
}
