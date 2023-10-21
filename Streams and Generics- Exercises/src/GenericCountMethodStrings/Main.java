package GenericCountMethodStrings;

import GenericBox.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Box2<String> stringBox2 = null;
        List<String> box2List = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String text = scanner.nextLine();
            stringBox2 = new Box2<>(text);
            box2List.add(String.valueOf(stringBox2));
        }

        String text = scanner.nextLine();
        System.out.println(stringBox2.count(box2List,text));
    }
}
