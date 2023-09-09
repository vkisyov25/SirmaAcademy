import java.util.Scanner;

public class ArmstrongNumberCheck {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strNum = scanner.nextLine();
        int number = Integer.parseInt(strNum);
        int startNum = number;
        int sum=0;
        while (number!=0){
            sum += (int) Math.pow(number%10,strNum.length());

            number /=10;
        }

        System.out.println(sum==startNum);
    }
}
