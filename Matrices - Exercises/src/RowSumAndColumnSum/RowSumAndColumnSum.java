package RowSumAndColumnSum;

import java.util.Arrays;
import java.util.Scanner;

public class RowSumAndColumnSum {
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

        int[] arrRowSum = new int[row];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += matrix[i][j];
            }

            arrRowSum[i] = sum;
            sum = 0;
        }

        int[] arrColSum = new int[col];
        int sum1 = 0;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                sum += matrix[j][i];
            }

            arrColSum[i] = sum;
            sum = 0;

        }

        System.out.println(Arrays.toString(arrRowSum));
        System.out.println(Arrays.toString(arrColSum));


    }
}
