package by.courses1.main;

import by.courses1.cars.Car;
import by.courses1.cars.Model;
import by.courses1.cars.impl.Audi;
import by.courses1.factories.Factories;
import by.courses1.factories.Factory;
import by.courses1.salon.Salon;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Audi audi = new Audi("Red", null, 2021, 18, 2.0);
        audi.printCar();
        // Создание авто по заказу
        Salon salon = new Salon();
        Car carOrder = salon.createCarOrder("Blue", Arrays.asList("Cruize control"),
                Model.FIAT, 2021, 14, 1.2);
        if (carOrder == null) {
            System.out.println("Такую машину создать нельзя");
            return;
        }
        carOrder.printCar();
        // Изменение машины в салоне
        Car changedCar = salon.changeCarColor(carOrder, "Black");
        changedCar = salon.changeCarWheelSize(changedCar, 20);
        changedCar = salon.changeCarOptions(changedCar, Arrays.asList("Cruize control", "Led light"));
        changedCar.printCar();

        // Поиск наиболее подходящей машины и изменение её на заводе
        Car mostSuitableCar = salon.getMostSuitableCar("grey", Arrays.asList("parktronik"), Model.BMW, 2021, 21, 2.0);
        if (mostSuitableCar == null) {
            System.out.println("Нет подходящего авто");
        } else {
            mostSuitableCar.printCar();
        }

        // Печать списков цветов, моедлей, объемов двигателей, размеров колес
        for (Factory factory : Factories.getInstance()) {
            System.out.println(factory.getClass());
            factory.printColors();
            factory.printModels();
            factory.printEngineVolumes();
            factory.printWheelSizes();
        }
    }
}
