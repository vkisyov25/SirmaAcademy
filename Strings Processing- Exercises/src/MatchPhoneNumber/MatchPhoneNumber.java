package MatchPhoneNumber;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputArr = scanner.nextLine().split(", ");
        for (int i = 0; i < inputArr.length; i++) {
            String input = inputArr[i];
            Pattern pattern = Pattern.compile("^(\\+359 \\d{1} \\d{3} \\d{4})\\b");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s\n", matcher.group());
            }

            Pattern pattern1 = Pattern.compile("^(\\+359-\\d{1}-\\d{3}-\\d{4})\\b");
            Matcher matcher1 = pattern1.matcher(input);
            if (matcher1.find()) {
                System.out.printf("%s\n", matcher1.group());
            }
        }
    }
}
