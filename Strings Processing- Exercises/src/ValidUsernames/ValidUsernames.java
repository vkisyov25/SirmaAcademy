package ValidUsernames;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputUsername = scanner.nextLine().split(", ");
        for (int i = 0; i < inputUsername.length; i++) {
            String username = inputUsername[i];
            Pattern pattern = Pattern.compile("^[A-Za-z_0-9-]*\\b");
            Matcher matcher = pattern.matcher(username);
            if (matcher.matches() && (username.length() >= 3 && username.length() <= 16)) {
                System.out.println(username);
            }

        }

    }
}
