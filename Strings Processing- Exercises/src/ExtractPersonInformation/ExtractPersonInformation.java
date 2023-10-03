package ExtractPersonInformation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile("(?<name>@[A-za-z]+\\|)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                sb.append(matcher.group(1));
                System.out.printf("%s is ", sb.substring(1, sb.length() - 1));
            }

            sb = new StringBuilder();
            Pattern pattern1 = Pattern.compile("(?<age>#[0-9]+\\*)");
            Matcher matcher1 = pattern1.matcher(input);
            if (matcher1.find()) {
                sb.append(matcher1.group(1));
                System.out.printf("%s years old\n", sb.substring(1, sb.length() - 1));
            }

        }

    }
}
