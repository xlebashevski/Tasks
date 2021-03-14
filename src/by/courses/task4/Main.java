package by.courses.task4;

public class Main {
    public static void main(String[] args) {
        int negative = 0, positive = 0;
        int array[][] = {
                {3, -2, -6},
                {5, 1, 3}
        };
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (array[i][j] > 0) {
                    positive++;
                } else {
                    negative++;
                }
            }
        }
        if (positive > negative) {
            System.out.println("Положительных больше");
        } else if (positive == negative) {
            System.out.println("Поровну");
        } else {
            System.out.println("Отрицательных больше");
        }
    }
}

