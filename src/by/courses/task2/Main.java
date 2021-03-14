package by.courses.task2;

public class Main {
    public static void main(String[] args) {
        int i, n = 7;
        int sum = 0;
        int array[] = new int[9];
        for (i = 0; i < array.length; i++) {
            array[i] = i;
            if (i > 1) {
                array[i] = array[i - 1] + array[i - 2];
            }
            if (i < n && array[i] % 2 == 0) {
                sum = sum + array[i];
            }
            System.out.print(array[i] + " ");
        }
        System.out.println("summ = " + sum);
    }
}

