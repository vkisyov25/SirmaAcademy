package PrinterQueue;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
        while (!command.equals("print")) {
            if (!command.equals("cancel")) {
                queue.add(command);
            } else {
                if (queue.size() > 0) {
                    System.out.printf("Canceled %s\n",queue.remove());
                } else {
                    System.out.println("Stanby");
                }
            }


            command = scanner.nextLine();
        }

    }
}
