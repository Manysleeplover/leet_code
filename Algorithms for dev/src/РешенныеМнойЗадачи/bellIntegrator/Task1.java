package РешенныеМнойЗадачи.bellIntegrator;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

        drawMatrix(10);
    }

    public static void drawMatrix(int n) {
        int matrixSize = (n + 1) * 2;
        int[][] matrix = new int[matrixSize][matrixSize];
        if (n < 0) {
            System.out.println("Invalid input: " + n);
        }
        if (n == 0) {
            System.out.println(Arrays.deepToString(matrix));
        }
        int counter = n;
        int inner = 0;
        while (counter > 0) {
            fillMatrix(matrix, counter, inner);
            counter--;
            inner++;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void fillMatrix(int[][] matrix, int n, int inner) {
        for (int i = inner; i < matrix.length - inner; i++) {
            matrix[inner][i] = n;
        }
        for (int i = inner; i < matrix.length - inner; i++) {
            matrix[i][inner] = n;
        }
        for (int i = inner; i < matrix.length - inner; i++) {
            matrix[matrix.length - 1 - inner][i] = n;
        }
        for (int i = inner; i < matrix.length - inner ; i++) {
                matrix[i][matrix.length - 1 - inner] = n;
        }
    }
}
