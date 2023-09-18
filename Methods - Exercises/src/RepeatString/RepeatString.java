package RepeatString;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(increaseText(text, n));

    }

    public static String increaseText(String text, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(text);
        }

        return stringBuilder.toString();
    }
}
