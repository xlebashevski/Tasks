package by.courses1.factories;

import by.courses1.cars.Car;
import by.courses1.cars.Model;
import by.courses1.services.*;
import by.courses1.services.impl.ColorServiceImpl;
import by.courses1.services.impl.OptionServiceImpl;
import by.courses1.services.impl.WheelSizeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Factory implements IFactory {
    private List<Car> storage;
    private IColorService colorService = new ColorServiceImpl();
    private IOptionService optionService = new OptionServiceImpl();
    private IWheelSizeService wheelSizeService = new WheelSizeServiceImpl();


    public void createStorage() {
        storage = new ArrayList<>();
        Random random = new Random();
        int modelLength = getModels().size();
        int colorsLength = getColors().size();
        int wheelSizesLength = getWheelSizes().size();
        int engineVolumesLength = getEngineVolumes().size();
        for (int i = 0; i < 100; i++) {
            int modelIndex = random.nextInt(modelLength);
            int colorsIndex = random.nextInt(colorsLength);
            int wheelSizesIndex = random.nextInt(wheelSizesLength);
            int engineVolumesIndex = random.nextInt(engineVolumesLength);
            storage.add(createCar(getColors().get(colorsIndex), null, getModels().get(modelIndex), 2021,
                    getWheelSizes().get(wheelSizesIndex), getEngineVolumes().get(engineVolumesIndex)));
        }
    }

    @Override
    public Car createCar(String color, List<String> options, Model model, int year, int wheelSize, double engineVolume) {
        if (getColors().contains(color) && getModels().contains(model) &&
                getEngineVolumes().contains(engineVolume) && getWheelSizes().contains(wheelSize)) {
            for (Car car : storage) {
                if (car != null && color == car.getColor() && model == car.getModel() &&
                        year == car.getYear() && wheelSize == car.getWheelSize() &&
                        engineVolume == car.getEngineVolume() && checkOptions(options, car)) {
                    return car;
                }
            }
            return createNewCar(color, options, model, year, wheelSize, engineVolume);
        } else {
            return null;
        }
    }

    private boolean checkOptions(List<String> options, Car car) {
        if (options == null && car.getOptions() == null) {
            return true;
        }
        return options != null && options.equals(car.getOptions());
    }

    protected abstract Car createNewCar(String color, List<String> options,
                                        Model model, int year, int wheelSize, double engineVolume);

    @Override
    public Car getMostSuitableCar(String color, List<String> options, Model model, int year, int wheelSize, double engineVolume) {
        for (Car car : storage) {
            if (model == car.getModel() && year == car.getYear() && engineVolume == car.getEngineVolume()) {
                colorService.changeColor(car, color);
                wheelSizeService.changeWheelSize(car, wheelSize);
                List<String> currentOptions = car.getOptions();
                if (currentOptions != null) {
                    for (String option : currentOptions) {
                        optionService.deleteOption(car, option);
                    }
                }
                if (options != null) {
                    for (String option : options) {
                        optionService.addOption(car, option);
                    }
                }
                return car;
            }
        }
        return null;
    }

    @Override
    public void printModels() {
        for (Model model : getModels()) {
            System.out.print(model + " ");
        }
        System.out.println();
    }

    @Override
    public void printColors() {
        for (String color : getColors()) {
            System.out.print(color + " ");
        }
        System.out.println();
    }

    @Override
    public void printWheelSizes() {
        for (Integer wheelSize : getWheelSizes()) {
            System.out.print(wheelSize + " ");
        }
        System.out.println();
    }

    @Override
    public void printEngineVolumes() {
        for (Double engineVolume : getEngineVolumes()) {
            System.out.print(engineVolume + " ");
        }
        System.out.println();
    }


    public abstract List<Model> getModels();

    public abstract List<Integer> getWheelSizes();

    public abstract List<Double> getEngineVolumes();

    public abstract List<String> getColors();
}
