package ChessboardChecker;

import java.util.Scanner;

public class ChessboardChecker {
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

        int sumRow = 0;
        int sumCol = 0;
        //rows and columns sum
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sumRow += matrix[i][j];
                sumCol += matrix[j][i];
            }

            if (sumRow > 1 || sumCol > 1) {
                System.out.println("Yes");
                return;
            } else {
                sumRow = 0;
                sumCol = 0;
            }

        }

        // Check diagonals
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 1 && isDiagonalThreatened(matrix, i, j)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }

        System.out.println("No");
    }

    private static boolean isDiagonalThreatened(int[][] chessboard, int row, int col) {
        int rows = chessboard.length;
        int cols = chessboard[0].length;

        // Check upper-left diagonal(main diagonal)
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 1) {
                return true;
            }
        }

        // Check upper-right diagonal(secondary diagonal)
        for (int i = row - 1, j = col + 1; i >= 0 && j < cols; i--, j++) {
            if (chessboard[i][j] == 1) {
                return true;
            }
        }

        return false;
    }

}
