package by.courses.Task7;

public class Main {
    public static void main(String[] args) {
        int array[] = {12, 0, 4, 8, 0, 1, 98, 1, 1};
        int sum_1 = 0;
        int sum_2 = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                sum_1 = sum_1 + array[i];
            } else {
                sum_2 = sum_2 + array[i];
            }
        }
        if (sum_1 > sum_2) {
            System.out.println(sum_1);
        } else {
            System.out.println(sum_2);
        }
    }
}


