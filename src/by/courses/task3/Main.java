package by.courses.task3;

public class Main {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 6, 5, 21, 5};
        for (int i = array.length - 1; i < array.length; i--) {
            if (i >= 0) {
                System.out.print(array[i] + " ");
            }
        }
    }
}

