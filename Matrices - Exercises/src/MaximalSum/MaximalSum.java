package MaximalSum;

import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[row][col];
        //create matrix
        for (int i = 0; i < row; i++) {
            String[] array = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = Integer.parseInt(array[j]);
            }

        }

        int maxIndexRow = 0;
        int maxIndexCol = 0;
        int maxSum = 0;
        for (int i = 0; i < row - 2; i++) { //col/2
            for (int j = 0; j < col - 2; j++) {
                int first = matrix[i][j];
                int second = matrix[i][j + 1];
                int third = matrix[i][j + 2];
                int fourth = matrix[i + 1][j];
                int fifth = matrix[i + 1][j + 1];
                int sixth = matrix[i + 1][j + 2];
                int seventh = matrix[i + 2][j];
                int eighth = matrix[i + 2][j + 1];
                int ninth = matrix[i + 2][j + 2];
                int sum = first + second + third + fourth + fifth + sixth + seventh + eighth +ninth;
                if (sum > maxSum) {
                    maxSum = sum;
                    maxIndexRow = i;
                    maxIndexCol = j;
                }

            }

        }

        System.out.println(maxSum);
        System.out.printf("%d %d %d\n", matrix[maxIndexRow][maxIndexCol], matrix[maxIndexRow][maxIndexCol + 1], matrix[maxIndexRow][maxIndexCol + 2]);
        System.out.printf("%d %d %d\n", matrix[maxIndexRow + 1][maxIndexCol], matrix[maxIndexRow + 1][maxIndexCol + 1],matrix[maxIndexRow + 1][maxIndexCol + 2]);
        System.out.printf("%d %d %d\n", matrix[maxIndexRow + 2][maxIndexCol], matrix[maxIndexRow + 2][maxIndexCol + 1],matrix[maxIndexRow + 2][maxIndexCol + 2]);
    }
}
