package MatchFullName;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] namesArr = scanner.nextLine().split(", ");
        for (int i = 0; i < namesArr.length; i++) {
            String name = namesArr[i];
            Pattern pattern = Pattern.compile("^[A-Z]{1}[a-z]+ [A-Z]{1}[a-z]+\\b");
            Matcher matcher = pattern.matcher(name);
            if (matcher.matches()) {
                System.out.println(matcher.group());
            }

        }

    }
}
