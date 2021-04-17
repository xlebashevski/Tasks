package by.courses1.cars.validator;

import by.courses1.cars.Model;
import by.courses1.factories.Factories;
import by.courses1.factories.Factory;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class CarValidator {

    public static String validateColor(Model model, String color) {
        List<String> factoryColors = getAvailableModelColors(model);
        if (factoryColors != null) {
            if (!factoryColors.contains(color)) {
                throw new IllegalArgumentException("Invalid color: " + color + " for model: "
                        + model + ". Available colors: " + factoryColors);
            }
            return color;
        }
        return null;
    }

    public static List<String> getAvailableModelColors(Model model) {
        for (Factory factory : Factories.getFactories()) {
            if (factory.getModels().contains(model)) {
                return factory.getColors();
            }
        }
        return null;
    }

    public static int validateYear(int year) {
        Calendar calendar = new GregorianCalendar();
        int currentYear = calendar.get(Calendar.YEAR);
        if (year != currentYear) {
            throw new IllegalArgumentException("Invalid year: " + year +
                    ". We can create only cars with year: " + currentYear);
        }
        return year;
    }

    public static double validateEngineVolume(Model model, double engineVolume) {
        List<Double> factoryEngineVolumes = getAvailableModelEngineVolumes(model);
        if (factoryEngineVolumes != null) {
            if (!factoryEngineVolumes.contains(engineVolume)) {
                throw new IllegalArgumentException("Invalid engineVolume: " + engineVolume + " for model: "
                        + model + ". Available engineVolumes: " + factoryEngineVolumes);
            }
            return engineVolume;
        }
        return 0;
    }


    public static List<Double> getAvailableModelEngineVolumes(Model model) {
        for (Factory factory : Factories.getFactories()) {
            if (factory.getModels().contains(model)) {
                return factory.getEngineVolumes();
            }
        }
        return null;
    }

    public static int validateWheelSize(Model model, int wheelSize) {
        List<Integer> factoryWheelSizes = getAvailableModelWheelSizes(model);
        if (factoryWheelSizes != null) {
            if (!factoryWheelSizes.contains(wheelSize)) {
                throw new IllegalArgumentException("Invalid wheelSize: " + wheelSize + " for model: "
                        + model + ". Available wheelSizes: " + factoryWheelSizes);
            }
            return wheelSize;
        }
        return 0;
    }

    public static List<Integer> getAvailableModelWheelSizes(Model model) {
        for (Factory factory : Factories.getFactories()) {
            if (factory.getModels().contains(model)) {
                return factory.getWheelSizes();
            }
        }
        return null;
    }
}
