package by.courses.task1;

public class Main {


    public static void main(String[] args) {
        int n = 44;
        int sum = 0;
        int array[] = {12, 32, 44, 11, 1, 2};
        for (int i = 0; i < array.length; i++) {
            if (array[i] != n) {
                sum = sum + array[i];
            }
        }
        System.out.print(sum);
    }
}


