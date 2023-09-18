package PasswordValidator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        boolean isValid = true;
        //passValidator(password,isValid);
        isValid = passValidator(password, isValid);
        //passValidator1(password,isValid);
        isValid = passValidator1(password, isValid);
        //passValidator2(password,isValid);
        isValid = passValidator2(password, isValid);
        isValid(isValid);

    }

    private static void isValid(boolean isValid) {
        if (isValid) {
            System.out.println("Password is valid.");
        }
    }

    private static boolean passValidator2(String password, boolean isValid) {
        //boolean isValid = true;
        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }

        if (digitCount < 2) {
            System.out.println("Password must have at least 2 digits.");
            isValid = false;
            return isValid;
        }
        return isValid;
    }

    private static boolean passValidator1(String password, boolean isValid) {
        //boolean isValid = true;
        Pattern pattern = Pattern.compile("\\b[A-Za-z0-9]+\\b");
        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches()){
            System.out.println("Password must contain only letters and digits.");
            isValid = false;
            return isValid;
        }
        return isValid;

    }


    private static boolean passValidator(String password, boolean isValid) {
        //boolean isValid;
        if (password.length() < 6 || password.length() > 10) {
            System.out.println("Password must be between 6 and 10 characters.");
            isValid = false;
            return isValid;
        }
        return isValid;
    }
}
