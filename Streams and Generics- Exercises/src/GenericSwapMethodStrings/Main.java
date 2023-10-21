package GenericSwapMethodStrings;

import GenericBox.Box;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Box1<String> stringBox1 = null;
        List<String> box1List = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String name = scanner.nextLine();
            stringBox1 = new Box1<>(name);
            box1List.add(String.valueOf(stringBox1));
        }

        String[] arr = scanner.nextLine().split(" ");
        int index1 = Integer.parseInt(arr[0]);
        int index2 = Integer.parseInt(arr[1]);
        stringBox1.swap(box1List, index1, index2);
        box1List.stream().forEach(e -> System.out.println(e));

    }
}
