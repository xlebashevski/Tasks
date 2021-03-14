package by.courses.task3;

public class Main {
    public static void main(String[] args) {
        int array[] = {1, 2, 3, 4, 5, 6, 7};
        int array_1[] = new int [array.length];
        for (int i = array.length - 1; i < array.length; i--) {
            if (i >= 0) {
                array_1[i] = array[i];
                System.out.print(array_1[i] + " ");
            }
        }
    }
}

