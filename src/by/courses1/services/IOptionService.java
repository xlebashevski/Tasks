package by.courses1.services;

import by.courses1.cars.Car;

public interface IOptionService {
    void addOption(Car car, String option);

    void deleteOption(Car car, String option);
}
