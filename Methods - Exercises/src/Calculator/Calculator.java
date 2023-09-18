package Calculator;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        if (command.equals("add")) {
            System.out.println(add(firstNum,secondNum));
        } else if (command.equals("multiply")) {
            System.out.println(multiply(firstNum,secondNum));
        } else if (command.equals("subtract")) {
            System.out.println(subtract(firstNum,secondNum));
        } else if (command.equals("divide")) {
            System.out.println(divide(firstNum,secondNum));
        }
    }

    public static double add(int a, int b) {
        return a + b;
    }

    public static double multiply(int a, int b) {
        return a * b;
    }

    public static double subtract(int a, int b) {
        return a - b;
    }

    public static double divide(int a, int b) {
        return a / (double) b;
    }
}
