package by.courses1.salon;

import by.courses1.cars.Car;
import by.courses1.cars.Model;
import by.courses1.factories.Factories;
import by.courses1.factories.Factory;
import by.courses1.services.IColorService;
import by.courses1.services.IOptionService;
import by.courses1.services.IWheelSizeService;
import by.courses1.services.impl.ColorServiceImpl;
import by.courses1.services.impl.OptionServiceImpl;
import by.courses1.services.impl.WheelSizeServiceImpl;

import java.util.List;

public class Salon {
    private IColorService colorService = new ColorServiceImpl();
    private IOptionService optionService = new OptionServiceImpl();
    private IWheelSizeService wheelSizeService = new WheelSizeServiceImpl();


    public Car createCarOrder(String color, List<String> options,
                              Model model, int year, int wheelSize, double engineVolume) {
        for (Factory factory : Factories.getFactories()) {
            if (factory.getModels().contains(model)) {
                return factory.createCar(color, options, model, year, wheelSize, engineVolume);
            }
        }
        return null;
    }

    public Car getMostSuitableCar(String color, List<String> options,
                                  Model model, int year, int wheelSize, double engineVolume) {
        for (Factory factory : Factories.getFactories()) {
            if (factory.getModels().contains(model)) {
                return factory.getMostSuitableCar(color, options, model, year, wheelSize, engineVolume);
            }
        }
        return null;
    }

    public Car changeCarColor(Car car, String color) {
        colorService.changeColor(car, color);
        return car;
    }


    public Car changeCarWheelSize(Car car, int wheelSize) {
        wheelSizeService.changeWheelSize(car, wheelSize);
        return car;
    }

    public Car changeCarOptions(Car car, List<String> options) {
        List<String> currentOptions = car.getOptions();
        for (String option : currentOptions) {
            optionService.deleteOption(car, option);
        }
        for (String option : options) {
            optionService.addOption(car, option);
        }
        return car;
    }
}

