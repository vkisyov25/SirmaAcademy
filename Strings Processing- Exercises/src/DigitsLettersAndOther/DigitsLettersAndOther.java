package DigitsLettersAndOther;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        List<Character> digitList = new ArrayList<>();
        List<Character> letterList = new ArrayList<>();
        List<Character> other = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                digitList.add(text.charAt(i));
            } else if (Character.isLetter(text.charAt(i))) {
                letterList.add(text.charAt(i));
            } else {
                other.add(text.charAt(i));
            }

        }

        digitList.stream().forEach(e -> System.out.printf("%c", e));
        System.out.println();
        letterList.stream().forEach(e -> System.out.printf("%c", e));
        System.out.println();
        other.stream().forEach(e -> System.out.printf("%c", e));
    }
}
