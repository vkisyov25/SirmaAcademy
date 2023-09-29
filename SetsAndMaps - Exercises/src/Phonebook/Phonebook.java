package Phonebook;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, String> map = new HashMap<>();
        while (!input.equals("stop")) {
            String[] arr = input.split("-");
            if (arr.length == 2) {
                map.put(arr[0], arr[1]);
            } else {
                if (!input.equals("search")) {
                    if (!map.containsKey(input)) {
                        System.out.printf("Contact %s not found.\n", input);
                    } else {
                        System.out.printf("%s -> %s\n", input, map.get(input));
                    }

                }

            }

            input = scanner.nextLine();
        }


    }
}
