package MagicSquareChecker;

import java.util.Scanner;

public class MagicSquareChecker {
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

        int sum = 0;
        int curSum = 0;
        //boolean isMagicSquare = true;
        //sum of secondary diagonal
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i + j == row - 1) {
                    curSum += matrix[i][j];
                }

            }

        }

        sum = curSum;
        curSum = 0;
        //sum of main diagonal
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == j) {
                    curSum += matrix[i][j];
                }

            }

        }

        if (sum != curSum) {
            System.out.println("False");
            //isMagicSquare = false;
            return;
        } else {
            curSum = 0;
        }

        //rows sum
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                curSum += matrix[i][j];
            }

            if (sum != curSum) {
                System.out.println("False");
                //isMagicSquare = false;
                return;
            } else {
                curSum = 0;
            }

        }

        //columns sum
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                curSum += matrix[i][j];
            }

            if (sum != curSum) {
                System.out.println("False");
                //isMagicSquare = false;
                return;
            } else {
                curSum = 0;
            }

        }

        //check
        //if (isMagicSquare) {
        System.out.println("True");
        //}else {
        //System.out.println("False");
        //}
    }
}

