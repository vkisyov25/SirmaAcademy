package DecimalToBinaryConverter;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int remainder =0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        while (num != 0){
            remainder = num%2;
            stack.push(remainder);
            num = num/2;
        }

        while (stack.size()!=0){
            System.out.printf("%d ",stack.poll());
        }
    }
}
