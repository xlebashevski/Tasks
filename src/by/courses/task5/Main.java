package by.courses.task5;

public class Main {
    public static void main(String[] args) {
        int array[][] = {
                {1, 0, 0},
                {0, 3, 0},
                {0, 0, 6},
        };
        boolean isLowerTriangularMatrix = true;
        boolean isSquare = true;
        for (int i = 0; i < array.length; i++) {
            int j = array[i].length;
            if (j != array.length) {
                isSquare = false;
            }
        }
        if (isSquare) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] != 0 && i < j) {
                        isLowerTriangularMatrix = false;
                    }
                }
            }
            if (isLowerTriangularMatrix) {
                System.out.println("Нижняя треугольная матрица");
            } else {
                System.out.println("Не является нижней треугольной матрицой");
            }
        } else {
            System.out.println("Матрица не квадратная");
        }
    }
}

