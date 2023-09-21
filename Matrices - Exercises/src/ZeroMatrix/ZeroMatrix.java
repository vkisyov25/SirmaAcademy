package ZeroMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZeroMatrix {
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

        List<Integer> rowIndexList = new ArrayList<>();
        List<Integer> colIndexList = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowIndexList.add(i);
                    colIndexList.add(j);
                }

            }

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < rowIndexList.size(); k++) {
                    if (i == rowIndexList.get(k)) {
                        matrix[i][j] = 0;
                    }

                }

            }

        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                for (int k = 0; k < colIndexList.size(); k++) {
                    if (j == colIndexList.get(k)) {
                        matrix[i][j] = 0;
                    }

                }

            }

        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }

            System.out.println();
        }
    }
}
