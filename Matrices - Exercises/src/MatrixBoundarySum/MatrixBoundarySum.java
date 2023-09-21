package MatrixBoundarySum;

import java.util.Scanner;

public class MatrixBoundarySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] array = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(array[j]);
            }

        }

        int boundarySum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1) {
                    boundarySum += matrix[i][j];
                }
                if ((j == 0 || j == col - 1) && i != 0 && i != row - 1) {
                    boundarySum += matrix[i][j];
                }

            }

        }

        System.out.println(boundarySum);
    }
}
