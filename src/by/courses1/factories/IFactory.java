package by.courses1.factories;

import by.courses1.cars.Car;
import by.courses1.cars.Model;

import java.util.List;

public interface IFactory {
    Car createCar(String color, List<String> options, Model model,
                  int year, int wheelSize, double engineVolume);

    Car getMostSuitableCar(String color, List<String> options, Model model,
                           int year, int wheelSize, double engineVolume);

    void printModels();

    void printColors();

    void printWheelSizes();

    void printEngineVolumes();
}
