package CaesarCipher;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int asciNum = text.charAt(i);
            char ch = (char) (asciNum+3);
            sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}
