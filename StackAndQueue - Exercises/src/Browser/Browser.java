package Browser;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Browser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        ArrayDeque<String> stack = new ArrayDeque<>();
        while (!command.equals("Home")) {
            if (!command.equals("back")) {
                stack.push(command);
                System.out.println(command);
            } else {
                stack.pop();
                if (stack.size() > 0) {
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }


            command = scanner.nextLine();
        }


    }
}
