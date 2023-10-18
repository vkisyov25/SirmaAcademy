package GenericCountMethodStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenericCountMethodDoublesMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Box2<Double> stringBox2 = null;
        List<Double> box2List = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Double text = Double.parseDouble(scanner.nextLine());
            stringBox2 = new Box2<>(text);
            box2List.add(Double.parseDouble(String.valueOf(stringBox2)));
        }

        Double text = Double.parseDouble(scanner.nextLine());
        System.out.println(stringBox2.count(box2List,text));
    }
}
