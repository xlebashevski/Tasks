package by.courses1.services.impl;

import by.courses1.cars.Car;
import by.courses1.services.OptionService;

import java.util.ArrayList;
import java.util.List;

public class OptionServiceImpl extends OptionService {
    @Override
    public void addOption(Car car, String option) {
        List<String> options = car.getOptions();
        if (options == null) {
            options = new ArrayList<>();
        }
        if (!options.contains(option)) {
            options.add(option);
            car.setOptions(options);
        }
    }

    @Override
    public void deleteOption(Car car, String option) {
        List<String> options = new ArrayList<>(car.getOptions());
        if (options != null && options.contains(option)) {
            options.remove(option);
            car.setOptions(options);
        }

    }
}
