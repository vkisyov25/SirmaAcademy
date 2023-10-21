package GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String name = scanner.nextLine();
            Box<String> stringBox = new Box<>(name);
            System.out.println(stringBox.toString());
        }

    }
}
