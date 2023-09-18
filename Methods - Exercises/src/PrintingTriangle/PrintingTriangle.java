package PrintingTriangle;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        upPrintTriangle(num);
        downPrintTriangle(num);
    }

    public static void upPrintTriangle(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%d", j + 1);
            }
            System.out.println();
        }
    }

    public static void downPrintTriangle(int n) {
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%d", j + 1);
            }
            System.out.println();
        }
    }
}
