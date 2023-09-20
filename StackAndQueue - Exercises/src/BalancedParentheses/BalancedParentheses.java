package BalancedParentheses;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '(' || text.charAt(i) == '{' || text.charAt(i) == '[') {
                stack.push(text.charAt(i));
            } else if (text.charAt(i) == ')' || text.charAt(i) == '}' || text.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    System.out.println("Stack is empty");
                    return;
                }
                char top = stack.pop();
                if ((text.charAt(i) == ')' && top != '(') || (text.charAt(i) == '}' && top != '{') || (text.charAt(i) == ']' && top != '[')) {
                    isBalanced = false;
                }
            }
        }
        if (isBalanced) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
