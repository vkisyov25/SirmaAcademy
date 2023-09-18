package GreaterOfTwoValues;

import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();

        if (type.equals("int")) {
            int firstNum = Integer.parseInt(scanner.nextLine());
            int secondNum = Integer.parseInt(scanner.nextLine());
            System.out.println(getMax(firstNum,secondNum));
        } else if (type.equals("char")) {
            char firstChar = scanner.nextLine().charAt(0);
            char secondChar = scanner.nextLine().charAt(0);
            System.out.println(getMax(firstChar,secondChar));
        } else if (type.equals("string")) {
            String firstName = scanner.nextLine();
            String secondName = scanner.nextLine();
            System.out.println(getMax(firstName,secondName));

        }
    }

    //This is overload of methods
    public static int getMax(int a, int b){
        if(a>b){
            return a;
        }
        return b;
    }
    public static char getMax(char a, char b){

        int result = Character.compare(a, b);
        if (result == 0) {
            return a;
        } else if (result < 0) {
            return b;
        }
        return 'a';
    }
    public static String getMax(String a, String b){

        int result = a.compareTo(b);
        if (result > 0) {
            return a;
        } else if (result < 0) {
            return b;
        }
        return "the words are same";
    }


}
