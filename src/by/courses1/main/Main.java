package by.courses1.main;


import by.courses1.cars.Car;
import by.courses1.cars.Factory;
import by.courses1.cars.Salon;

public class Main {
    public static void main(String[] args) {
        // Создание авто по заказу
        Salon salon = new Salon();
        Factory factory = new Factory(new String[]{"bmw", "mercedes", "fiat"}, new int[]{16, 18, 20},
                new String[]{"blue", "yellow", "red"}, new double[]{1.6, 2.0, 3.0});
        Car carOrder = salon.createCarOrder(factory, "red", new String[]{"Cruize control"},
                "fiat", 2021, 18, 2.0);
        carOrder.printCar();
        // Изменение машины в салоне
        Car changedCar = salon.changeCar(carOrder, "black", 20, new String[]{"Led light"});
        changedCar.printCar();

        // Поиск наиболее подходящей машины и изменение её на заводе
        Car mostSuitableCar = factory.getMostSuitableCar("grey", new String[]{"parktronik"}, "bmw", 2021, 21, 2.0);
        if (mostSuitableCar == null) {
            System.out.println("Нет подходящего авто");
        } else {
            mostSuitableCar.printCar();
        }

        // Печать списков цветов, моедлей, объемов двигателей, размеров колес
        factory.printColors();
        factory.printModels();
        factory.printEngineVolumes();
        factory.printWheelSizes();

        // Создание машины через завод успешно
        Car factoryCar = factory.createCar("blue", new String[]{"cruize", "led light"}, "mercedes", 2021, 20, 2.0);
        factoryCar.printCar();
        /* Создание маишны через завод без успешно
        Car invalidFactoryCar = factory.createCar("blue", new String[]{"cruize", "led light"}, "audi", 2021, 20, 2.0);
        invalidFactoryCar.printCar(); */
    }
}
