package GenericArrayCreator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringArr = ArrayCreator.<String>create(String.class, 5, "Pesho");
        Integer[] integerArr = ArrayCreator.create(5, new Integer(12));

        Arrays.stream(stringArr).forEach(e -> System.out.println(e));
        System.out.println("....................................................");
        Arrays.stream(integerArr).forEach(e -> System.out.println(e));
    }
}
