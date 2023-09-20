package MatchingBrackets;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split(" ");
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int startIndex=0;
        int  endIndex = 0;
        boolean isTrue = false;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i].equals("(")){
                stack.push(i);
            }
            if(arr[i].equals(")")){
                startIndex = stack.pop();
                endIndex = i;
                isTrue = true;
            }

            if(isTrue){
                isTrue = false;
                for (int j = startIndex; j <=endIndex ; j++) {
                    System.out.printf("%s ",arr[j]);
                }
                System.out.println();
            }
        }
    }
}
