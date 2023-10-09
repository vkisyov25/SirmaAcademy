package GenericBox;

import java.util.Scanner;

public class GenericBoxOfIntegerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            Box<Integer> stringBox = new Box<>(num);
            System.out.println(stringBox.toString());
        }
    }
}
