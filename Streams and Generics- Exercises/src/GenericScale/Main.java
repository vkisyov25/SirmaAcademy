package GenericScale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scale<String>  stringScale = new Scale<>("12", "15");
        System.out.println(stringScale.getHeavier());
        System.out.println("...................................................");
        Scale<Integer> integerScale = new Scale<>(20,25);
        System.out.println(integerScale.getHeavier());
    }
}
