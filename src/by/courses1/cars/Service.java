package by.courses1.cars;

public class Service {
    public void addOption(Car car, String option) {
        String[] currentListOfOptions = car.getListOfOptions();
        if (currentListOfOptions != null) {
            String[] newListOfOptions = new String[currentListOfOptions.length + 1];
            for (int i = 0; i < currentListOfOptions.length; i++) {
                newListOfOptions[i] = currentListOfOptions[i];
            }
            newListOfOptions[currentListOfOptions.length] = option;
            car.setListOfOptions(newListOfOptions);
        } else {
            String[] newListOfOptions = new String[1];
            newListOfOptions[0] = option;
            car.setListOfOptions(newListOfOptions);
        }
    }

    public void deleteOption(Car car, String option) {
        String[] currentListOfOptions = car.getListOfOptions();
        String[] newListOfOptions = new String[currentListOfOptions.length - 1];
        for (int i = 0, j = 0; i < currentListOfOptions.length; i++, j++) {
            if (currentListOfOptions[i] != option) {
                newListOfOptions[j] = currentListOfOptions[i];
            } else {
                j--;
            }
        }
        car.setListOfOptions(newListOfOptions);
    }

    public void changeColor(Car car, String color) {
        car.setColor(color);
    }

    public void changeWheelSize(Car car, int wheelSize) {
        car.setWheelSize(wheelSize);
    }
}
