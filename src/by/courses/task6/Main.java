package by.courses.task6;

public class Main {
    public static void main(String[] args) {
        int array_1[][] = {
                {1, 2, 3},
                {1, 2, 1},
                {1, 3, 4}
        };
        int array_2[][] = {
                {1, 2, 3},
                {2, 3, 2},
                {1, 1, 1}
        };
        int arraySum[][] = new int[3][3];
        int arrayDiff[][] = new int[3][3];
        for (int i = 0; i < array_1.length; i++) {
            for (int j = 0; j < array_1[i].length; j++) {
                arraySum[i][j] = array_1[i][j] + array_2[i][j];
                arrayDiff[i][j] = array_1[i][j] - array_2[i][j];
            }
        }
        System.out.println("Сумма матиц");
        for (int i = 0; i < arraySum.length; i++) {
            for (int j = 0; j < arraySum[i].length; j++) {
                System.out.print(arraySum[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nРазность матиц");
        for (int i = 0; i < arrayDiff.length; i++) {
            for (int j = 0; j < arrayDiff[i].length; j++) {
                System.out.print(arrayDiff[i][j] + " ");
            }
            System.out.println();
        }
    }
}

