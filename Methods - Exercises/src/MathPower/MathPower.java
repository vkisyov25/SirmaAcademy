package MathPower;

import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double number = Integer.parseInt(scanner.nextLine());
        double pow = Integer.parseInt(scanner.nextLine());
        System.out.println(pow(number, pow));
    }

    public static double pow(double number, double pow) {
        return Math.pow(number, pow);
    }
}
