package by.courses1.cars;

public class Car {
    private String color;
    private String[] listOfOptions;
    private final String MODEL;
    private final int YEAR;
    private int wheelSize;
    private final double ENGINE_VOLUME;


    Car(String color, String[] listOfOptions, String MODEL, int YEAR, int wheelSize, double ENGINE_VOLUME) {
        this.color = color;
        this.listOfOptions = listOfOptions;
        this.MODEL = MODEL;
        this.YEAR = YEAR;
        this.wheelSize = wheelSize;
        this.ENGINE_VOLUME = ENGINE_VOLUME;
    }

    Car(String color, String MODEL, int YEAR, int wheelSize, double ENGINE_VOLUME) {
      this(color, null, MODEL, YEAR, wheelSize, ENGINE_VOLUME);
    }

    public void printCar(){
        System.out.println("Цвет " + color);
        System.out.println("Модель " + MODEL);
        System.out.println("Год " + YEAR);
        System.out.println("Размер колёс " + wheelSize);
        System.out.println("Объём двигателя " + ENGINE_VOLUME);
         System.out.println("Список опций: ");
        for(int i = 0; i < listOfOptions.length; i++) {
            System.out.print(listOfOptions[i] + ", ");
        }
        System.out.println();
        System.out.println();
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setListOfOptions(String[] listOfOptions) {
        this.listOfOptions = listOfOptions;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getColor() {
        return color;
    }

    public String[] getListOfOptions() {
        return listOfOptions;
    }

    public String getModel() {
        return MODEL;
    }

    public int getYear() {
        return YEAR;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public double getEngineVolume() {
        return ENGINE_VOLUME;
    }
}




