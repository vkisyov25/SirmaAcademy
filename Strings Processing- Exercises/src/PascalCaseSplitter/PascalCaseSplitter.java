package PascalCaseSplitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PascalCaseSplitter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Pattern pattern = Pattern.compile("[A-Z]{1}[a-z]+");
        Matcher matcher = pattern.matcher(text);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.printf("%s", list.get(i));
                break;
            }

            System.out.printf("%s,", list.get(i));
        }

    }
}
