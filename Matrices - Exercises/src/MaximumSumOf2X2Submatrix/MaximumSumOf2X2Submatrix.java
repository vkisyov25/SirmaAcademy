package MaximumSumOf2X2Submatrix;

import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
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

        int maxIndexRow = 0;
        int maxIndexCol = 0;
        int maxSum = 0;
        for (int i = 0; i < row - 1; i++) { //col/2
            for (int j = 0; j < col - 1; j++) {
                int cur = matrix[i][j];
                int next = matrix[i][j + 1];
                int nextBot = matrix[i + 1][j];
                int last = matrix[i + 1][j + 1];
                int sum = cur + next + nextBot + last;
                if (sum > maxSum) {
                    maxSum = sum;
                    maxIndexRow = i;
                    maxIndexCol = j;
                }

            }

        }

        System.out.println(maxSum);
        System.out.printf("%d %d\n", matrix[maxIndexRow][maxIndexCol], matrix[maxIndexRow][maxIndexCol + 1]);
        System.out.printf("%d %d\n", matrix[maxIndexRow + 1][maxIndexCol], matrix[maxIndexRow + 1][maxIndexCol + 1]);
    }
}
