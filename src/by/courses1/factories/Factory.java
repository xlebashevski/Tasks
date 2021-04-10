package by.courses1.factories;

import by.courses1.cars.Car;
import by.courses1.cars.Model;
import by.courses1.services.IColorService;
import by.courses1.services.IOptionService;
import by.courses1.services.IWheelSizeService;
import by.courses1.services.impl.ColorServiceImpl;
import by.courses1.services.impl.OptionServiceImpl;
import by.courses1.services.impl.WheelSizeServiceImpl;

import java.util.*;

public abstract class Factory implements IFactory {
    private List<Car> storage;
    private IColorService colorService = new ColorServiceImpl();
    private IOptionService optionService = new OptionServiceImpl();
    private IWheelSizeService wheelSizeService = new WheelSizeServiceImpl();


    public void createStorage() {
        if(storage!=null){
            return;
        }
        storage = new ArrayList<>();
        Random random = new Random();
        int modelLength = getModels().size();
        int colorsLength = getColors().size();
        int wheelSizesLength = getWheelSizes().size();
        int engineVolumesLength = getEngineVolumes().size();
        Calendar calendar = new GregorianCalendar();
        int currentYear = calendar.get(Calendar.YEAR);
        for (int i = 0; i < 100; i++) {
            int modelIndex = random.nextInt(modelLength);
            int colorsIndex = random.nextInt(colorsLength);
            int wheelSizesIndex = random.nextInt(wheelSizesLength);
            int engineVolumesIndex = random.nextInt(engineVolumesLength);
            storage.add(createCar(getColors().get(colorsIndex), null, getModels().get(modelIndex), currentYear,
                    getWheelSizes().get(wheelSizesIndex), getEngineVolumes().get(engineVolumesIndex)));
        }
    }

    @Override
    public Car createCar(String color, List<String> options, Model model, int year, int wheelSize, double engineVolume) {
        for (Car car : storage) {
            if (car!=null && car.getColor().equals(color) && model == car.getModel() &&
                    year == car.getYear() && wheelSize == car.getWheelSize() &&
                    engineVolume == car.getEngineVolume() && checkListStringEquals(options, car.getOptions())) {
                return car;
            }
        }
        Car newCar = createNewCar(color, options, model, year, wheelSize, engineVolume);
        if (newCar == null) {
            throw new IllegalArgumentException("There is no factory for creating model: " + model);
        }
        return newCar;
    }


    private boolean checkListStringEquals(List<String> list1, List<String> list2) {
        if (list1 == null && list2 == null) {
            return true;
        }
        return list1 != null && list1.equals(list2);
    }

    protected abstract Car createNewCar(String color, List<String> options,
                                        Model model, int year, int wheelSize, double engineVolume);

    @Override
    public Car getMostSuitableCar(String color, List<String> options, Model model, int year, int wheelSize, double engineVolume) {
        for (Car car : storage) {
            if (model == car.getModel() && year == car.getYear() && engineVolume == car.getEngineVolume()) {
                if (!car.getColor().equals(color)) {
                    colorService.changeColor(car, color);
                }
                if (car.getWheelSize() != wheelSize) {
                    wheelSizeService.changeWheelSize(car, wheelSize);
                }
                if (!checkListStringEquals(car.getOptions(), options)) {
                    configOptions(car, options);
                }
                return car;
            }
        }
        return null;
    }

    private void configOptions(Car car, List<String> options) {
        if (options == null) {
            for (String option : car.getOptions()) {
                optionService.deleteOption(car, option);
            }
            return;
        }
        if (car.getOptions() == null) {
            for (String option : options) {
                optionService.addOption(car, option);
            }
            return;
        }
        for (String option : car.getOptions()) {
            if (!options.contains(option)) {
                optionService.deleteOption(car, option);
            }
        }
        for (String option : options) {
            if (!car.getOptions().contains(option)) {
                optionService.addOption(car, option);
            }
        }
    }


    @Override
    public void printModels() {
        List<Model> models = getModels();
        if (models != null) {
            for (Model model : models) {
                System.out.print(model + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void printColors() {
        List<String> colors = getColors();
        if (colors != null) {
            for (String color : colors) {
                System.out.print(color + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void printWheelSizes() {
        List<Integer> wheelSizes = getWheelSizes();
        if (wheelSizes != null) {
            for (Integer wheelSize : wheelSizes) {
                System.out.print(wheelSize + " ");
            }
            System.out.println();
        }
    }

    @Override
    public void printEngineVolumes() {
        List<Double> engineVolumes = getEngineVolumes();
        if (engineVolumes != null) {
            for (Double engineVolume : engineVolumes) {
                System.out.print(engineVolume + " ");
            }
            System.out.println();
        }
    }

    public List<Car> getStorage() {
        return storage;
    }

    public abstract List<Model> getModels();

    public abstract List<Integer> getWheelSizes();

    public abstract List<Double> getEngineVolumes();

    public abstract List<String> getColors();
}
