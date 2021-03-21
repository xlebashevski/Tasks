package by.courses1.cars;

public class Salon {
    private Service service = new Service();
    public Car createCarOrder(Factory factory, String color, String[] listOfOptions,
                       String model, int year, int wheelSize, double engineVolume){
        return factory.createCar(color, listOfOptions, model, year, wheelSize, engineVolume);
    }

    public Car changeCar (Car car, String color, int wheelSize, String[] listOfOptions){
        service.changeColor(car, color);
        service.changeWheelSize(car, wheelSize);
        String[] currentListOfOptions = car.getListOfOptions();
        for (int j = 0; j < currentListOfOptions.length; j++){
            service.deleteOption(car, currentListOfOptions[j]);
        }
        for (int j = 0; j < listOfOptions.length; j++) {
            service.addOption(car, listOfOptions[j]);
        }
        return car;
    }
}
