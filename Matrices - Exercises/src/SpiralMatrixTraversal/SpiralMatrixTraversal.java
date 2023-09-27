package SpiralMatrixTraversal;

import java.util.Scanner;

public class SpiralMatrixTraversal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            String[] array = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(array[j]);
            }

        }

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;


        while (top <= bottom && left <= right) {
            // Print top row
            for (int i = left; i <= right; i++) {
                System.out.print(matrix[top][i] + " ");
            }

            top++;

            // Print right column
            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][right] + " ");
            }

            right--;

            // Print bottom row
            for (int i = right; i >= left; i--) {
                System.out.print(matrix[bottom][i] + " ");
            }

            bottom--;


            // Print left column
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " ");
            }

            left++;
        }
    }
}
