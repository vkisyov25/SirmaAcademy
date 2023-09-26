package Snowflakes;

import java.util.Scanner;

public class Snowflakes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            String[] array = scanner.nextLine().split(" ");
            for (int j = 0; j < col; j++) {
                matrix[i][j] = array[j];
            }

        }

        for (int i= 0; i < col; i++) {
            for (int j = 0; j < row-1; j++) {
                if(matrix[j][i].equals("*") && matrix[j+1][i].equals("0")){
                    String temp = matrix[j][i];
                    matrix[j][i] = matrix[j+1][i];
                    matrix[j+1][i] = temp;
                }
            }

        }


        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.printf("%s ",matrix[i][j]);
            }
            System.out.println();
        }
    }
}
